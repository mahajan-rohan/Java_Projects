package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener {
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        setSize(400,600); 
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
       
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(125,15,200,20);
        bank.setFont(new Font("System", Font.BOLD,20));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);
        
        try{
            Conn conn = new Conn();
            ResultSet rs1 = conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
            
            while(rs1.next()){
                card.setText("Card Number:  "+ rs1.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs1.getString("cardnumber").substring(12));
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        try{
            int balance = 0 ;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br>" + "<html>" );
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your Total Balance is Rs "+balance);
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
