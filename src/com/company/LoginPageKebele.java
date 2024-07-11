package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class LoginPageKebele extends JFrame implements ActionListener {
    JLabel topic,username,password;
    JPasswordField passwordField;
    JButton login, back;
    JTextField usernamefield;
    public LoginPageKebele(){

        topic = new JLabel(" LOGIN PAGE INTO KEBELE");
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==login) {
            try {

                Registry registry = LocateRegistry.getRegistry("localhost", 6000);
                Interface1 stub = (Interface1) registry.lookup("server");
                List<KebeLogin> list = stub.getKebeLogin();
                for(KebeLogin ke :list){
                if (ke.getPass().equals(passwordField.getText())&& (usernamefield.getText().equals(ke.getUse()))){
                    new SecondPage();
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
            new FirstPage();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LoginPageKebele();
    }
}


class SecondPage extends JFrame implements ActionListener{
    JButton insert,update,display,back;
    JLabel tp;
    public SecondPage(){
        tp = new JLabel("Select Operations You Want");
        tp.setBounds(300,180,400,30);
        tp.setFont(new Font("Serif",Font.BOLD,29));
        add(tp);

        insert = new JButton("Register New Citizen");
        insert.setBounds(400,250,200,30);
        add(insert);
        insert.addActionListener(this);

        update = new JButton("Update citizen status");
        update.setBounds(400,300,200,30);
        add(update);
        update.addActionListener(this);

        display = new JButton("Display citizen Information");
        display.setBounds(400,350,200,30);
        add(display);
        display.addActionListener(this);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);

        setLayout(null);
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==insert ){
            new AgeValidate();
            setVisible(false);
        }
        else if(e.getSource()==display){

            new DisplayKebele();
            setVisible(false);
        }
        else if(e.getSource()==update){
            new UpdateKebele();
            setVisible(false);
        }
        else if (e.getSource()==back){
            new LoginPageKebele();
            setVisible(false);
        }

    }
}
