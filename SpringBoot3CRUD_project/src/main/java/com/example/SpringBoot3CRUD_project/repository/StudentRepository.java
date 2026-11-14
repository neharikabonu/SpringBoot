package com.example.SpringBoot3CRUD_project.repository;

import com.example.SpringBoot3CRUD_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
