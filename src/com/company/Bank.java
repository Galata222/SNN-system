package com.company;
import java.io.Serializable;

public class Bank implements Serializable {
    private int ssn,phonenumber,age,Yearofgraduation;
    private float Cgpa;
    private String FirstName,MiddleName,LastName,gender,Instituteofgraduation,fieldofstudy,positiontype,enrolmenttype,degreetype;
    private String postedtime;

    public String getFirstName(){return FirstName;}
    public String getMiddleName(){return MiddleName;}
    public String getLastName(){return LastName;}
    public String getInstituteofgraduation(){return Instituteofgraduation;}
    public String getGender(){return gender;}
    public String getFieldofstudy(){return fieldofstudy;}
    public String getPositiontype(){return positiontype;}
    public String getEnrolmenttype(){return enrolmenttype;}
    public String getDegreetype(){return degreetype;}
    public String getPostedtime(){return postedtime;}
    public int getPhonenumber(){return phonenumber;}
    public int getSSN(){return ssn;}
    public int getAge(){return age;}
    public int getYearofgraduation(){return Yearofgraduation;}
    public float getCgpa(){return Cgpa;}

    public void setSSN(int ssn){
        this.ssn = ssn;
    }
    public void setPhonenumber(int phonenumber){this.phonenumber = phonenumber;}
    public void setAge(int age){this.age = age;}
    public void setCgpa(float cgpa){Cgpa = cgpa;}
    public void setFirstName(String firstName){FirstName = firstName;}
    public void setMiddleName(String middleName){MiddleName = middleName;}
    public void setLastName(String lastName){LastName = lastName;}
    public void setInstituteofgraduation(String instituteofgraduation){Instituteofgraduation = instituteofgraduation;}
    public void setYearofgraduation(int yearofgraduation){Yearofgraduation = yearofgraduation;}
    public void setGender(String gender){this.gender = gender;}
    public void setFieldofstudy(String fieldofstudy){this.fieldofstudy = fieldofstudy;}
    public void  setPositiontype(String positiontype){this.positiontype = positiontype;}
    public void setEnrolmenttype(String enrolmenttype){this.enrolmenttype = enrolmenttype;}
    public void setDegreetype(String degreetype){this.degreetype = degreetype;}
    public void setPostedtime(String postedtime){this.postedtime = postedtime;}





}