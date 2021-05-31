package com.kakinos.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
public class Patient {
  @Id
  private String id;

  private String firstName;
  private String lastName;
  private int age;
  private String gender;
  private String city;
  private int pincode;

  public Patient() {

  }

  public Patient(String firstName, String lastName, int age, String gender, String city, int pincode) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public int getPincode() {
    return pincode;
  }

  public void setPincode(int pincode) {
    this.pincode = pincode;
  }

  

  // @Override
  // public String toString() {
  //   return "Patient [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age="  + age + ", gender=" + gender + ", city="  + city + ", pincode=" + pincode + "]";
  // }
}
