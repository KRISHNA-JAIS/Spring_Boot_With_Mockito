package com.example.Spring_Boot_Simple_Projects.repository;

import com.example.Spring_Boot_Simple_Projects.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student save(Student student);



}
