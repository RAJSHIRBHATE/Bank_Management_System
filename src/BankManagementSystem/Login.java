package BankManagementSystem;

import javax.swing.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);
        // "C:\Users\VICTUS\IdeaProjects\Bank Management System\src\BankManagementSystem\icons\logo.jpg"


        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120,150,400,45);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 45);
        cardTextField.setFont(new Font("Arial", Font.BOLD,18));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(120,220,250,45);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 45);
        pinTextField.setFont(new Font("Arial", Font.BOLD,18));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300, 100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300, 100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350, 230,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.white);


        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
    }



    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+ cardnumber +"' and pin = '"+ pinnumber +"' ";
            try {
               ResultSet rs =  conn.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
               }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}
