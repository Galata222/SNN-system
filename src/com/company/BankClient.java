package com.company;

import javax.swing.*;
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

public class BankClient extends JFrame implements ActionListener {
    JLabel ssn,fname,mname,lname, sex, age,Grade12result ,Grade8result,Grade10result,cgpa,
            Instituteofgraduation,Departement,Yeargraduation,Educationstatus, info;
    JLabel fnamef,mnamef,lnamef, sexf, agef,Grade12resultf ,Grade8resultf,Grade10resultf,cgpaf,
            Instituteofgraduationf,Departementf,Yeargraduationf,Educationstatusf;
    JButton display, back1 ,disp;
    JTextField ssnf;
    public BankClient(){
        ssn=new JLabel("Enter the SSN: ");
        ssn.setBounds(50,50,400,30);
        add(ssn);

        ssnf=new JTextField(30);
        ssnf.setBounds(150,50,100,30);
        add(ssnf);

        display=new JButton("Display ");
        add(display);
        display.addActionListener(this);
        display.setBounds(250,50,100,30);

        info=new JLabel("Enter the Applicant's SSN to get his/her Educational Information");
        info.setBounds(250, 5,1000,50);
        add(info);
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

        back1=new JButton("<<Back");
        back1.setBounds(700,600,100,30);
        add(back1);
        back1.addActionListener(this);



        setLayout(null);
        setTitle("Bank");
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BankClient();
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
        else if (e.getSource()==back1){
            new BankPage();
            setVisible(false);
        }
        else if (e.getSource()==disp){
            new JobDisplay();
            setVisible(false);
        }


    }


}

