package com.example.Spring_Boot_Simple_Projects.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Spring_Boot_Simple_Projects.entity.Student;
import com.example.Spring_Boot_Simple_Projects.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     *   Fetch Students  .
     */
    @Test
    void testFetchStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        when(this.studentRepository.findAll()).thenReturn(studentList);
        List<Student> actualFetchStudentsResult = this.studentService.fetchStudents();
        assertSame(studentList, actualFetchStudentsResult);
        assertTrue(actualFetchStudentsResult.isEmpty());
        verify(this.studentRepository).findAll();
        assertSame(actualFetchStudentsResult, this.studentService.studentList);
    }

    /**
     *   Delete Student  .
     */
    @Test
    void testDeleteStudent() {
        doNothing().when(this.studentRepository).deleteById((Long) any());
        this.studentService.deleteStudent(123L);
        verify(this.studentRepository).deleteById((Long) any());
        assertTrue(this.studentService.studentList.isEmpty());
    }

    /**
     *   Get Student by Id  .
     */
    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        Optional<Student> ofResult = Optional.of(student);
        when(this.studentRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Student> actualStudentById = this.studentService.getStudentById(123L);
        assertSame(ofResult, actualStudentById);
        assertTrue(actualStudentById.isPresent());
        verify(this.studentRepository).findById((Long) any());
    }

    /**
     *   Save student  .
     */
    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        when(this.studentRepository.save((Student) any())).thenReturn(student);

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertSame(student1, this.studentService.saveStudent(student1));
        verify(this.studentRepository).save((Student) any());
    }
}

