package com.kakinos.webapp.model;

import java.util.List;

//import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

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
  private String photos;
  //  private String docs;
  private List<String> docs;

  public Patient() {

  }

  public Patient(String firstName, String lastName, int age, String gender, String city, int pincode, String photos, List<String> docs) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.city = city;
    this.pincode = pincode;
    this.photos = photos;
    this.docs=docs;
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

  public String getPhotos() {
    return photos;
  }

  public void setPhotos(String photos) {
    this.photos = photos;
  }

  
  // public String getDocs() {
  //   return docs;
  // }
  // public void setDocs(String fileNames) {
  //   this.docs = fileNames;
  // }

  public List<String> getDocs() {
    return docs;
  }

  public void setDocs(List<String> docs) {
    this.docs = docs;
  }

  @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
        // if (photos == null) return null;
        return "/patient-photos/" + id + "/" + photos;
    }

    @Transient
    public String getDocsFilePath() {
    //  if (doc == null || id == null) return null;
      // if (photos == null) return null;
      return "/patient-docs/" + id + "/";
    }
    //byte[] data = ReportsUtils.generateReport(document).getData();

  // @Override
  // public String toString() {
  //   return "Patient [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age="  + age + ", gender=" + gender + ", city="  + city + ", pincode=" + pincode + "]";
  // }
}
