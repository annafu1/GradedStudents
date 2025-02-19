package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamTaken(Student student) {
        return student.examScores.size();
    }

    public String getExamScores() {
        StringBuilder str = new StringBuilder();
        str.append("Exam Scores: \n");
        int count = 1;
        for (int i = 0; i < examScores.size(); i++) {
            String strFormat = String.format("%1.1f", examScores.get(i));
            str.append("Exam " + count + strFormat + "\n");
            count++;
        }
        return str.toString();
    }

    public void addExamScores(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScores(int num, double newScore) {
        this.examScores.set(num, newScore);
    }

    public double getAvgScoreOfExam() {
        Double sumAvg = 0.00;
        for (double k : examScores) {
            sumAvg += k;
        }
        double avg = sumAvg / examScores.size();
        return avg;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Student Name:" + firstName + " " + lastName + "\n");
        String avgScoreOfExamStoreIt = String.format("%1.2f", getAvgScoreOfExam());
        str.append("Avg score:" + avgScoreOfExamStoreIt + "\n");
        String allTogether = str.toString();
        return allTogether;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(getAvgScoreOfExam(),getAvgScoreOfExam());
    }
}


