package com.kakinos.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
public class Patient {
  @Id
  private String id;

  private String first_name;
  private String last_name;
  private int age;
  private String gender;
  private String city;
  private int pincode;

  public Patient() {

  }

  public Patient(String first_name, String last_name, int age, String gender, String city, int pincode) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.age = age;
    this.gender = gender;
    this.city = city;
    this.pincode = pincode;
  }

  public String getId() {
    return id;
  }

  
  public void setId(String id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public int getPincode() {
    return pincode;
  }

  public void setPincode(int pincode) {
    this.pincode = pincode;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPinCode() {
    return pincode;
  }

  public void setPinCode(int pincode) {
    this.pincode = pincode;
  }

  

  // @Override
  // public String toString() {
  //   return "Patient [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age="  + age + ", gender=" + gender + ", city="  + city + ", pincode=" + pincode + "]";
  // }
}
