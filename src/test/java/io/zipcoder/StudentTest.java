package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetExamScores() {
        //given
        String firstName = "Susan";
        String lastName = "Glen";
        Double[] examScores = {90.0, 75.0, 86.0};
        Student student = new Student(firstName, lastName, examScores);
        //when
        student.addExamScores(45.0);
        String actual = student.getExamScores();
        //then
        System.out.println(actual);

    }


    @Test
    public void testGetAvgScoreOfExam() {
        //given
        String firstName = "Susan";
        String lastName = "Glen";
        Double[] examScores = {90.0, 75.0, 86.0};
        Student student = new Student(firstName, lastName, examScores);
        //when
        Double actual = student.getAvgScoreOfExam();
        //then
        System.out.println(actual);
    }



    @Test
    public void testToString() {
        //given
        String firstName = "Susan";
        String lastName = "Glen";
        Double[] examScores = {90.0, 75.0, 86.0};
        Student student = new Student(firstName, lastName, examScores);
        //when
        String actual = student.toString();
        //then
        System.out.println(actual);
    }

}