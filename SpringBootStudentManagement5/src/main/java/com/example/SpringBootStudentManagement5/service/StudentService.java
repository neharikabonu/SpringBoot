package com.example.SpringBootStudentManagement5.service;

import com.example.SpringBootStudentManagement5.mapper.StudentMapper;
import com.example.SpringBootStudentManagement5.dto.request.StudentRequestDTO;
import com.example.SpringBootStudentManagement5.dto.response.StudentResponseDTO;
import com.example.SpringBootStudentManagement5.entity.Student;
import com.example.SpringBootStudentManagement5.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;
import com.example.SpringBootStudentManagement5.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService (StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public StudentResponseDTO addStudent(StudentRequestDTO dto) {
    Student student = StudentMapper.toEntity(dto);
    Student savedStudent = studentRepository.save(student);

    return StudentMapper.toResponseDTO(savedStudent);
  }

  public List<StudentResponseDTO> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    return students.stream()
            .map(StudentMapper::toResponseDTO)
            .toList();
  }

  public StudentResponseDTO getStudentById(Long id) {
    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " +id));

    return StudentMapper.toResponseDTO(student);
  }

  public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " +id));

    student.setFirstName(dto.getFirstName());
    student.setLastName(dto.getLastName());
    student.setEmail(dto.getEmail());
    student.setAge(dto.getAge());
    student.setCourse(dto.getCourse());

    Student updatedStudent = studentRepository.save(student);

    return StudentMapper.toResponseDTO(updatedStudent);
  }

  public void deleteStudent(Long id) {
    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " +id));

    studentRepository.delete(student);
  }
}
