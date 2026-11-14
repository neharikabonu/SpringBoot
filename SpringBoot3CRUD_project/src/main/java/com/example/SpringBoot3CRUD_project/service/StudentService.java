package com.example.SpringBoot3CRUD_project.service;

import com.example.SpringBoot3CRUD_project.entity.Student;
import com.example.SpringBoot3CRUD_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  //C-create
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  //R-read all
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  //R- read by id
  public Student getStudentById(Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
  }

  //U-update
  public Student updateStudent(Long id, Student updatedStudent) {
    Student student = getStudentById(id);
    student.setAge(updatedStudent.getAge());
    student.setEmail(updatedStudent.getEmail());
    student.setName(updatedStudent.getName());

    return studentRepository.save(student);
  }

  //D-delete
  public void deleteStudent(Long id) {
    Student student = getStudentById(id);
    studentRepository.delete(student);
  }

  public Student patchStudent(Long id, Student updatedStudent) {
    Student student = getStudentById(id);

    if (updatedStudent.getEmail() != null) {
      student.setEmail(updatedStudent.getEmail());
    }

    if (updatedStudent.getAge() != null) {
      student.setAge(updatedStudent.getAge());
    }

    if (updatedStudent.getName() != null) {
      student.setName(updatedStudent.getName());
    }

    return studentRepository.save(student);
  }
}
