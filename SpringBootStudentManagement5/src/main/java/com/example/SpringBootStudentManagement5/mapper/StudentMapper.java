package com.example.SpringBootStudentManagement5.mapper;

import com.example.SpringBootStudentManagement5.dto.request.StudentRequestDTO;
import com.example.SpringBootStudentManagement5.dto.response.StudentResponseDTO;
import com.example.SpringBootStudentManagement5.entity.Student;

public class StudentMapper {

  //request dto -> entity
  public static Student toEntity(StudentRequestDTO dto) {
    Student student = new Student();
    student.setFirstName(dto.getFirstName());
    student.setLastName(dto.getLastName());
    student.setEmail(dto.getEmail());
    student.setAge(dto.getAge());
    student.setCourse(dto.getCourse());

    return student;
  }

  // entity -> responseDto
  public static StudentResponseDTO toResponseDTO(Student student) {
    return new StudentResponseDTO(
            student.getId(), student.getFirstName(), student.getLastName(),
            student.getEmail(), student.getAge(), student.getCourse()
    );
  }

}
