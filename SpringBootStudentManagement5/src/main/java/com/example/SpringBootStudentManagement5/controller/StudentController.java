package com.example.SpringBootStudentManagement5.controller;

import com.example.SpringBootStudentManagement5.dto.request.StudentRequestDTO;
import com.example.SpringBootStudentManagement5.dto.response.StudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBootStudentManagement5.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/add-student")
  public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO dto) {
    return studentService.addStudent(dto);
  }

  @GetMapping("")
  public List<StudentResponseDTO> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("{id}")
  public StudentResponseDTO getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id);
  }

  @PutMapping("{id}")
  public StudentResponseDTO updateStudent(@PathVariable Long id,
                                          @Valid @RequestBody StudentRequestDTO dto) {
    return studentService.updateStudent(id, dto);
  }

  @DeleteMapping("{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
  }
}
