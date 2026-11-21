package com.example.SpringBootStudentManagement5.repository;

import com.example.SpringBootStudentManagement5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
