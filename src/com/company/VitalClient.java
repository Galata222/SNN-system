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

public class VitalClient extends JFrame implements ActionListener {
    JLabel  ssn,birthRegistrationNo_Idno,fileNo,firstName,middleName,lastName, motherName,
            birthDate, region,maritalStatus, zone, woreda, nationality, fatherFullName,
            birhtCertificateRegisteredOn, fullNameOfCivilStatusOfficer, dateOfIssue,sex;
    JTextField ssnf,birthRegistrationNo_Idnof,fileNof,firstNamef,middleNamef,lastNamef, motherNamef,
            birthDatef, regionf,maritalStatusf, zonef, woredaf, nationalityf, fatherFullNamef,
            birhtCertificateRegisteredOnf, fullNameOfCivilStatusOfficerf, dateOfIssuef,sexf;

    JButton insert,back;
    public VitalClient(){
        ssn = new JLabel("SSN: ");
        ssnf = new JTextField(30);
        ssn.setBounds(50,50,300,30);
        ssnf.setBounds(150,50,300,30);
        add(ssn);
        add(ssnf);

        birthRegistrationNo_Idno = new JLabel("Birth Reg Idno: ");
        birthRegistrationNo_Idnof = new JTextField(30);
        birthRegistrationNo_Idno.setBounds(50,100,300,30);
        birthRegistrationNo_Idnof.setBounds(150,100,300,30);
        add(birthRegistrationNo_Idno);
        add(birthRegistrationNo_Idnof);

        fileNo = new JLabel("File Number: ");
        fileNof = new JTextField(30);
        fileNo.setBounds(50,150,300,30);
        fileNof.setBounds(150,150,300,30);
        add(fileNo);
        add(fileNof);

        firstName = new JLabel("First Name: ");
        firstNamef = new JTextField(30);
        firstName.setBounds(50,200,300,30);
        firstNamef.setBounds(150,200,300,30);
        add(firstName);
        add(firstNamef);

        middleName = new JLabel("Middle Name: ");
        middleNamef = new JTextField(30);
        middleName.setBounds(50,250,300,30);
        middleNamef.setBounds(150,250,300,30);
        add(middleName);
        add(middleNamef);

        lastName = new JLabel("Last Name: ");
        lastNamef = new JTextField(30);
        lastName.setBounds(50,300,300,30);
        lastNamef.setBounds(150,300,300,30);
        add(lastName);
        add(lastNamef);

        motherName = new JLabel("Mother Name: ");
        motherNamef = new JTextField(30);
        motherName.setBounds(50,350,300,30);
        motherNamef.setBounds(150,350,300,30);
        add(motherName);
        add(motherNamef);

        birthDate = new JLabel("Birth Date: ");
        birthDatef = new JTextField(30);
        birthDate.setBounds(50,400,300,30);
        birthDatef.setBounds(150,400,300,30);
        add(birthDate);
        add(birthDatef);

        region = new JLabel("Region: ");
        regionf = new JTextField(30);
        region.setBounds(50,450,300,30);
        regionf.setBounds(150,450,300,30);
        add(region);
        add(regionf);

        maritalStatus = new JLabel("Marital Status: ");
        maritalStatusf = new JTextField(30);
        maritalStatus.setBounds(50,500,300,30);
        maritalStatusf.setBounds(150,500,300,30);
        add(maritalStatus);
        add(maritalStatusf);

        zone = new JLabel("Zone: ");
        zonef = new JTextField(30);
        zone.setBounds(500,50,300,30);
        zonef.setBounds(600,50,300,30);
        add(zone);
        add(zonef);

        woreda = new JLabel("Woreda: ");
        woredaf = new JTextField(30);
        woreda.setBounds(500,100,300,30);
        woredaf.setBounds(600,100,300,30);
        add(woreda);
        add(woredaf);

        nationality = new JLabel("Nationality: ");
        nationalityf = new JTextField(30);
        nationality.setBounds(500,150,300,30);
        nationalityf.setBounds(600,150,300,30);
        add(nationality);
        add(nationalityf);

        fatherFullName = new JLabel("Father's Name : ");
        fatherFullNamef = new JTextField(30);
        fatherFullName.setBounds(500,200,300,30);
        fatherFullNamef.setBounds(600,200,300,30);
        add(fatherFullName);
        add(fatherFullNamef);

        birhtCertificateRegisteredOn = new JLabel("Birth Cert Reg : ");
        birhtCertificateRegisteredOnf = new JTextField(30);
        birhtCertificateRegisteredOn.setBounds(500,250,300,30);
        birhtCertificateRegisteredOnf.setBounds(600,250,300,30);
        add(birhtCertificateRegisteredOn);
        add(birhtCertificateRegisteredOnf);

        fullNameOfCivilStatusOfficer = new JLabel("Full Name of Civil   : ");
        fullNameOfCivilStatusOfficerf = new JTextField(30);
        fullNameOfCivilStatusOfficer.setBounds(500,300,300,30);
        fullNameOfCivilStatusOfficerf.setBounds(610,300,300,30);
        add(fullNameOfCivilStatusOfficer);
        add(fullNameOfCivilStatusOfficerf);

        dateOfIssue = new JLabel("Date of Issue : ");
        dateOfIssuef = new JTextField(30);
        dateOfIssue.setBounds(500,350,300,30);
        dateOfIssuef.setBounds(600,350,300,30);
        add(dateOfIssue);
        add(dateOfIssuef);

        sex = new JLabel("Sex : ");
        sexf = new JTextField(30);
        sex.setBounds(500,400,300,30);
        sexf.setBounds(600,400,300,30);
        add(sex);
        add(sexf);

        insert = new JButton("Submit");
        insert.setBounds(600,450,300,30);
        insert.addActionListener(this);
        add(insert);
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
        if (e.getSource() == insert) {
            try {
                // JDBC driver name and database URL
                String DB_URL = "jdbc:mysql://localhost:3306/vital";
                String data = "INSERT INTO `event`(`SSN`, `First Name`, `Middle Name`, `Last Name`, `Sex`, `Birth Date`, " +
                        "`Mother's Full name`, `Father's Full name`, `Nationality`, `Region`," +
                        " `Zone`, `Woreda`, `Birth Certificate Registration On`, `Date of Issue`, `Full Name of civil status officer`, " +
                        "`File No.`, `Birth Registration Id No.`, `Marital status`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                // Database credentials
                String USER = "root";
                String PASS = "";

                Connection conn = null;

                //Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement statement = conn.prepareStatement(data);
                statement.setInt(1, Integer.parseInt(ssnf.getText()));
                statement.setString(2, firstNamef.getText());
                statement.setString(3, middleNamef.getText());
                statement.setString(4, lastNamef.getText());
                statement.setString(5, sexf.getText());
                statement.setString(6, birthDatef.getText());
                statement.setString(7, motherNamef.getText());
                statement.setString(8, fatherFullNamef.getText());
                statement.setString(9, nationalityf.getText());
                statement.setString(10, regionf.getText());
                statement.setString(11, zonef.getText());
                statement.setString(12, woredaf.getText());
                statement.setInt(13, Integer.parseInt(birhtCertificateRegisteredOnf.getText()));
                statement.setString(14, dateOfIssuef.getText());
                statement.setString(15, fullNameOfCivilStatusOfficerf.getText());
                statement.setInt(16, Integer.parseInt(fileNof.getText()));
                statement.setInt(17, Integer.parseInt(birthRegistrationNo_Idnof.getText()));
                statement.setString(18, maritalStatusf.getText());
                statement.executeUpdate();

            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        else if (e.getSource()==back){
            new SecondPageV();
            setVisible(false);
        }

    }

}
 class DisplayVital extends JFrame implements ActionListener {
     JLabel birthregistrationno_idnod1, ssn, FirstName, MiddleName, LastName, MotherName, Birthdate, Region, Zone, Woreda, Nationality, FatherFullName,
             DateOfIssue, Fullnameofcivilstatusof, sex, maritalStatus, fullNameofcivilstatusofficer,
             birthregistrationno_idno, Birht_certificate_registered_On, fileNo;
     JLabel ssn1d, birthregistrationno_idnod, Birht_certificate_registered_Ond, fileNod,
             FirstNamed, MiddleNamed, LastNamed, MotherNamed, Birthdated, Regiond, Zoned, Woredad, Nationalityd, FatherFullNamed,
             DateOfIssued, Fullnameofcivilstatusofd, sexd, maritalStatusd;
     JButton display, back;
     JTextField birthregistrationno_idnodf;

     public DisplayVital() {
         birthregistrationno_idnod1 = new JLabel("Enter Birth registration no. id no: ");
         birthregistrationno_idnod1.setBounds(50, 10, 400, 30);
         add(birthregistrationno_idnod1);
         birthregistrationno_idnodf = new JTextField(30);
         birthregistrationno_idnodf.setBounds(240, 10, 100, 30);
         add(birthregistrationno_idnodf);

         display = new JButton("Display");
         add(display);
         display.addActionListener(this);
         display.setBounds(320, 10, 100, 30);

         ssn = new JLabel("SSN:");
         ssn1d = new JLabel();
         ssn.setBounds(50, 50, 100, 30);
         ssn1d.setBounds(150, 50, 150, 30);
         add(ssn);
         add(ssn1d);


         FirstName = new JLabel("First Name: ");
         FirstNamed = new JLabel();
         FirstName.setBounds(50, 100, 100, 30);
         FirstNamed.setBounds(150, 100, 150, 30);
         add(FirstName);
         add(FirstNamed);

         MiddleName = new JLabel("Middle Name: ");
         MiddleNamed = new JLabel();
         MiddleName.setBounds(50, 150, 100, 30);
         MiddleNamed.setBounds(150, 150, 150, 30);
         add(MiddleName);
         add(MiddleNamed);

         LastName = new JLabel("Last Name: ");
         LastNamed = new JLabel();
         LastName.setBounds(50, 200, 100, 30);
         LastNamed.setBounds(150, 200, 150, 30);
         add(LastName);
         add(LastNamed);

         sex = new JLabel("Sex: ");
         sexd = new JLabel();
         sex.setBounds(50, 250, 100, 30);
         sexd.setBounds(150, 250, 150, 30);
         add(sex);
         add(sexd);

         MotherName = new JLabel("Mother's Name:");
         MotherNamed = new JLabel();
         MotherName.setBounds(50, 300, 100, 30);
         MotherNamed.setBounds(150, 300, 150, 30);
         add(MotherName);
         add(MotherNamed);


         FatherFullName = new JLabel("Father FullName:");
         FatherFullNamed = new JLabel();
         FatherFullName.setBounds(50, 350, 200, 30);
         FatherFullNamed.setBounds(150, 350, 150, 30);
         add(FatherFullName);
         add(FatherFullNamed);

         Region = new JLabel("Region:");
         Regiond = new JLabel();
         Region.setBounds(50, 400, 100, 30);
         Regiond.setBounds(150, 400, 150, 30);
         add(Region);
         add(Regiond);

         Zone = new JLabel("Zone:");
         Zoned = new JLabel();
         Zone.setBounds(50, 450, 100, 30);
         Zoned.setBounds(150, 450, 150, 30);
         add(Zone);
         add(Zoned);

         Woreda = new JLabel("Woreda:");
         Woredad = new JLabel();
         Woreda.setBounds(500, 20, 100, 30);
         Woredad.setBounds(600, 20, 150, 30);
         add(Woreda);
         add(Woredad);

         Birthdate = new JLabel("Birthdate:");
         Birthdated = new JLabel();
         Birthdate.setBounds(500, 50, 100, 30);
         Birthdated.setBounds(600, 50, 150, 30);
         add(Birthdate);
         add(Birthdated);

         Nationality = new JLabel("Nationality :");
         Nationalityd = new JLabel();
         Nationality.setBounds(500, 100, 100, 30);
         Nationalityd.setBounds(600, 100, 150, 30);
         add(Nationality);
         add(Nationalityd);

         DateOfIssue = new JLabel("Date Of Issue:");
         DateOfIssued = new JLabel();
         DateOfIssue.setBounds(500, 150, 100, 30);
         DateOfIssued.setBounds(600, 150, 150, 30);
         add(DateOfIssue);
         add(DateOfIssued);

         Fullnameofcivilstatusof = new JLabel("Full name of civil status of:");
         Fullnameofcivilstatusofd = new JLabel();
         Fullnameofcivilstatusof.setBounds(500, 200, 300, 30);
         Fullnameofcivilstatusofd.setBounds(700, 200, 300, 30);
         add(Fullnameofcivilstatusof);
         add(Fullnameofcivilstatusofd);

         maritalStatus = new JLabel("Marital Status:");
         maritalStatusd = new JLabel();
         maritalStatus.setBounds(500, 250, 100, 30);
         maritalStatusd.setBounds(600, 250, 150, 30);
         add(maritalStatus);
         add(maritalStatusd);


         birthregistrationno_idno = new JLabel("Birth registration no. id no: ");
         birthregistrationno_idnod = new JLabel();
         birthregistrationno_idno.setBounds(500, 300, 200, 30);
         birthregistrationno_idnod.setBounds(700, 300, 150, 30);
         add(birthregistrationno_idno);
         add(birthregistrationno_idnod);

         Birht_certificate_registered_On = new JLabel("Birth certificate registered On:");
         Birht_certificate_registered_Ond = new JLabel();
         Birht_certificate_registered_On.setBounds(500, 350, 200, 30);
         Birht_certificate_registered_Ond.setBounds(700, 350, 150, 30);
         add(Birht_certificate_registered_On);
         add(Birht_certificate_registered_Ond);

         fileNo = new JLabel("File No:");
         fileNod = new JLabel();
         fileNo.setBounds(500, 400, 100, 30);
         fileNod.setBounds(600, 400, 150, 30);
         add(fileNo);
         add(fileNod);

         back = new JButton("<<Back");
         back.setBounds(700, 600, 100, 30);
         add(back);
         back.addActionListener(this);


         setLayout(null);
         setTitle("Vital Display");
         setSize(1000, 1500);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);

     }

     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == display) {
             try {
                 Registry registry = LocateRegistry.getRegistry("localhost", 6000);
                 Interface1 stub = (Interface1) registry.lookup("server");
                 List<VitalRegistrationEvent> list = stub.getVitaRegistrationEvent();
                 for (VitalRegistrationEvent keb : list) {
                     if (keb.getBirthregistrationno_idno() == Integer.parseInt(birthregistrationno_idnodf.getText())) {
                         ssn1d.setText(String.valueOf(keb.getSsn()));
                         FirstNamed.setText(keb.getFirstName());
                         MiddleNamed.setText(keb.getMiddleName());
                         LastNamed.setText(keb.getLastName());
                         sexd.setText(keb.getSex());
                         FatherFullNamed.setText(String.valueOf(keb.getFatherFullName()));
                         MotherNamed.setText(keb.getMotherName());
                         birthregistrationno_idnod.setText(String.valueOf(keb.getBirthregistrationno_idno()));
                         Birht_certificate_registered_Ond.setText(String.valueOf(keb.getBirht_certificate_registered_On()));
                         Nationalityd.setText(keb.getNationality());
                         Regiond.setText(keb.getRegion());
                         Zoned.setText(keb.getZone());
                         fileNod.setText(String.valueOf(keb.getFileNo()));
                         Woredad.setText(keb.getWoreda());
                         maritalStatusd.setText(keb.getMaritalStatus());
                         Fullnameofcivilstatusofd.setText(keb.getFullnameofcivilstatusof());
                         DateOfIssued.setText(String.valueOf(keb.getDateOfIssue()));
                         Birthdated.setText(keb.getBirthdate());

                     }
                 }
             } catch (AccessException ee) {
                 ee.printStackTrace();
             } catch (NotBoundException ee) {
                 ee.printStackTrace();
             } catch (RemoteException ee) {
                 ee.printStackTrace();
             }
         } else if (e.getSource() == back) {
             new SecondPageV();
             setVisible(false);
         }


     }


 }
