package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
public class KebeleClient extends JFrame implements ActionListener {
    JLabel ssn,fname,mname,lname,sex, age,mother,bPlace,bDate,nation,region ,zone,city,woreda,kebele,house,phone,emerge,occup,cstatus;
    JTextField ssnf,fnamef,mnamef,lnamef,sexf, agef,motherf,bPlacef,bDatef,nationf,regionf, zonef,cityf,woredaf,kebelef,housef,phonef,emergef,occupf,cstatusf;
    JButton insert, back;
    public KebeleClient(){
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

        mother=new JLabel("Mother");
        motherf=new JTextField(30);
        mother.setBounds(50,350,100,30);
        motherf.setBounds(150,350,150,30);
        add(mother);
        add(motherf);

        bPlace=new JLabel("Birth Place");
        bPlacef=new JTextField(30);
        bPlace.setBounds(50,400,100,30);
        bPlacef.setBounds(150,400,150,30);
        add(bPlace);
        add(bPlacef);

        bDate=new JLabel("Birth Date");
        bDatef=new JTextField(30);
        bDate.setBounds(50,450,100,30);
        bDatef.setBounds(150,450,150,30);
        add(bDate);
        add(bDatef);

        nation=new JLabel("Nationality");
        nationf=new JTextField(30);
        nation.setBounds(50,500,100,30);
        nationf.setBounds(150,500,150,30);
        add(nation);
        add(nationf);

        region=new JLabel("Region");
        regionf=new JTextField(30);
        region.setBounds(50,550,100,30);
        regionf.setBounds(150,550,150,30);
        add(region);
        add(regionf);

        zone=new JLabel("Zone");
        zonef=new JTextField(30);
        zone.setBounds(600,50,100,30);
        zonef.setBounds(650,50,150,30);
        add(zone);
        add(zonef);

        city=new JLabel("City");
        cityf=new JTextField(30);
        city.setBounds(600,100,100,30);
        cityf.setBounds(650,100,150,30);
        add(city);
        add(cityf);

        woreda=new JLabel("Woreda");
        woredaf=new JTextField(30);
        woreda.setBounds(600,150,100,30);
        woredaf.setBounds(650,150,150,30);
        add(woreda);
        add(woredaf);

        kebele=new JLabel("Kebele");
        kebelef=new JTextField(30);
        kebele.setBounds(600,200,100,30);
        kebelef.setBounds(650,200,150,30);
        add(kebele);
        add(kebelef);

        house=new JLabel("House No.");
        housef=new JTextField(30);
        house.setBounds(600,250,100,30);
        housef.setBounds(660,250,150,30);
        add(house);
        add(housef);
        phone=new JLabel("Phone No.");
        phonef=new JTextField(30);
        phone.setBounds(600,300,100,30);
        phonef.setBounds(660,300,150,30);
        add(phone);
        add(phonef);
        emerge=new JLabel("Emergency call time");
        emergef=new JTextField(30);
        emerge.setBounds(600,350,150,30);
        emergef.setBounds(750,350,150,30);
        add(emerge);
        add(emergef);

        occup=new JLabel("Occupation");
        occupf=new JTextField(30);
        occup.setBounds(600,400,100,30);
        occupf.setBounds(670,400,150,30);
        add(occup);
        add(occupf);

        cstatus=new JLabel("Current Status");
        cstatusf=new JTextField(30);
        cstatus.setBounds(600,450,150,30);
        cstatusf.setBounds(700,450,150,30);
        add(cstatus);
        add(cstatusf);

        insert=new JButton("Submit");
        insert.setBounds(150,600,100,30);
        add(insert);
        insert.addActionListener(this);

        back=new JButton("<<Back");
        back.setBounds(500,600,100,30);
        add(back);
        back.addActionListener(this);

        setLayout(null);
        setTitle("Kebele");
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {


            if (e.getSource() == insert) {


                try {
                    // JDBC driver name and database URL
                    String DB_URL = "jdbc:mysql://localhost:3306/kebele";
                    String data = "INSERT INTO `bate`(`SSN`, `First Name`, `Middle Name`, `Last Name`, `Sex`, `Age`, `Mother's Name`, `Birth Place`, `Birth Date`, `Nationality`, `Region`, `Zone`, `City`, `Woreda`, `Kebele`, `House No.`, `Phone No.`, `Emergency time call`, `Occupation`, `Current Status`)" +
                            "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    // Database credentials
                    String USER = "root";
                    String PASS = "";

                    Connection conn = null;
                    Statement stmt = null;

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
                    statement.setString(7, mnamef.getText());
                    statement.setString(8, bPlacef.getText());
                    statement.setString(9, bDatef.getText());
                    statement.setString(10, nationf.getText());
                    statement.setString(11, region.getText());
                    statement.setString(12, zonef.getText());
                    statement.setString(13, cityf.getText());
                    statement.setString(14, woredaf.getText());
                    statement.setString(15, kebelef.getText());
                    statement.setInt(16, Integer.parseInt(housef.getText()));
                    statement.setInt(17, Integer.parseInt(phonef.getText()));
                    statement.setString(18, emergef.getText());
                    statement.setString(19, occupf.getText());
                    statement.setString(20, cstatusf.getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Information is entered successfully");

                } catch (ClassNotFoundException ee) {
                    ee.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            } else if (e.getSource() == back) {
                setVisible(false);
                new AgeValidate();
            }

        }


    }


class UpdateKebele extends JFrame implements ActionListener{
    JLabel ssn,fname,mname,lname,sex, age,mother,bPlace,bDate,nation,region ,zone,city,woreda,kebele,house,phone,emerge,occup,cstatus;
    JTextField ssnf,fnamef,mnamef,lnamef,sexf, agef,motherf,bPlacef,bDatef,nationf,regionf, zonef,cityf,woredaf,kebelef,housef,phonef,emergef,occupf,cstatusf;

    JButton update ,back;
    public  UpdateKebele(){
        ssn=new JLabel("SSN");
        ssnf=new JTextField(50);
        ssn.setBounds(50,50,100,30);
        ssnf.setBounds(150,50,150,30);
        add(ssn);
        add(ssnf);


        age=new JLabel("Age");
        agef=new JTextField(30);
        age.setBounds(50,100,100,30);
        agef.setBounds(150,100,150,30);
        add(age);
        add(agef);

        region=new JLabel("Region");
        regionf=new JTextField(30);
        region.setBounds(50,150,100,30);
        regionf.setBounds(150,150,150,30);
        add(region);
        add(regionf);

        zone=new JLabel("Zone");
        zonef=new JTextField(30);
        zone.setBounds(50,200,100,30);
        zonef.setBounds(150,200,150,30);
        add(zone);
        add(zonef);

        city=new JLabel("City");
        cityf=new JTextField(30);
        city.setBounds(50,250,100,30);
        cityf.setBounds(150,250,150,30);
        add(city);
        add(cityf);

        woreda=new JLabel("Woreda");
        woredaf=new JTextField(30);
        woreda.setBounds(50,300,100,30);
        woredaf.setBounds(150,300,150,30);
        add(woreda);
        add(woredaf);

        kebele=new JLabel("Kebele");
        kebelef=new JTextField(30);
        kebele.setBounds(50,350,100,30);
        kebelef.setBounds(150,350,150,30);
        add(kebele);
        add(kebelef);

        house=new JLabel("House No.");
        housef=new JTextField(30);
        house.setBounds(50,400,100,30);
        housef.setBounds(150,400,150,30);
        add(house);
        add(housef);
        phone=new JLabel("Phone No.");
        phonef=new JTextField(30);
        phone.setBounds(50,450,100,30);
        phonef.setBounds(150,450,150,30);
        add(phone);
        add(phonef);
        emerge=new JLabel("Emergency call time");
        emergef=new JTextField(30);
        emerge.setBounds(50,500,150,30);
        emergef.setBounds(200,500,150,30);
        add(emerge);
        add(emergef);

        occup=new JLabel("Occupation");
        occupf=new JTextField(30);
        occup.setBounds(50,550,100,30);
        occupf.setBounds(150,550,150,30);
        add(occup);
        add(occupf);

        cstatus=new JLabel("Current Status");
        cstatusf=new JTextField(30);
        cstatus.setBounds(50,600,150,30);
        cstatusf.setBounds(150,600,150,30);
        add(cstatus);
        add(cstatusf);



        update=new JButton("Update");
        update.setBounds(500,600,100,30);
        add(update);
        update.addActionListener(this);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);


        setLayout(null);
        setTitle("Kebele");
        setSize(1000,1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            try {

                String DB_URL = "jdbc:mysql://localhost:3306/kebele";
                String update = "UPDATE `bate` SET `Age`=?,`Region`=?,`Zone`=?,`City`=?,`Woreda`=?,`Kebele`=?,`House No.`=?,`" +
                        "Phone No.`=?,`Emergency time call`=?,`Occupation`=?,`Current Status`=? WHERE `SSN`=?";
                String USER = "root";
                String PASS = "";
                Connection conn = null;

                //Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                System.out.println("Connected database successfully...");

                //Execute a query
                System.out.println("Creating statement...");
                PreparedStatement statement1 = conn.prepareStatement(update);

                statement1.setInt(1, Integer.parseInt(agef.getText()));
                statement1.setString(2, regionf.getText());
                statement1.setString(3, zonef.getText());
                statement1.setString(4, cityf.getText());
                statement1.setString(5, woredaf.getText());
                statement1.setString(6, kebelef.getText());
                statement1.setInt(7, Integer.parseInt(housef.getText()));
                statement1.setInt(8, Integer.parseInt(phonef.getText()));
                statement1.setString(9, emergef.getText());
                statement1.setString(10, occupf.getText());
                statement1.setString(11, cstatusf.getText());
                statement1.setInt(12, Integer.parseInt(ssnf.getText()));
                statement1.executeUpdate();
            } catch (SQLException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

        }
        else if (e.getSource()==back){
            new SecondPage();
            setVisible(false);
        }
    }
}
class DisplayKebele extends JFrame implements ActionListener{
    JLabel ssn1,ssn,fname,mname,lname,sex, age,mother,bPlace,bDate,nation,region ,zone,city,woreda,kebele,house,phone,emerge,occup,cstatus;
    JLabel ssn1d,fnamed,mnamed,lnamed,sexd, aged,motherd,bPlaced,bDated,nationd,regiond ,zoned,cityd,woredad,kebeled,housed,phoned,emerged,occupd,cstatusd;

    JButton display, back;
    JTextField ssnf;
    public DisplayKebele(){

        ssn=new JLabel("Enter the SSN: ");
        ssn.setBounds(50,10,400,30);
        add(ssn);
        ssnf=new JTextField(30);
        ssnf.setBounds(150,10,100,30);
        add(ssnf);

        display=new JButton("Display");
        add(display);
        display.addActionListener(this);
        display.setBounds(250,10,100,30);

        ssn1=new JLabel("SSN:");
        ssn1d=new JLabel();
        ssn1.setBounds(50,50,100,30);
        ssn1d.setBounds(150,50,150,30);
        add(ssn1);
        add(ssn1d);


        fname=new JLabel("First Name: ");
        fnamed=new JLabel();
        fname.setBounds(50,100,100,30);
        fnamed.setBounds(150,100,150,30);
        add(fname);
        add(fnamed);

        mname=new JLabel("Middle Name: ");
        mnamed=new JLabel();
        mname.setBounds(50,150,100,30);
        mnamed.setBounds(150,150,150,30);
        add(mname);
        add(mnamed);

        lname=new JLabel("Last Name: ");
        lnamed=new JLabel();
        lname.setBounds(50,200,100,30);
        lnamed.setBounds(150,200,150,30);
        add(lname);
        add(lnamed);

        sex=new JLabel("Sex: ");
        sexd=new JLabel();
        sex.setBounds(50,250,100,30);
        sexd.setBounds(150,250,150,30);
        add(sex);
        add(sexd);

        age=new JLabel("Age:");
        aged=new JLabel();
        age.setBounds(50,300,100,30);
        aged.setBounds(150,300,150,30);
        add(age);
        add(aged);

        region=new JLabel("Region:");
        regiond=new JLabel();
        region.setBounds(50,350,100,30);
        regiond.setBounds(150,350,150,30);
        add(region);
        add(regiond);

        zone=new JLabel("Zone:");
        zoned=new JLabel();
        zone.setBounds(50,400,100,30);
        zoned.setBounds(150,400,150,30);
        add(zone);
        add(zoned);

        city=new JLabel("City:");
        cityd=new JLabel();
        city.setBounds(50,450,100,30);
        cityd.setBounds(150,450,150,30);
        add(city);
        add(cityd);

        woreda=new JLabel("Woreda:");
        woredad=new JLabel();
        woreda.setBounds(500,20,100,30);
        woredad.setBounds(600,20,150,30);
        add(woreda);
        add(woredad);

        kebele=new JLabel("Kebele:");
        kebeled=new JLabel();
        kebele.setBounds(500,50,100,30);
        kebeled.setBounds(600,50,150,30);
        add(kebele);
        add(kebeled);

        house=new JLabel("House No.:");
        housed=new JLabel();
        house.setBounds(500,100,100,30);
        housed.setBounds(600,100,150,30);
        add(house);
        add(housed);
        phone=new JLabel("Phone No.:");
        phoned=new JLabel();
        phone.setBounds(500,150,100,30);
        phoned.setBounds(600,150,150,30);
        add(phone);
        add(phoned);
        emerge=new JLabel("Emergency call time:");
        emerged=new JLabel();
        emerge.setBounds(500,200,300,30);
        emerged.setBounds(650,200,300,30);
        add(emerge);
        add(emerged);

        occup=new JLabel("Occupation:");
        occupd=new JLabel();
        occup.setBounds(500,250,100,30);
        occupd.setBounds(600,250,150,30);
        add(occup);
        add(occupd);

        cstatus=new JLabel("Current Status:");
        cstatusd=new JLabel();
        cstatus.setBounds(500,300,150,30);
        cstatusd.setBounds(600,300,150,30);
        add(cstatus);
        add(cstatusd);

        mother=new JLabel("Mother's Name: ");
        motherd=new JLabel();
        mother.setBounds(500,350,200,30);
        motherd.setBounds(600,350,150,30);
        add(mother);
        add(motherd);

        bPlace=new JLabel("Birth Place:");
        bPlaced=new JLabel();
        bPlace.setBounds(500,400,200,30);
        bPlaced.setBounds(600,400,150,30);
        add(bPlace);
        add(bPlaced);

        bDate=new JLabel("Birth Date:");
        bDated=new JLabel();
        bDate.setBounds(500,450,100,30);
        bDated.setBounds(600,450,150,30);
        add(bDate);
        add(bDated);

        nation=new JLabel("Nationality:");
        nationd=new JLabel();
        nation.setBounds(500,500,100,30);
        nationd.setBounds(600,500,150,30);
        add(nation);
        add(nationd);

        back=new JButton("<<Back");
        back.setBounds(700,600,100,30);
        add(back);
        back.addActionListener(this);

        setLayout(null);
        setTitle("Kebele");
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
                List<Kebele> list = stub.getKebele();

                for (Kebele keb : list) {

                    if (keb.getSSN() == Integer.parseInt(ssnf.getText())) {
                        ssn1d.setText(String.valueOf(keb.getSSN()));
                        fnamed.setText(keb.getFirsName());
                        mnamed.setText(keb.getMiddleName());
                        lnamed.setText(keb.getLastName());
                        sexd.setText(keb.getSex());
                        aged.setText(String.valueOf(keb.getAge()));
                        motherd.setText( keb.getMotherName());
                        bPlaced.setText(keb.getBirthPlace());
                        bDated.setText(keb.getBirthPlace());
                        nationd.setText(keb.getNationality());
                        regiond.setText( keb.getRegion());
                        zoned.setText(keb.getZone());
                        cityd.setText(keb.getCity());
                        woredad.setText(keb.getWoreda());
                        kebeled.setText(keb.getGanda());
                        housed.setText(String.valueOf(keb.getHouseNumber()));
                        phoned.setText(String.valueOf(keb.getPhoneNumber()));
                        emerged.setText(keb.getEmergencytimecall());
                        occupd.setText(keb.getOccupation());
                        cstatusd.setText(keb.getCurrentstatus());
                    }
                }
            } catch (AccessException ee) {
                ee.printStackTrace();
            } catch (NotBoundException ee) {
                ee.printStackTrace();
            } catch (RemoteException ee) {
                ee.printStackTrace();
            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            }
        }

        else if(e.getSource()==back){
            new SecondPage();
            setVisible(false);
        }

    }
}


class AgeValidate extends JFrame implements ActionListener{
    JLabel title, enter,display;
    JButton validate, back;
    JTextField enterfi;