//Job application page
 class BankJobApplication extends JFrame implements ActionListener {
    JLabel ssn,phonenumber,age,Yearofgraduation,Cgpa, FirstName,MiddleName,LastName,gender,
            Instituteofgraduation,fieldofstudy,positiontype,enrolmenttype,degreetype,postedtime;
    JTextField ssnf,phonenumberf,agef,Yearofgraduationf,Cgpaf, FirstNamef,MiddleNamef,LastNamef,genderf,
            Instituteofgraduationf,fieldofstudyf,positiontypef,enrolmenttypef,degreetypef,postedtimef;
    JButton submit, back;
    public BankJobApplication(){
        ssn=new JLabel("SSN");
        ssnf=new JTextField(50);
        ssn.setBounds(50,50,100,30);
        ssnf.setBounds(200,50,150,30);
        add(ssn);
        add(ssnf);

        phonenumber=new JLabel("Phone Number: ");
        phonenumberf=new JTextField(50);
        phonenumber.setBounds(50,100,200,30);
        phonenumberf.setBounds(200,100,150,30);
        add(phonenumber);
        add(phonenumberf);

        Yearofgraduation=new JLabel("Year of Graduation: ");
        Yearofgraduationf=new JTextField(50);
        Yearofgraduation.setBounds(50,150,200,30);
        Yearofgraduationf.setBounds(200,150,150,30);
        add(Yearofgraduation);
        add(Yearofgraduationf);

        Cgpa=new JLabel("CGPA:");
        Cgpaf=new JTextField(30);
        Cgpa.setBounds(50,200,100,30);
        Cgpaf.setBounds(200,200,150,30);
        add(Cgpa);
        add(Cgpaf);

        FirstName=new JLabel("First Name: ");
        FirstNamef=new JTextField(30);
        FirstName.setBounds(50,250,100,30);
        FirstNamef.setBounds(200,250,150,30);
        add(FirstName);
        add(FirstNamef);

        age=new JLabel("Age");
        agef=new JTextField(30);
        age.setBounds(50,300,100,30);
        agef.setBounds(200,300,150,30);
        add(age);
        add(agef);

        MiddleName=new JLabel("Middle Name: ");
        MiddleNamef=new JTextField(30);
        MiddleName.setBounds(50,350,100,30);
        MiddleNamef.setBounds(200,350,150,30);
        add(MiddleName);
        add(MiddleNamef);

        LastName=new JLabel("Last Name: ");
        LastNamef=new JTextField(30);
        LastName.setBounds(50,400,100,30);
        LastNamef.setBounds(200,400,150,30);
        add(LastName);
        add(LastNamef);

        gender=new JLabel("Gender: ");
        genderf=new JTextField(30);
        gender.setBounds(50,450,100,30);
        genderf.setBounds(200,450,150,30);
        add(gender);
        add(genderf);

        Instituteofgraduation=new JLabel("Institute of Graduation: ");
        Instituteofgraduationf=new JTextField(30);
        Instituteofgraduation.setBounds(50,500,200,30);
        Instituteofgraduationf.setBounds(200,500,150,30);
        add(Instituteofgraduation);
        add(Instituteofgraduationf);

        fieldofstudy=new JLabel("Field of Study: ");
        fieldofstudyf=new JTextField(30);
        fieldofstudy.setBounds(50,550,150,30);
        fieldofstudyf.setBounds(200,550,150,30);
        add(fieldofstudy);
        add(fieldofstudyf);

        positiontype=new JLabel("Position Type: ");
        positiontypef=new JTextField(30);
        positiontype.setBounds(600,50,150,30);
        positiontypef.setBounds(710,50,150,30);
        add(positiontype);
        add(positiontypef);

        enrolmenttype=new JLabel("Enrollment Type: ");
        enrolmenttypef=new JTextField(30);
        enrolmenttype.setBounds(600,100,200,30);
        enrolmenttypef.setBounds(710,100,150,30);
        add(enrolmenttype);
        add(enrolmenttypef);

        degreetype=new JLabel("Degree Type: ");
        degreetypef=new JTextField(30);
        degreetype.setBounds(600,150,100,30);
        degreetypef.setBounds(710,150,150,30);
        add(degreetype);
        add(degreetypef);

        postedtime=new JLabel("Posted Time: ");
        postedtimef=new JTextField(30);
        postedtime.setBounds(600,200,200,30);
        postedtimef.setBounds(710,200,150,30);
        add(postedtime);
        add(postedtimef);

        submit=new JButton("Submit");

        submit.setBounds(710,250,100,30);
        submit.addActionListener(this);
        add(submit);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);



        setLayout(null);
        setTitle("Job Application");
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            try {

                // JDBC driver name and database URL
                String DB_URL = "jdbc:mysql://localhost:3306/bank";
                String data = "INSERT INTO `job_application`(`SSN`, `First Name`, `Middle Name`, `Last Name`, `Gender`, `Institute of Graduation`, " +
                        "`Field of Study`, `CGPA`, `Phone Number`, `Age`, `Year of Graduation`, `Posting Date`, `Position Type`, `Enrollment Type`," +
                        " `Degree Type`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                // Database credentials
                String USER = "root";
                String PASS = "";

                Connection conn = null;

                //Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement statement = conn.prepareStatement(data);
                statement.setInt(1, Integer.parseInt(ssnf.getText()));
                statement.setString(2, FirstNamef.getText());
                statement.setString(3, MiddleNamef.getText());
                statement.setString(4, LastNamef.getText());
                statement.setString(5, genderf.getText());
                statement.setString(6, Instituteofgraduationf.getText());
                statement.setString(7, fieldofstudyf.getText());
                statement.setFloat(8, Float.parseFloat(Cgpaf.getText()));
                statement.setInt(9, Integer.parseInt(phonenumberf.getText()));
                statement.setInt(10, Integer.parseInt(agef.getText()));
                statement.setString(11, Yearofgraduationf.getText());
                statement.setString(12, postedtimef.getText());
                statement.setString(13, positiontypef.getText());
                statement.setString(14, enrolmenttypef.getText());
                statement.setString(15, degreetypef.getText());
                statement.executeUpdate();

            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        else if (e.getSource()==back){
            new BankPage();
            setVisible(false);
        }
    }

}
class JobDisplay extends JFrame implements ActionListener{
    JLabel text, ssn,phonenumber,age,Yearofgraduation,Cgpa, FirstName,MiddleName,LastName,gender,
            Instituteofgraduation,fieldofstudy,positiontype,enrolmenttype,degreetype,postedtime;
    JLabel ssnf,phonenumberf,agef,Yearofgraduationf,Cgpaf, FirstNamef,MiddleNamef,LastNamef,genderf,
            Instituteofgraduationf,fieldofstudyf,positiontypef,enrolmenttypef,degreetypef,postedtimef;
    JTextField field;
    JButton display, back, disp;
    public JobDisplay(){
        text=new JLabel("Enter the Employee SSN: ");
        text.setBounds(50,50,200,30);
        add(text);

        field=new JTextField(30);
        field.setBounds(200,50,100,30);
        add(field);

        display=new JButton("Display");
        display.setBounds(300,50,100,30);
        add(display);
        display.addActionListener(this);


        phonenumber=new JLabel("Phone Number:");
        phonenumberf=new JLabel();
        phonenumber.setBounds(50,100,100,30);
        phonenumberf.setBounds(200,100,150,30);
        add(phonenumber);
        add(phonenumberf);

        Yearofgraduation=new JLabel("Year of Graduation: ");
        Yearofgraduationf=new JLabel();
        Yearofgraduation.setBounds(50,150,200,30);
        Yearofgraduationf.setBounds(200,150,150,30);
        add(Yearofgraduation);
        add(Yearofgraduationf);

        Cgpa=new JLabel("CGPA:");
        Cgpaf=new JLabel();
        Cgpa.setBounds(50,200,100,30);
        Cgpaf.setBounds(200,200,150,30);
        add(Cgpa);
        add(Cgpaf);

        FirstName=new JLabel("First Name: ");
        FirstNamef=new JLabel();
        FirstName.setBounds(50,250,100,30);
        FirstNamef.setBounds(200,250,150,30);
        add(FirstName);
        add(FirstNamef);

        age=new JLabel("Age");
        agef=new JLabel();
        age.setBounds(50,300,100,30);
        agef.setBounds(200,300,150,30);
        add(age);
        add(agef);

        MiddleName=new JLabel("Middle Name: ");
        MiddleNamef=new JLabel();
        MiddleName.setBounds(50,350,100,30);
        MiddleNamef.setBounds(200,350,150,30);
        add(MiddleName);
        add(MiddleNamef);

        LastName=new JLabel("Last Name: ");
        LastNamef=new JLabel();
        LastName.setBounds(50,400,100,30);
        LastNamef.setBounds(200,400,150,30);
        add(LastName);
        add(LastNamef);

        gender=new JLabel("Gender: ");
        genderf=new JLabel();
        gender.setBounds(50,450,100,30);
        genderf.setBounds(200,450,150,30);
        add(gender);
        add(genderf);

        Instituteofgraduation=new JLabel("Institute of Graduation: ");
        Instituteofgraduationf=new JLabel();
        Instituteofgraduation.setBounds(50,500,200,30);
        Instituteofgraduationf.setBounds(200,500,150,30);
        add(Instituteofgraduation);
        add(Instituteofgraduationf);

        fieldofstudy=new JLabel("Field of Study: ");
        fieldofstudyf=new JLabel();
        fieldofstudy.setBounds(50,550,150,30);
        fieldofstudyf.setBounds(200,550,150,30);
        add(fieldofstudy);
        add(fieldofstudyf);

        positiontype=new JLabel("Position Type: ");
        positiontypef=new JLabel();
        positiontype.setBounds(600,50,150,30);
        positiontypef.setBounds(710,50,150,30);
        add(positiontype);
        add(positiontypef);

        enrolmenttype=new JLabel("Enrollment Type: ");
        enrolmenttypef=new JLabel();
        enrolmenttype.setBounds(600,100,200,30);
        enrolmenttypef.setBounds(710,100,150,30);
        add(enrolmenttype);
        add(enrolmenttypef);

        degreetype=new JLabel("Degree Type: ");
        degreetypef=new JLabel();
        degreetype.setBounds(600,150,100,30);
        degreetypef.setBounds(710,150,150,30);
        add(degreetype);
        add(degreetypef);

        postedtime=new JLabel("Posted Time: ");
        postedtimef=new JLabel();
        postedtime.setBounds(600,200,200,30);
        postedtimef.setBounds(710,200,150,30);
        add(postedtime);
        add(postedtimef);



        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);

