package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, exisitingaccyes, exisitingaccno, other;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignUp2(String formno) {

        this.formno = formno;
        
        setLayout(null);

        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 300, 30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion : ");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);

        String valueReligion[] = {"Hindu", "Muslim", "Sikh", "Christan", "Other"};
        religion = new JComboBox(valueReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cate = new JLabel("Category : ");
        cate.setFont(new Font("Raleway", Font.BOLD, 20));
        cate.setBounds(100, 190, 200, 30);
        add(cate);

        String valueCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valueCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incom = new JLabel("Income : ");
        incom.setFont(new Font("Raleway", Font.BOLD, 20));
        incom.setBounds(100, 240, 200, 30);
        add(incom);

        String valueIncome[] = {"Null", "< 1,50,00₹", "< 2,50,000₹", "< 5,00,000₹", "Upto 10,00,000₹"};
        income = new JComboBox(valueIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        JLabel qual = new JLabel("Qualification : ");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);

        String edValue[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(edValue);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occup = new JLabel("Occupation : ");
        occup.setFont(new Font("Raleway", Font.BOLD, 20));
        occup.setBounds(100, 390, 200, 30);
        add(occup);

        String occupValue[] = {"Salaried", "Self-Employmed", "Post-Graduate", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupValue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel panno = new JLabel("PAN number : ");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel aadno = new JLabel("Aadhar Number : ");
        aadno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadno.setBounds(100, 490, 200, 30);
        add(aadno);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel sencit = new JLabel("Senior Citizen : ");
        sencit.setFont(new Font("Raleway", Font.BOLD, 20));
        sencit.setBounds(100, 540, 200, 30);
        add(sencit);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sengroup = new ButtonGroup();
        sengroup.add(syes);
        sengroup.add(sno);

        JLabel extacc = new JLabel("Exisiting Account : ");
        extacc.setFont(new Font("Raleway", Font.BOLD, 20));
        extacc.setBounds(100, 590, 200, 30);
        add(extacc);

        exisitingaccyes = new JRadioButton("Yes");
        exisitingaccyes.setBounds(300, 590, 100, 30);
        exisitingaccyes.setBackground(Color.WHITE);
        add(exisitingaccyes);

        exisitingaccno = new JRadioButton("No");
        exisitingaccno.setBounds(450, 590, 100, 30);
        exisitingaccno.setBackground(Color.WHITE);
        add(exisitingaccno);
        
        ButtonGroup exisgroup = new ButtonGroup();
        exisgroup.add(exisitingaccno);
        exisgroup.add(exisitingaccyes);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
//        String formno = "" + randomNum;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }

        String sexistingaccount = null;
        if (exisitingaccyes.isSelected()) {
            sexistingaccount = "Yes";
        } else if (exisitingaccno.isSelected()) {
            sexistingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            if (sreligion.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            if (scategory.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }
            if (sincome.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }
            if (seducation.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            if (soccupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            if (seniorCitizen.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            if (sexistingaccount.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            }
            if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } else {
                Conn c = new Conn(); //DML command
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorCitizen + "','" + sexistingaccount + "')";
                c.s.executeUpdate(query);
                
                //SignUp3 object
                 setVisible(false);
                 new SignUp3(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignUp2("");
    }
}
