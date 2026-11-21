package com.example.SpringBootStudentManagement5.exception;

public class StudentNotFoundException extends RuntimeException{

  public StudentNotFoundException(String message) {
    super(message);
  }
}
