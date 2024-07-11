package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage extends JFrame implements ActionListener {
    JButton VitalEvent,herqa,kebele,bank, jobApp;
    JLabel label,label1,label2;
    public  FirstPage(){
        label = new JLabel("WELCOME TO THE");
        label.setBounds(550,50,500,50);
        label.setFont(new Font("Serif",Font.BOLD,30));
        add(label);

        label1 = new JLabel("SSN BASED NATIONAL INFORMATION");
        label1.setBounds(400,100,1000,80);
        label1.setFont(new Font("Serif",Font.BOLD,30));
        add(label1);
        label2 = new JLabel("VERIFICATION SYSTEM");
        label2.setBounds(530,150,800,70);
        label2.setFont(new Font("Serif",Font.BOLD,30));
        add(label2);

        bank = new JButton("Bank");
        bank.setBounds(550,300,300,50);
        bank.addActionListener(this);
        bank.setFont(new Font("Serif",Font.BOLD,24));
        bank.setFocusPainted(false);

        add(bank);

        herqa = new JButton("Herqa");
        herqa.setBounds(550,350,300,50);
        herqa.addActionListener(this);
        herqa.setFont(new Font("Serif",Font.BOLD,24));
        herqa.setFocusPainted(false);
        add(herqa);

        kebele = new JButton("kebele");
        kebele.setBounds(550,400,300,50);
        kebele.addActionListener(this);
        kebele.setFont(new Font("Serif",Font.BOLD,24));
        kebele.setFocusPainted(false);
        add(kebele);

        VitalEvent = new JButton("VER Agency");
        VitalEvent.setBounds(550,450,300,50);
        VitalEvent.addActionListener(this);
        VitalEvent.setFont(new Font("Serif",Font.BOLD,24));
        VitalEvent.setFocusPainted(false);
        add(VitalEvent);



        setLayout(null);
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==herqa){
            new HerqaLoginPage();
            setVisible(false);

        }
        else if (e.getSource()==kebele){
            new LoginPageKebele();
            setVisible(false);
        }
        else if (e.getSource()==VitalEvent){
            new VitalLoginPage();
            setVisible(false);
        }
        else if (e.getSource()==bank){
            new BankPage();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new FirstPage();
    }

}

