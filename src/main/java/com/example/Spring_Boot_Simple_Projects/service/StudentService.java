package com.example.Spring_Boot_Simple_Projects.service;

import com.example.Spring_Boot_Simple_Projects.entity.Student;
import com.example.Spring_Boot_Simple_Projects.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    /**
     *   Changing 1st know about Merging and the Rebase  .
     *   Changing 2nd know about Merging and the Rebase  .
     *   Changing 3rd know about Merging and the Rebase  .
     *   Changing 4th know about Merging and the Rebase  .
     *   Changing 5th know about Merging and the Rebase  .
     *   StudentRepository
     */
    @Autowired
    private static StudentRepository studentRepository;

    /**
     *   Student list  .
     */
    List<Student> studentList = new ArrayList<>();

    /**
     *   Default Constructor  .
     *
     * @param studentRepository
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     *   Get all students from the database  .
     *
     * @return list of Students  .
     */
    public List<Student> fetchStudents() {
        studentList = (List<Student>) studentRepository.findAll();
        return studentList;
    }

    /**
     *  This method delete student from database  .
     *
     * @param id the Id  .
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * This method fetch Student from database by Id  .
     *
     * @param id the Id  .
     * @return Student  .
     */
    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    /**
     *   This method saves Student in database  .
     *
     * @param student the Student  .
     * @return Student  .
     */
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

}