   public AgeValidate(){
       title=new JLabel("Please Enter the BirthDate ID No of Citizen ");
       title.setBounds(200,10,500,30);
       add(title);
       enter=new JLabel("Enter BirthDate ID No:");
       enter.setBounds(200,50,200,30);
       add(enter);

       enterfi=new JTextField(50);
       enterfi.setBounds(400,50,150,30);
       add(enterfi);

       validate=new JButton("Validate");
       add(validate);
       validate.addActionListener(this);
       validate.setBounds(400,100,100,30);

       display=new JLabel();
       display=new JLabel();
       display.setBounds(400,150,300,30);
       add(display);

       back=new JButton("<<Back");
       back.setBounds(700,600,100,30);
       add(back);
       back.addActionListener(this);


       setLayout(null);
       setTitle("Kebele");
       setSize(1000,1500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);




   }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == validate) {
            String birthdate = null;
            int age=0, date;
            LocalDate year = LocalDate.now();
            int yr = year.getYear();
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 6000);
                Interface1 stub = (Interface1) registry.lookup("server");
                List<VitalRegistrationEvent> list = stub.getVitaRegistrationEvent();
                for (VitalRegistrationEvent keb:list){
                    if (keb.getBirthregistrationno_idno() == Integer.parseInt(enterfi.getText())){
                        birthdate=keb.getBirthdate();
                    }
                }

                date = Integer.parseInt(birthdate);
                age += (yr - date);
                if (age >= 18) {
                    JOptionPane.showMessageDialog(null, "The Citizen is " + age + " years old so,you can Register.!");
                    new KebeleClient();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "The citizen is Under Eighteen,don't register!");
                }
            } catch (AccessException ee) {
                ee.printStackTrace();
            } catch (NotBoundException ee) {
                ee.printStackTrace();
            } catch (RemoteException ee) {
                ee.printStackTrace();
            }
        }
        else if (e.getSource()==back){
            new SecondPage();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AgeValidate();
    }
}