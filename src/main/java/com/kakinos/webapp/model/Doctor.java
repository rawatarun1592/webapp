package com.kakinos.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctor")
public class Doctor {
  @Id
  private String id;

  private String firstName;
  private String lastName;
  private String specialization;
  private int phoneNumber;
  private String address;
  private String city;
  private int pincode;

  public Doctor() {

  }

  public Doctor(String firstName, String lastName, String specialization, int phoneNumber, String address, String city, int pincode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.specialization = specialization;
    this.phoneNumber = phoneNumber;
    this.address = address;
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

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  
}
