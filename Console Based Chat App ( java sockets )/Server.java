import java.io.*;
import java.util.*;
import java.net.*;

class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    Socket socket = null;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String clientUserName;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // used to send
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // client sends
            this.clientUserName = bufferedReader.readLine();
            clientHandlers.add(this);
            broadcastMessage("Server : " + clientUserName + " has entered the chat");

        } catch (Exception e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messgeFromClient;

        while (socket.isConnected()) {
            try {
                messgeFromClient = bufferedReader.readLine();
                broadcastMessage(messgeFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.clientUserName.equals(clientUserName)) {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("Server : " + clientUserName + " has left the chat");

    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Server {
    ServerSocket server = null;

    public Server(ServerSocket serverss) {
        this.server = serverss;
    }

    public void startServer() {
        try {
            while (!server.isClosed()) {

                Socket socket = server.accept();
                System.out.println("A new Client is Connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeServerSocket() {
        try {
            if (server != null) {
                server.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();

    }
}