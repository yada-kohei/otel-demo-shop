package com.example.demo.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class SignupForm {

  @NotBlank(groups = ValidGroup1.class)
  @Email(groups = ValidGroup2.class)
  private String userId;

  @NotBlank(groups = ValidGroup1.class)
  @Length(min = 4, max = 100, groups = ValidGroup2.class)
  @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
  private String password;

  @NotBlank(groups = ValidGroup1.class)
  private String userName;

  public SignupForm() {
  }

  public String getUserId() {
    return this.userId;
  }

  public String getPassword() {
    return this.password;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserId(final String userId) {
    this.userId = userId;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

}