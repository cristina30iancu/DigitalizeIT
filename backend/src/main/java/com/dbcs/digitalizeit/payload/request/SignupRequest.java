package com.dbcs.digitalizeit.payload.request;

import com.dbcs.digitalizeit.models.EmployeeRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(max = 50)
  private String last_name;
  @NotBlank
  @Size(max = 50)
  private String first_name;
  private EmployeeRole role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public EmployeeRole getRole() {
    return this.role;
  }

  public void setRole(EmployeeRole role) {
    this.role = role;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }
}
