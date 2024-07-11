package com.company;

import java.io.Serializable;

public class VitalRegistrationEvent implements Serializable {
    private int ssn,birthregistrationno_idno,Birht_certificate_registered_On,fileNo;
    private String FirstName,MiddleName,LastName,MotherName,Birthdate,Region,Zone,Woreda,Nationality,FatherFullName;
    private String DateOfIssue,Fullnameofcivilstatusof,sex,maritalStatus;

    public int getSsn(){
        return ssn;
    }


    public int getBirthregistrationno_idno(){
        return birthregistrationno_idno;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getMiddleName(){return MiddleName;}
    public String getLastName(){return LastName;}
    public String getSex(){return sex;}
    public String getMotherName(){
        return MotherName;
    }
    public String getBirthdate(){
        return  Birthdate;
    }
    public String getRegion(){
        return Region;
    }
    public String getZone(){
        return Zone;
    }
    public String getWoreda(){
        return Woreda;
    }
    public String getNationality(){
        return  Nationality;
    }
    public String getFatherFullName(){
        return FatherFullName;
    }
    public int getBirht_certificate_registered_On(){
        return Birht_certificate_registered_On;
    }
    public String getDateOfIssue(){
        return DateOfIssue;
    }
    public String getFullnameofcivilstatusof() {
        return Fullnameofcivilstatusof;

    }
    public int getFileNo(){
        return fileNo;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }

    public void setSSN(int ssn){
        this.ssn = ssn;
    }

    public void setBirthregistrationno_idno(int birthregistrationno_idno){
        this.birthregistrationno_idno = birthregistrationno_idno;

    }

    public void setFirstName(String firstName){
        FirstName = firstName;
    }
    public void setMiddleName(String middleName){
        MiddleName = middleName;

    }
    public void setLastName(String lastName){
        LastName = lastName;
    }
    public void setSex(String sex){
        this.sex = sex;

    }

    public  void setMotherName(String motherName){
        MotherName = motherName;

    }

    public void setBirthdate(String birthdate){
        Birthdate = birthdate;
    }

    public void setRegion(String region){
        Region = region;
    }

    public void setZone(String zone){
        Zone = zone;

    }

    public  void setWoreda(String woreda){
        Woreda = woreda;
    }

    public void setNationality(String nationality){
        Nationality = nationality;

    }

    public void setFatherFullName(String fatherFullName){
        FatherFullName = fatherFullName;
    }

    public void setBirht_certificate_registered_On(int birht_certificate_registered_On){
        Birht_certificate_registered_On = birht_certificate_registered_On;
    }
    public void setDateOfIssue(String dateOfIssue){
        DateOfIssue = dateOfIssue;
    }

    public void setFullnameofcivilstatusof(String fullnameofcivilstatusof){
        Fullnameofcivilstatusof = fullnameofcivilstatusof;
    }
    public void setFileNo(int fileNo){
        this.fileNo = fileNo;
    }
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus=maritalStatus;
    }
}