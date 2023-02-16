package com.example.demo.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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

  @NotNull(groups = ValidGroup1.class)
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date birthday;

  @Min(value = 20, groups = ValidGroup2.class)
  @Max(value = 100, groups = ValidGroup2.class)
  private int age;
  
  @AssertFalse(groups = ValidGroup2.class)
  private boolean marriage;

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

  public Date getBirthday() {
    return this.birthday;
  }

  public int getAge() {
    return this.age;
  }

  public boolean isMarriage() {
    return this.marriage;
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

  public void setBirthday(final Date birthday) {
    this.birthday = birthday;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public void setMarriage(final boolean marriage) {
    this.marriage = marriage;
  }
}