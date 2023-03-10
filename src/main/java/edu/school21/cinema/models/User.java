package edu.school21.cinema.models;

import java.util.List;
import java.util.Objects;

public class User {
  private Long id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String password;
  private List<Image> images;
  private List<Login> logins;

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public void setLogins(List<Login> logins) {
    this.logins = logins;
  }

  public List<Image> getImages() {
    return images;
  }

  public List<Login> getLogins() {
    return logins;
  }

  public User() {
  }

  public User(Long id, String firstName, String lastName, String phoneNumber, String password) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  public User(String firstName, String lastName, String phoneNumber, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  public User(Long id, String firstName, String lastName, String phoneNumber, String password,
      List<Image> images, List<Login> logins) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.images = images;
    this.logins = logins;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{\n" +
        "\tid=" + id +
        ",\n\tfirstName='" + firstName + '\'' +
        ",\n\tlastName='" + lastName + '\'' +
        ",\n\tphoneNumber='" + phoneNumber + '\'' +
        ",\n\tpassword='" + password + '\'' +
        "\n}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return firstName.equals(user.firstName) && lastName.equals(
        user.lastName) && phoneNumber.equals(user.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, phoneNumber, password);
  }
}
