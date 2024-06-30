package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton r100,r500,r1000,r2000,r5000,r10k,back;
    String pinnumber;

    FastCash( String pinnumber){
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,925);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        r100 = new JButton("Rs 100");
        r100.setBounds(170,390,150,30);
        r100.addActionListener(this);
        image.add(r100);
        
        r500 = new JButton("Rs 500");
        r500.setBounds(335,390,150,30);
        r500.addActionListener(this);
        image.add(r500);
        
        r1000 = new JButton("Rs 1000");
        r1000.setBounds(335,425,150,30);
        r1000.addActionListener(this);
        image.add(r1000);
        
        r2000 = new JButton("Rs 2000");
        r2000.setBounds(170,425,150,30);
        r2000.addActionListener(this);
        image.add(r2000);
        
        r5000 = new JButton("Rs 5000");
        r5000.setBounds(170,460,150,30);
        r5000.addActionListener(this);
        image.add(r5000);
        
        r10k = new JButton("Rs 10000");
        r10k.setBounds(335,460,150,30);
        r10k.addActionListener(this);
        image.add(r10k);
        
        back = new JButton("Back");
        back.setBounds(335,495,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setTitle("ATM");
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
          if(ae.getSource() == back){
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          } else {
              String amount = ((JButton)ae.getSource()).getText().substring(3);
              try{
                  Conn c = new Conn();
                  ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                  int balance = 0; 
                  while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       } else if(rs.getString("type").equals("Withdrawl")) {
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                  }
                  if(ae.getSource()!= back && balance < Integer.parseInt(amount)){
                      JOptionPane.showMessageDialog(null, "Insufficient Balance !!!!!!!!\n" + balance);
                      return;
                  }
                  
                  Date date = new Date();
                  String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                  c.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                  
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              } catch(Exception e){
                  System.out.println(e);
              }
          }
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
}
