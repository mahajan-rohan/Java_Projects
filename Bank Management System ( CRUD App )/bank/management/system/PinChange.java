package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,920);
        add(image);
        
        JLabel text = new JLabel("Change your pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165,320,180,20);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,360,180,20);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
        setTitle("ATM");
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String newpin = pin.getText();
                String rpin = repin.getText();

                if(!newpin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new Pin");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new Pin");
                    return;
                }
                
                Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed succesfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            } catch(Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
                
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
