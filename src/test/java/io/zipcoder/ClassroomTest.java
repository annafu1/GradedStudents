package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void testAvgScoreOfExam() {
        //given
        Double[] score1 = {85.00, 84.00, 37.00};
        Double[] score2 = {38.00, 76.00, 95.00};
        Student s1 = new Student ("student", "one", score1);
        Student s2 = new Student ("student", "two", score2);
        Student[] students = {s1, s2};
        Classroom classroom = new Classroom((students));
        //when
        double result = classroom.getAvgScoreOfExam();
        //then
        System.out.println(result);
    }

    @Test
    public void testAddStudent() {
        //given
        int maxStudents = 1;
        Classroom classroom = new Classroom(maxStudents);
        Double[] scoresOnExam = {85.00, 38.00, 76.00};
        Student student = new Student("Susan", "Glen", scoresOnExam);
        //when
        Student[] preStuds = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postStuds = classroom.getStudents();

        //then
        String preStuds1 = Arrays.toString(preStuds);
        String postStuds1 = Arrays.toString(postStuds);
        System.out.println("=====================");
        System.out.println(preStuds1);
        System.out.println("=====================");
        System.out.println(postStuds1);

    }

    @Test
    public void testRemoveStudent() {
        //given
        int maxStudents = 2;
        Classroom classroom = new Classroom(maxStudents);
        Double[] scoresOnExam = {85.00, 38.00, 76.00};
        Student student = new Student("Susan", "Glen", scoresOnExam);
        Double[] scoresOnExam1 = {87.00, 68.00, 96.00};
        Student student1 = new Student("Susan", "Pump", scoresOnExam1);
        //when
        classroom.addStudent(student);
        classroom.addStudent(student1);
        Student[] preStuds = classroom.getStudents();
        classroom.removeStudent(student.firstName, student.lastName);
        Student[] postStuds = classroom.getStudents();

        //then
        String preStuds1 = Arrays.toString(preStuds);
        String postStuds1 = Arrays.toString(postStuds);
        System.out.println("=====================");
        System.out.println(preStuds1);
        System.out.println("=====================");
        System.out.println(postStuds1);
    }

//    @Test
//    public void testStudentsScore() {
//        //given
//        //when
//        //then
//    }

    @Test
    public void testGradeBook() {
        //given
        Double[] scoresOnExam = {85.0,95.0,76.0};
        Student s1 = new Student ("Peter", "Spider", scoresOnExam);
        Double[] scoresOnExam1 = {85.0,95.0,76.0};
        Student s2 = new Student ("Susan", "Glee", scoresOnExam1);
        Double[] scoresOnExam2 = {85.0,95.0,76.0};
        Student s3 = new Student ("Mitch", "Modern", scoresOnExam2);

        //when
        Student[] students = {s1, s2, s3};
        Student[] expected = {s2,s1, s3};
        Classroom classroom = new Classroom(students);
        Student[] actual = classroom.getStudentsScore();
        //then
        Assert.assertEquals(expected,actual);
    }
}
