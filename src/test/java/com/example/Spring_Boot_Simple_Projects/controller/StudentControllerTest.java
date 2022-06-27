package com.example.Spring_Boot_Simple_Projects.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Spring_Boot_Simple_Projects.entity.Student;
import com.example.Spring_Boot_Simple_Projects.repository.StudentRepository;
import com.example.Spring_Boot_Simple_Projects.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    /**
     *   Add Student  .
     */
    @Test
    void testAddStudent() throws Exception {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        when(this.studentService.saveStudent((Student) any())).thenReturn(student);

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        String content = (new ObjectMapper()).writeValueAsString(student1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     *   Get Student by Id  .
     */
    @Test
    void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        Optional<Student> ofResult = Optional.of(student);
        when(this.studentService.getStudentById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("Optional[Student(studentId=123, firstName=Jane, lastName=Doe, subject=Hello from the Dreaming"
                                + " Spires)]"));
    }

    /**
     *   Delete Student by Id  .
     */
    @Test
    void testDeleteStudentById() throws Exception {
        doNothing().when(this.studentService).deleteStudent((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     *   Delete Student by Id  .
     */
    @Test
    void testDeleteStudentById2() throws Exception {
        doNothing().when(this.studentService).deleteStudent((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     *   Fetch Students  .
     */
    @Test
    void testFetchAllStudents() throws Exception {
        when(this.studentService.fetchStudents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

