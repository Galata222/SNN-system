package com.company;

import java.io.Serializable;

public class Kebele implements Serializable {
    private int ssn,age,houseNumber,phoneNumber;
    private String firstName,middleName,lastName,motherName,birthPlace,birthdate,sex,nationality,region,
            zone,city,woreda,ganda,emergencyTimeCall,occupation,currentStatus;

    public int getSSN(){
        return ssn;
    }

    public int getAge(){
        return age;
    }


    public int getHouseNumber(){
        return houseNumber;
    }


    public int getPhoneNumber(){
        return phoneNumber;
    }

    public String getFirsName(){
        return firstName;
    }

    public String getMiddleName(){return middleName;}

    public String getLastName(){return lastName;}

    public String getMotherName(){
        return motherName;
    }
    public String getBirthdate(){
        return  birthdate;
    }

    public String getNationality(){
        return nationality;
    }

    public String getRegion(){
        return region;
    }

    public String getWoreda(){
        return woreda;
    }
    public String getBirthPlace(){
        return birthPlace;
    }

    public String getSex(){
        return sex;
    }
    public String getZone(){
        return zone;
    }
    public String getCity(){
        return city;
    }

    public String getGanda(){
        return ganda;
    }

    public String getEmergencytimecall(){
        return emergencyTimeCall;
    }

    public String getOccupation(){
        return occupation;
    }

    public String getCurrentstatus(){
        return currentStatus;
    }

    public void setSSN(int ssn){
        this.ssn = ssn;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName){this.middleName = middleName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public  void setMotherName(String motherName){
        this.motherName = motherName;
    }

    public  void setBirthdate(String birthdate){
        this.birthdate = birthdate;

    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    public void setRegion(String region){
        this.region = region;
    }
    public void setZone(String zone){
        this.zone=zone;
    }
    public  void setWoreda(String woreda){
        this.woreda = woreda;
    }
    public void setHouseNumber(int houseNumber){
        this.houseNumber = houseNumber;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setBirthPlace(String birthPlace){
        this.birthPlace = birthPlace;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setGanda(String ganda){
        this.ganda = ganda;
    }
    public void setEmergencytimecall(String emergencytimecall){
        emergencyTimeCall = emergencytimecall;
    }
    public void setOccupation(String occupation){
        this.occupation = occupation;
    }
    public void setCurrentstatus(String currentstatus){
        currentStatus = currentstatus;
    }

}
   class KebeLogin implements Serializable {
    String pass, use;

        public String getPass(){
            return pass;
        }
        public String getUse(){
            return use;
        }
        public void setPass(String pass){
            this.pass = pass;
        }
       public void setUse(String use){
           this.use = use;
       }
    }
class VitalLogin implements Serializable {
    String pass, use;

    public String getPass(){
        return pass;
    }
    public String getUse(){
        return use;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setUse(String use){
        this.use = use;
    }
}
class HerqaLogin implements Serializable {
    String pass, use;

    public String getPass(){
        return pass;
    }
    public String getUse(){
        return use;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setUse(String use){
        this.use = use;
    }
}
class BankLogin implements Serializable {
    String pass, use;

    public String getPass(){
        return pass;
    }
    public String getUse(){
        return use;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setUse(String use){
        this.use = use;
    }
}
