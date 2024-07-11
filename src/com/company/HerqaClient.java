package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class HerqaClient extends JFrame implements ActionListener {
    JLabel ssn,fname,mname,lname, sex, age,Grade12result ,Grade8result,Grade10result,cgpa,
    Instituteofgraduation,Departement,Yeargraduation,Educationstatus;
     JTextField ssnf,fnamef,mnamef,lnamef, sexf, agef,Grade12resultf ,Grade8resultf,Grade10resultf,cgpaf,
             Instituteofgraduationf,Departementf,Yeargraduationf,Educationstatusf;
     JButton insert,back;
     public HerqaClient(){
         ssn=new JLabel("SSN");
         ssnf=new JTextField(50);
         ssn.setBounds(50,50,100,30);
         ssnf.setBounds(150,50,150,30);
         add(ssn);
         add(ssnf);

         fname=new JLabel("First Name");
         fnamef=new JTextField(50);
         fname.setBounds(50,100,100,30);
         fnamef.setBounds(150,100,150,30);
         add(fname);
         add(fnamef);

         mname=new JLabel("Middle Name");
         mnamef=new JTextField(50);
         mname.setBounds(50,150,100,30);
         mnamef.setBounds(150,150,150,30);
         add(mname);
         add(mnamef);

         lname=new JLabel("Last Name");
         lnamef=new JTextField(30);
         lname.setBounds(50,200,100,30);
         lnamef.setBounds(150,200,150,30);
         add(lname);
         add(lnamef);

         sex=new JLabel("Sex");
         sexf=new JTextField(30);
         sex.setBounds(50,250,100,30);
         sexf.setBounds(150,250,150,30);
         add(sex);
         add(sexf);

         age=new JLabel("Age");
         agef=new JTextField(30);
         age.setBounds(50,300,100,30);
         agef.setBounds(150,300,150,30);
         add(age);
         add(agef);

         Grade8result=new JLabel("Grade 8 Resuslt");
         Grade8resultf=new JTextField(30);
         Grade8result.setBounds(50,350,100,30);
         Grade8resultf.setBounds(150,350,150,30);
         add(Grade8result);
         add(Grade8resultf);

         Grade10result=new JLabel("Grade 10 Result");
         Grade10resultf=new JTextField(30);
         Grade10result.setBounds(50,400,100,30);
         Grade10resultf.setBounds(150,400,150,30);
         add(Grade10result);
         add(Grade10resultf);

         Grade12result=new JLabel("Grade 12 Result");
         Grade12resultf=new JTextField(30);
         Grade12result.setBounds(50,450,100,30);
         Grade12resultf.setBounds(150,450,150,30);
         add(Grade12result);
         add(Grade12resultf);

         cgpa=new JLabel("CGPA");
         cgpaf=new JTextField(30);
         cgpa.setBounds(50,500,100,30);
         cgpaf.setBounds(150,500,150,30);
         add(cgpa);
         add(cgpaf);

         Instituteofgraduation=new JLabel("Institute of Graduation:");
         Instituteofgraduationf=new JTextField(30);
         Instituteofgraduation.setBounds(50,550,100,30);
         Instituteofgraduationf.setBounds(150,550,150,30);
         add(Instituteofgraduation);
         add(Instituteofgraduationf);

         Departement=new JLabel("Department");
         Departementf=new JTextField(30);
         Departement.setBounds(600,50,100,30);
         Departementf.setBounds(700,50,150,30);
         add(Departement);
         add(Departementf);

         Yeargraduation=new JLabel("Year Graduation");
         Yeargraduationf=new JTextField(30);
         Yeargraduation.setBounds(600,100,100,30);
         Yeargraduationf.setBounds(700,100,150,30);
         add(Yeargraduation);
         add(Yeargraduationf);

         Educationstatus=new JLabel("Education Status");
         Educationstatusf=new JTextField(30);
         Educationstatus.setBounds(600,150,100,30);
         Educationstatusf.setBounds(700,150,150,30);
         add(Educationstatus);
         add(Educationstatusf);

         insert=new JButton("Submit");
         add(insert);
         insert.addActionListener(this);
         insert.setBounds(710,250,100,30);

         back=new JButton("<<Back");
         back.setBounds(700,600,100,30);
         add(back);
         back.addActionListener(this);

         setLayout(null);
         setTitle("Herqa client");
         setSize(1000,1500);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert) {

            try {
                // JDBC driver name and database URL
                String DB_URL = "jdbc:mysql://localhost:3306/herqa";
                String data = "INSERT INTO `moshe`(`SSN`, `First Name`, `Middle Name`, `Last Name`, " +
                        "`Sex`, `Age`, `Grade 8 result`, `Grade 10 result`, `Grade 12 result`, `Institute of Graduation`, " +
                        "`Department`, `Cgpa`, `Year of Graduation`, `Education status`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                // Database credentials
                String USER = "root";
                String PASS = "";

                Connection conn = null;

                //Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement statement = conn.prepareStatement(data);
                statement.setInt(1, Integer.parseInt(ssnf.getText()));
                statement.setString(2, fnamef.getText());
                statement.setString(3, mnamef.getText());
                statement.setString(4, lnamef.getText());
                statement.setString(5, sexf.getText());
                statement.setInt(6, Integer.parseInt(agef.getText()));
                statement.setFloat(7, Float.parseFloat(Grade8resultf.getText()));
                statement.setFloat(8, Float.parseFloat(Grade10resultf.getText()));
                statement.setFloat(9, Float.parseFloat(Grade12resultf.getText()));                statement.setInt(10, Integer.parseInt(agef.getText()));
                statement.setString(10, Instituteofgraduationf.getText());
                statement.setString(11, Departementf.getText());
                statement.setFloat(12, Float.parseFloat(cgpaf.getText()));
                statement.setString(13, Yeargraduationf.getText());
                statement.setString(14, Educationstatusf.getText());
                statement.executeUpdate();

            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        else if (e.getSource() == back) {
            new SecondPageH();
            setVisible(false);
        }
    }


}

//Display herqa

 class DisplayHerqa extends JFrame implements ActionListener {
    JLabel ssn,fname,mname,lname, sex, age,Grade12result ,Grade8result,Grade10result,cgpa,
            Instituteofgraduation,Departement,Yeargraduation,Educationstatus;
    JLabel fnamef,mnamef,lnamef, sexf, agef,Grade12resultf ,Grade8resultf,Grade10resultf,cgpaf,
            Instituteofgraduationf,Departementf,Yeargraduationf,Educationstatusf;
    JButton display, back;
    JTextField ssnf;
    JLabel title;

    public DisplayHerqa(){
        title = new JLabel("Display Educational Qualification Status");
        title.setFont(new Font("Serif",Font.BOLD,24));
        title.setBounds(150,10,600,50);
        add(title);
        ssn=new JLabel("Enter the SSN: ");
        ssn.setBounds(50,50,400,30);
        add(ssn);

        ssnf=new JTextField(30);
        ssnf.setBounds(150,50,100,30);
        add(ssnf);

        display=new JButton("Display");
        add(display);
        display.addActionListener(this);
        display.setBounds(250,50,100,30);

        fname=new JLabel("First Name:");
        fnamef=new JLabel();
        fname.setBounds(50,100,100,30);
        fnamef.setBounds(150,100,150,30);
        add(fname);
        add(fnamef);

        mname=new JLabel("Middle Name:");
        mnamef=new JLabel();
        mname.setBounds(50,150,100,30);
        mnamef.setBounds(150,150,150,30);
        add(mname);
        add(mnamef);

        lname=new JLabel("Last Name:");
        lnamef=new JLabel();
        lname.setBounds(50,200,100,30);
        lnamef.setBounds(150,200,150,30);
        add(lname);
        add(lnamef);

        sex=new JLabel("Sex:");
        sexf=new JLabel();
        sex.setBounds(50,250,100,30);
        sexf.setBounds(150,250,150,30);
        add(sex);
        add(sexf);

        age=new JLabel("Age:");
        agef=new JLabel();
        age.setBounds(50,300,100,30);
        agef.setBounds(150,300,150,30);
        add(age);
        add(agef);

        Grade8result=new JLabel("Grade 8 Resuslt:");
        Grade8resultf=new JLabel();
        Grade8result.setBounds(50,350,100,30);
        Grade8resultf.setBounds(150,350,150,30);
        add(Grade8result);
        add(Grade8resultf);

        Grade10result=new JLabel("Grade 10 Result:");
        Grade10resultf=new JLabel();
        Grade10result.setBounds(50,400,100,30);
        Grade10resultf.setBounds(150,400,150,30);
        add(Grade10result);
        add(Grade10resultf);

        Grade12result=new JLabel("Grade 12 Result:");
        Grade12resultf=new JLabel();
        Grade12result.setBounds(50,450,100,30);
        Grade12resultf.setBounds(150,450,150,30);
        add(Grade12result);
        add(Grade12resultf);

        cgpa=new JLabel("CGPA: ");
        cgpaf=new JLabel();
        cgpa.setBounds(50,500,100,30);
        cgpaf.setBounds(150,500,150,30);
        add(cgpa);
        add(cgpaf);

        Instituteofgraduation=new JLabel("Institute of Graduation:");
        Instituteofgraduationf=new JLabel();
        Instituteofgraduation.setBounds(50,550,200,30);
        Instituteofgraduationf.setBounds(150,550,150,30);
        add(Instituteofgraduation);
        add(Instituteofgraduationf);

        Departement=new JLabel("Department:");
        Departementf=new JLabel();
        Departement.setBounds(600,50,100,30);
        Departementf.setBounds(700,50,150,30);
        add(Departement);
        add(Departementf);

        Yeargraduation=new JLabel("Year Graduation:");
        Yeargraduationf=new JLabel();
        Yeargraduation.setBounds(600,100,100,30);
        Yeargraduationf.setBounds(700,100,150,30);
        add(Yeargraduation);
        add(Yeargraduationf);

        Educationstatus=new JLabel("Education Status:");
        Educationstatusf=new JLabel();
        Educationstatus.setBounds(600,150,200,30);
        Educationstatusf.setBounds(700,150,150,30);
        add(Educationstatus);
        add(Educationstatusf);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);

        setLayout(null);
        setTitle("Herqa Display");
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==display){
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 6000);
                Interface1 stub = (Interface1) registry.lookup("server");
                List<Herqa> list = stub.getHerqa();
                for (Herqa keb : list) {
                    if (keb.getSSN() == Integer.parseInt(ssnf.getText())) {
                        fnamef.setText(keb.getFirstName());
                        mnamef.setText(keb.getMiddleName());
                        lnamef.setText(keb.getLastName());
                        sexf.setText(keb.getSex());
                        agef.setText(String.valueOf(keb.getAge()));
                        Grade8resultf.setText( String.valueOf(keb.getGrade8result()));
                        Grade10resultf.setText( String.valueOf(keb.getGrade10result()));
                        Grade12resultf.setText( String.valueOf(keb.getGrade12result()));
                        cgpaf.setText( String.valueOf(keb.getCgpa()));
                        Instituteofgraduationf.setText(keb.getInstituteofgraduation());
                        Departementf.setText(String.valueOf(keb.getDepartement()));
                        Yeargraduationf.setText( String.valueOf(keb.getYeargraduation()));
                        Educationstatusf.setText(keb.getEducationstatus());


                    }
                }
            } catch (AccessException ee) {
                ee.printStackTrace();
            } catch (NotBoundException ee) {
                ee.printStackTrace();
            } catch (RemoteException ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource()==back){
            new SecondPageH();
            setVisible(false);
        }


    }


}

