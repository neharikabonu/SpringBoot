package com.example.SpringBoot3CRUD_project.controller;

import com.example.SpringBoot3CRUD_project.entity.Student;
import com.example.SpringBoot3CRUD_project.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  //post -> Create
  @PostMapping("/students")
  public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    Student savedStudent = studentService.saveStudent(student);
//    return studentService.saveStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
  }

  @GetMapping("/students")
  public ResponseEntity<List<Student>> getAllStudents() {
//    return studentService.getAllStudents();
    return ResponseEntity.ok(studentService.getAllStudents());
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    Student student = studentService.getStudentById(id);
//    return studentService.getStudentById(id);
    return ResponseEntity.status(HttpStatus.OK).body(student);
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student updatedStudent) {
//    return studentService.updateStudent(id, updatedStudent);
    return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
  }

  @PatchMapping("/students/{id}")
  public ResponseEntity<Student> patchStudentById(@PathVariable Long id, @RequestBody Student updatedStudent) {
//    return studentService.patchStudent(id, updatedStudent);
    return ResponseEntity.ok(studentService.patchStudent(id, updatedStudent));
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
  }
}