        disp=new JButton("Validate Employee Info from HERQA");
        disp.setBounds(800,600,400,30);
        add(disp);
        disp.addActionListener(this);

        setLayout(null);
        setTitle("Job Application");
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
                List<Bank> list = stub.getBank();

                for (Bank keb : list) {

                    if (keb.getSSN() == Integer.parseInt(field.getText())) {
                        FirstNamef.setText(keb.getFirstName());
                        MiddleNamef.setText(keb.getMiddleName());
                        LastNamef.setText(keb.getLastName());
                        agef.setText(String.valueOf(keb.getAge()));
                        postedtimef.setText( keb.getPostedtime());
                        positiontypef.setText(keb.getPostedtime());
                        degreetypef.setText(keb.getDegreetype());
                        enrolmenttypef.setText(keb.getEnrolmenttype());
                        fieldofstudyf.setText( keb.getFieldofstudy());
                        genderf.setText(keb.getGender());
                        Instituteofgraduationf.setText(keb.getInstituteofgraduation());
                        Cgpaf.setText(String.valueOf(keb.getCgpa()));
                        Yearofgraduationf.setText(String.valueOf(keb.getYearofgraduation()));
                        phonenumberf.setText(String.valueOf(keb.getPhonenumber()));

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

        else if(e.getSource()==back){
            new BankClient();
            setVisible(false);
        }
        else if (e.getSource()==disp){
            new BankClient();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new JobDisplay();
    }
    }

