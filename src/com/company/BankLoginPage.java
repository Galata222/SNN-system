package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class BankLoginPage extends JFrame implements ActionListener {
    JLabel topic,username,password;
    JPasswordField passwordField;
    JButton login, back;
    JTextField usernamefield;
    public BankLoginPage(){
        topic = new JLabel(" LOGIN PAGE INTO BANK");
        topic.setBounds(150,100,2000,100);
        topic.setFont(new Font("Serif",Font.BOLD,50));
        add(topic);

        username = new JLabel("UserName: ");
        username.setFont(new Font("Serif",Font.BOLD,24));
        usernamefield = new JTextField(30);

        username.setBounds(300,300,200,40);
        usernamefield.setBounds(450,300,200,30);
        add(username);
        add(usernamefield);

        password = new JLabel("Password");
        password.setFont(new Font("Serif",Font.BOLD,24));
        passwordField= new JPasswordField(30);
        password.setBounds(300,350,200,30);
        passwordField.setBounds(450,350,200,30);
        add(password);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(450,400,200,30);
        add(login);

        login.addActionListener(this);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);

        setLayout(null);
        setBackground(Color.GREEN);
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BankLoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try {

                Registry registry = LocateRegistry.getRegistry("localhost", 6000);
                Interface1 stub = (Interface1) registry.lookup("server");
                List<BankLogin> list = stub.getBankLogin();
                for(BankLogin ke :list){
                    if (ke.getPass().equals(passwordField.getText())&& (usernamefield.getText().equals(ke.getUse()))){
                        new JobDisplay();
                        setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Your enter incorrect password or username");
                    }
                }
            }
            catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else if (e.getSource()==back){
            new BankPage();
            setVisible(false);
        }
    }

}


