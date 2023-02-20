package edu.school21.cinema.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Login {
  private String ipAddress;
  private Timestamp loginTime;

  public Login() {
  }

  public Login(String ipAddress, Timestamp loginTime) {
    this.ipAddress = ipAddress;
    this.loginTime = loginTime;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public Timestamp getLoginTime() {
    return loginTime;
  }

  @Override
  public String toString() {
    return "Login{" +
        "ipAddress='" + ipAddress + '\'' +
        ", loginTime=" + loginTime +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Login login = (Login) o;
    return Objects.equals(ipAddress, login.ipAddress) && Objects.equals(loginTime,
        login.loginTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddress, loginTime);
  }
}
