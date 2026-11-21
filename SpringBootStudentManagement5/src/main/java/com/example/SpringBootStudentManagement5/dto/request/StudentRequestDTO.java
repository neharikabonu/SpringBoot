package com.example.SpringBootStudentManagement5.dto.request;

import jakarta.validation.constraints.*;

public class StudentRequestDTO {

  @NotBlank(message = "First name is required")
  @Size(min = 2, max = 50, message = "First name must be 2-50 characters")
  private String firstName;

  @NotBlank(message = "Last name is required")
  @Size(min = 2, max = 50, message = "Last name must be 2-50 characters")
  private String lastName;

  @NotBlank(message = "Email is required")
  @Email(message = "Please enter a valid email address")
  private String email;

  @NotNull(message = "Age is required")
  @Min(value = 16, message = "Age must be at least 16")
  private Integer age;

  @NotBlank(message = "Course is required")
  private String course;

  public StudentRequestDTO() {
  }

  public StudentRequestDTO(String firstName, String lastName, String email, Integer age, String course) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.course = course;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }
}