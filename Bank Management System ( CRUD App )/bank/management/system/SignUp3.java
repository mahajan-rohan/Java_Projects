package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignUp3(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel title = new JLabel("Page 3 : Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(280, 40, 400, 40);
        add(title);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel cardNum = new JLabel("Card Number :");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNum.setBounds(100, 270, 200, 30);
        add(cardNum);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4186");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 280, 300, 20);
        add(number);

        JLabel cardInfo = new JLabel("Your 16 Digit Card Number");
        cardInfo.setFont(new Font("Raleway", Font.BOLD, 16));
        cardInfo.setBounds(100, 300, 300, 20);
        add(cardInfo);

        JLabel pin = new JLabel("Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 340, 300, 30);
        add(pin);

        JLabel pinNum = new JLabel("XXXX");
        pinNum.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNum.setBounds(330, 350, 300, 20);
        add(pinNum);

        JLabel pinInfo = new JLabel("Your 4 Digit Pin Number");
        pinInfo.setFont(new Font("Raleway", Font.BOLD, 16));
        pinInfo.setBounds(100, 360, 300, 30);
        add(pinInfo);

        JLabel req = new JLabel("Services Required :");
        req.setFont(new Font("Raleway", Font.BOLD, 22));
        req.setBounds(100, 420, 300, 30);
        add(req);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 470, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 470, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 520, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 520, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 570, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 570, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 630, 520, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(100, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(250, 700, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setTitle("New Account Application Form - Page 3");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accType = null;
            if (r1.isSelected()) {
                accType = "Savings Account";
            } else if (r2.isSelected()) {
                accType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accType = "Current Account";
            } else if (r4.isSelected()) {
                accType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facilties = "";
            if (c1.isSelected()) {
                facilties = facilties + " ATM Card";
            } else if (c2.isSelected()) {
                facilties = facilties + " Internet Banking";
            } else if (c3.isSelected()) {
                facilties = facilties + " Mobile Banking";
            } else if (c4.isSelected()) {
                facilties = facilties + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facilties = facilties + " Cheque Book";
            } else if (c6.isSelected()) {
                facilties = facilties + " E-statement";
            }

            try {
                if (accType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn(); //DML command
                    String query1 = "insert into signupthree values('" + formno + "','" + accType + "','" + cardnumber + "','" + pinnumber + "','" + facilties + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card number: " + cardnumber + "\n Pin:" + pinnumber);

                }
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);;
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignUp3("");
    }
}
