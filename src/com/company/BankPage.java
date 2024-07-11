package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankPage  extends JFrame implements ActionListener {
    JButton insert,back,display;
    JLabel tp;
    public BankPage(){
        tp = new JLabel("Where you want to go?");
        tp.setBounds(500,180,300,70);
        tp.setFont(new Font("Serif",Font.BOLD,29));
        add(tp);

        insert = new JButton("Go to Bank Job App Page");
        insert.setBounds(550,300,200,50);
        insert.setFocusPainted(false);
        add(insert);
        insert.addActionListener(this);


        display = new JButton("Go to Bank page");
        display.setBounds(550,350,200,50);
        display.setFocusPainted(false);
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

    public static void main(String[] args) {
        new BankPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==insert){
            new BankJobApplication();
            setVisible(false);
        }
        else if(e.getSource()==display){
            new BankLoginPage();
            setVisible(false);
        }
        else if(e.getSource()==back){
            new FirstPage();
            setVisible(false);
        }

    }
}
