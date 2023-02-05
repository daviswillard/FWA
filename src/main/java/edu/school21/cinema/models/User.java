package edu.school21.cinema.models;

import java.util.Objects;

public class User {
  private Long id;
  private String firstName;
  private String secondName;
  private String phoneNumber;
  private String password;

  public User() {
  }

  public User(Long id, String firstName, String secondName, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.phoneNumber = phoneNumber;
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

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
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
        ",\n\tsecondName='" + secondName + '\'' +
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
    return id.equals(user.id) && firstName.equals(user.firstName) && secondName.equals(
        user.secondName) && phoneNumber.equals(user.phoneNumber) && password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, secondName, phoneNumber, password);
  }
}
