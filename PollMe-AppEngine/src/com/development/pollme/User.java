package com.development.pollme;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;

//TODO: Da rivedere
@Entity
public class User {

	@Id
    private String email;
    private String pwd;
    //immagine personale
    private Key imgK;
    private String name;
    private String surname;
    private Date birthDate;
    private char gender;
    private String city;
    //provincia
    private String district;
    private String cap;
    private String nation;
    //statoCivile
    private String status;
    private String education;
         
//metodi GET
    public String getEmail() {
    	   return email;
    	 }
    	 
    
    public String getPwd() {
 	   return pwd;
 	 }
    
    public Key getImgK(){ 
    	return imgK; 
    	}
    
    public String getName() {
 	   return name;
 	 }
    
    public String getSurname() {
 	   return surname;
 	 }
    
    public Date getBirthDate() {
 	   return birthDate;
 	 }
    
    public char getGender() {
 	   return gender;
 	 }
    
    public String getCity() {
 	   return city;
 	 }
    
    public String getDistrict() {
 	   return district;
 	 }
    
    public String getCAP() {
 	   return cap;
 	 }
    
    public String getNation() {
 	   return nation;
 	 }
    
    public String getStatus() {
 	   return status;
 	 }
    
    public String getEducation() {
 	   return education;
 	 }
    
//metodi SET    
    
    public void setEmail(String mail){
    	   this.email = mail;
    }
    
    public void setPwd(String password) {
    	   this.pwd = password;
    	 }
       
    public void setImageK(Key key)    { 
    	this.imgK = key; 
    	}
    
    public void setName(String n) {
  	   this.name = n;
  	 }
     
     public void setSurname(String s) {
  	   this.surname = s;
  	 }
     
     public void setBirthData(Date data) {
  	   this.birthDate = data;
  	 }
     
     public void setGender(char sex) {
  	   this.gender = sex;
  	 }
     
     public void setCity(String c) {
  	   this.city = c;
  	 }
     
     public void setDistrict(String dist) {
  	   this.district = dist;
  	 }
     
     public void setCAP(String code) {
  	   this.cap = code;
  	 }
     
     public void setNation(String nat) {
  	   this.nation = nat;
  	 }
     
     public void setStatus(String st) {
  	   this.status = st;
  	 }
     
     public void setEducation(String edu) {
  	   this.education = edu;
  	 }
}
