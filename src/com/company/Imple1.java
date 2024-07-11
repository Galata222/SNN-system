package com.company;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Imple1 implements Interface1 {
    public List<Kebele> getKebele() throws RemoteException, ClassNotFoundException {
        List<Kebele> list = new ArrayList<Kebele>();
        try {
            // JDBC driver name and database URL
            String DB_URL = "jdbc:mysql://localhost:3306/kebele";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM bate";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int ssn = rs.getInt("SSN");
                String firstName = rs.getString("First Name");
                String middleName = rs.getString("Middle Name");
                String lastName = rs.getString("Last Name");
                String sex = rs.getString("sex");
                String motherName = rs.getString("Mother's Name");
                int age = rs.getInt("Age");
                String birthPlace = rs.getString("Birth Place");
                String birthdate = rs.getString("Birth Date");
                String nationality = rs.getString("Nationality");
                String region = rs.getString("Region");
                String zone = rs.getString("Zone");
                String city = rs.getString("City");
                String woreda = rs.getString("Woreda");
                String ganda = rs.getString("Kebele");
                int houseNumber = rs.getInt("House No.");
                int phoneNumber = rs.getInt("Phone No.");
                String emergencyTimeCall = rs.getString("Emergency time call");
                String occupation = rs.getString("Occupation");
                String currentStatus = rs.getString("Current status");
                Kebele kebe = new Kebele();

                kebe.setSSN(ssn);
                kebe.setFirstName(firstName);
                kebe.setLastName(lastName);
                kebe.setMiddleName(middleName);
                kebe.setMotherName(motherName);
                kebe.setSex(sex);
                kebe.setAge(age);
                kebe.setBirthPlace(birthPlace);
                kebe.setBirthdate(birthdate);
                kebe.setNationality(nationality);
                kebe.setRegion(region);
                kebe.setZone(zone);
                kebe.setWoreda(woreda);
                kebe.setGanda(ganda);
                kebe.setCity(city);
                kebe.setHouseNumber(houseNumber);
                kebe.setPhoneNumber(phoneNumber);
                kebe.setEmergencytimecall(emergencyTimeCall);
                kebe.setOccupation(occupation);
                kebe.setCurrentstatus(currentStatus);
                list.add(kebe);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<VitalRegistrationEvent> getVitaRegistrationEvent() throws RemoteException {
        List<VitalRegistrationEvent> list = new ArrayList<VitalRegistrationEvent>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/vital";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM event";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ssn = rs.getInt("SSN");
                String fullNameOfCivilStatusOfficer = rs.getString("Full Name of civil status officer");
                int birthRegistrationNo_Idno = rs.getInt("Birth Registration Id No.");
                String firstName = rs.getString("First Name");
                String middleName = rs.getString("Middle Name");
                String lastName = rs.getString("Last Name");
                String motherName = rs.getString("Mother's Full Name");
                String birthDate = rs.getString("Birth Date");
                String region = rs.getString("Region");
                String zone = rs.getString("Zone");
                String woreda = rs.getString("Woreda");
                String nationality = rs.getString("Nationality");
                String fatherFullName = rs.getString("Father's Full Name");
                int birhtCertificateRegisteredOn = rs.getInt("Birth Certificate Registration On");
                String maritalStatus = rs.getString("Marital status");
                String sex = rs.getString("Sex");
                String dateOfIssue = rs.getString("Date of Issue");
                int fileNo = rs.getInt("File No.");

                VitalRegistrationEvent vital = new VitalRegistrationEvent();
                vital.setSSN(ssn);
                vital.setFullnameofcivilstatusof(fullNameOfCivilStatusOfficer);
                vital.setBirthregistrationno_idno(birthRegistrationNo_Idno);
                vital.setFirstName(firstName);
                vital.setMiddleName(middleName);
                vital.setLastName(lastName);
                vital.setMotherName(motherName);
                vital.setBirthdate(birthDate);
                vital.setRegion(region);
                vital.setZone(zone);
                vital.setWoreda(woreda);
                vital.setNationality(nationality);
                vital.setFatherFullName(fatherFullName);
                vital.setBirht_certificate_registered_On(birhtCertificateRegisteredOn);
                vital.setMaritalStatus(maritalStatus);
                vital.setSex(sex);
                vital.setDateOfIssue(dateOfIssue);
                vital.setFileNo(fileNo);
                list.add(vital);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Herqa> getHerqa() throws RemoteException {
        List<Herqa> list = new ArrayList<Herqa>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/herqa";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected 7database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM moshe";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int SSN = rs.getInt("SSN");
                int Age = rs.getInt("Age");
                int Grade12result = rs.getInt("Grade 12 result");
                float Grade8result = rs.getFloat("Grade 8 result");
                float Grade10result = rs.getFloat("Grade 10 result");
                float cgpa = rs.getFloat("Cgpa");
                String FirstName = rs.getString("First Name");
                String MiddleName = rs.getString("Middle Name");
                String LastName = rs.getString("Last Name");
                String sex = rs.getString("Sex");
                String Instituteofgraduation = rs.getString("Institute of Graduation");
                String Departement = rs.getString("Department");
                String Yeargraduation = rs.getString("Year of Graduation");
                String Educationstatus = rs.getString("Education status");

                Herqa herqa = new Herqa();
                herqa.setLastName(LastName);
                ;
                herqa.setAge(Age);
                herqa.setMiddleName(MiddleName);
                herqa.setInstituteofgraduation(Instituteofgraduation);
                herqa.setFirstName(FirstName);
                herqa.setDepartement(Departement);
                herqa.setCgpa(cgpa);
                herqa.setEducationstatus(Educationstatus);
                herqa.setGrade8result(Grade8result);
                herqa.setGrade10result(Grade10result);
                herqa.setGrade12result(Grade12result);
                herqa.setSSN(SSN);
                herqa.setSex(sex);
                herqa.setYeargraduation(Yeargraduation);
                list.add(herqa);

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Bank> getBank() throws RemoteException {
        List<Bank> list = new ArrayList<Bank>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/bank";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM job_application";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int ssn = rs.getInt("SSN");
                int phonenumber = rs.getInt("Phone Number");
                int age = rs.getInt("Age");
                int Yearofgraduation = rs.getInt("Year of Graduation");
                float Cgpa = rs.getFloat("CGPA");
                String FirstName = rs.getString("First Name");
                String MiddleName = rs.getString("Middle Name");
                String LastName = rs.getString("Last Name");
                String gender = rs.getString("Gender");
                String Instituteofgraduation = rs.getString("Institute of Graduation");
                String fieldofstudy = rs.getString("Field of Study");
                String positiontype = rs.getString("Position Type");
                String enrolmenttype = rs.getString("Enrollment Type");
                String degreetype = rs.getString("Degree Type");
                String postedtime = rs.getString("Posting Date");


                Bank bank = new Bank();
                bank.setAge(age);
                bank.setCgpa(Cgpa);
                ;
                bank.setFirstName(FirstName);
                bank.setInstituteofgraduation(Instituteofgraduation);
                bank.setMiddleName(MiddleName);
                bank.setLastName(LastName);
                bank.setGender(gender);
                bank.setPhonenumber(phonenumber);
                bank.setSSN(ssn);
                bank.setYearofgraduation(Yearofgraduation);
                bank.setDegreetype(degreetype);
                bank.setFieldofstudy(fieldofstudy);
                bank.setPositiontype(positiontype);
                bank.setEnrolmenttype(enrolmenttype);
                bank.setPostedtime(postedtime);
                list.add(bank);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<KebeLogin> getKebeLogin() throws RemoteException {
        List<KebeLogin> list = new ArrayList<KebeLogin>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/kebele";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected 7database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name;
                String use = rs.getString("username");
                String pass = rs.getString("password");


                KebeLogin ke = new KebeLogin();
                ke.setUse(use);
                ke.setPass(pass);
                list.add(ke);

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<HerqaLogin> getHerqaLogin() throws RemoteException {
        List<HerqaLogin> list = new ArrayList<HerqaLogin>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/herqa";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected 7database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name;
                String use = rs.getString("username");
                String pass = rs.getString("password");


                HerqaLogin he = new HerqaLogin();
                he.setUse(use);
                he.setPass(pass);
                list.add(he);

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<VitalLogin> getVitalLogin() throws RemoteException {
        List<VitalLogin> list = new ArrayList<VitalLogin>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/vital";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected 7database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name;
                String use = rs.getString("username");
                String pass = rs.getString("password");


                VitalLogin ve = new VitalLogin();
                ve.setUse(use);
                ve.setPass(pass);
                list.add(ve);

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<BankLogin> getBankLogin() throws RemoteException {
        List<BankLogin> list = new ArrayList<BankLogin>();
        try {
            // JDBC driver name and database URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/bank";

            // Database credentials
            String USER = "root";
            String PASS = "";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected 7database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name;
                String use = rs.getString("username");
                String pass = rs.getString("password");


                BankLogin be = new BankLogin();
                be.setUse(use);
                be.setPass(pass);
                list.add(be);

            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}