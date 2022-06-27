package com.example.Spring_Boot_Simple_Projects.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        actualStudent.setFirstName("Jane");
        actualStudent.setLastName("Doe");
        actualStudent.setStudentId(123L);
        actualStudent.setSubject("Hello from the Dreaming Spires");
        assertEquals("Jane", actualStudent.getFirstName());
        assertEquals("Doe", actualStudent.getLastName());
        assertEquals(123L, actualStudent.getStudentId().longValue());
        assertEquals("Hello from the Dreaming Spires", actualStudent.getSubject());
    }

    @Test
    void testEquals() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, null);
    }

    @Test
    void testEquals2() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, "Different type to Student");
    }

    @Test
    void testEquals3() {
        Student student = new Student();
        student.setFirstName("Doe");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, student1);
    }

    @Test
    void testEquals4() {
        Student student = new Student();
        student.setFirstName(null);
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Hello from the Dreaming Spires");

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, student1);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals5() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(null);
        student.setSubject("Hello from the Dreaming Spires");

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, student1);
    }

    @Test
    void testEquals6() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject("Jane");

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, student1);
    }

    @Test
    void testEquals7() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setStudentId(123L);
        student.setSubject(null);

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setStudentId(123L);
        student1.setSubject("Hello from the Dreaming Spires");
        assertNotEquals(student, student1);
    }
}

