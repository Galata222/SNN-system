package com.company;
import java.io.Serializable;

public class Herqa implements Serializable {
    private int SSN,Age,Grade12result;
    private float Grade8result,Grade10result,cgpa;
    private String FirstName,MiddleName,LastName,sex,Instituteofgraduation,Departement,Yeargraduation,Educationstatus;

    public int getSSN(){return SSN;}
    public int getAge(){return Age;}
    public int getGrade12result(){return Grade12result;}
    public float getGrade8result(){return Grade8result;}
    public float getGrade10result(){return Grade10result;}
    public float getCgpa(){return cgpa;}
    public String getSex(){return sex;}
    public String getFirstName(){return FirstName;}
    public String getMiddleName(){return MiddleName;}
    public String getLastName(){return LastName;}
    public String getInstituteofgraduation(){return Instituteofgraduation;}
    public String getDepartement(){return Departement;}
    public String getYeargraduation(){return Yeargraduation;}
    public String getEducationstatus(){return Educationstatus;}


    public void setSSN(int ssn){SSN = ssn;}
    public void setAge(int age){Age = age;}
    public void setSex(String sex){this.sex = sex;}
    public void setGrade12result(int Grade12result){this.Grade12result = Grade12result;}
    public void setFirstName(String firstName){FirstName = firstName;}
    public void setMiddleName(String middleName){MiddleName = middleName;}
    public void setLastName(String lastName){LastName = lastName;}
    public void setGrade8result(float grade8result){Grade8result = grade8result;}
    public void setGrade10result(float grade10result){Grade10result = grade10result;}
    public void setCgpa(float cgpa){this.cgpa =cgpa;}
    public void setInstituteofgraduation(String instituteofgraduation){Instituteofgraduation = instituteofgraduation;}
    public void setDepartement(String departement){Departement = departement;}
    public void setYeargraduation(String yeargraduation){Yeargraduation = yeargraduation;}
    public void setEducationstatus(String educationstatus){Educationstatus = educationstatus;}


}