package com.example.Spring_Boot_Simple_Projects.controller;

import com.example.Spring_Boot_Simple_Projects.entity.Student;
import com.example.Spring_Boot_Simple_Projects.repository.StudentRepository;
import com.example.Spring_Boot_Simple_Projects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    /**
     *   StudentService  .
     */
    @Autowired
    private StudentService studentService;

    /**
     *   StudentRepository  .
     */
    @Autowired
    private StudentRepository studentRepository;


    /**
     *   This methods add student to database  .
     *
     * @param student the student  .
     */
    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        System.out.println("Enter");
        studentService.saveStudent(student);
        System.out.println("Exit");
    }

    /**
     *  This method will fetch all the students from database  .
     *
     * @return list of students  .
     */
    @GetMapping("/get")
    public List<Student> fetchAllStudents() {
        return studentService.fetchStudents();
    }

    /**
     *   this method fetch student with the help of it's id  .
     *
     * @param id the id  .
     * @return student  .
     */
    @GetMapping("/get/{id}")
    public String getStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        System.out.println(student.toString());
        return student.toString();
    }

    /**
     * this method will delete student of the given id  .
     *
     * @param id the id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }


}
