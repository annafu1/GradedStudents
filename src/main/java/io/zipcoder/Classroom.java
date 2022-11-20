package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Classroom {
    Student[] students;

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxNumStudents) {
        students = new Student[maxNumStudents];
    }

    public Classroom(Student[] student) {
        students = student;
    }


    public Student[] getStudents() {
        return this.students;
    }

    public Double getAvgScoreOfExam() {
        Double avgScore = 0.00;
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            for (int j = 0; j < s.examScores.size(); j++) {
                avgScore += s.examScores.get(i);
            }
        }
        Double examScore = avgScore / students.length;
        return examScore;
    }

    public Student[] addStudent(Student student) {
        Student[] newStudents = Arrays.copyOf(students, students.length + 1);
        student = newStudents[newStudents.length - 1];
        students = newStudents;
        return newStudents;
    }

    public void removeStudent(String firstName, String lastName) {
        Student[] newStudents = new Student[students.length - 1];
        int k = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                i++;
            } else if ((students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName))) {
                i++;
            } else {
                newStudents[k] = students[i];
                i++;
                k++;
            }
        }
        students = newStudents;
        int a = 0;
        Student[] adjustNull = new Student[newStudents.length - 1];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                a++;
            }
        }
        students = adjustNull;
    }

    public Student[] getStudentsScore() {
        Arrays.sort(this.students);
        return this.students;
    }

    public HashMap<Character, ArrayList<Student>> getGradeBook() {
        HashMap<Character, ArrayList<Student>> studentGradeGroup = new HashMap<>();
        ArrayList<Student> student1 = new ArrayList<>();
        ArrayList<Student> student2 = new ArrayList<>();
        ArrayList<Student> student3 = new ArrayList<>();
        ArrayList<Student> student4 = new ArrayList<>();
        ArrayList<Student> student5 = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            int count = 0;
            int percent = 0;
            for (int j = 0; j < students.length; j++) {
                if (students[i].getAvgScoreOfExam() > students[j].getAvgScoreOfExam()) {
                    count++;
                }
                percent = (count * 100) / students.length - 1;
                if (percent > 90) {
                    student1.add(students[i]);
                } else if (percent <= 90 && percent >= 70) {
                    student2.add(students[i]);
                } else if (percent <= 70 && percent >= 50) {
                    student3.add(students[i]);
                } else if (percent <= 50 && percent >= 10) {
                    student4.add(students[i]);
                } else {
                    student5.add(students[i]);
                }
                studentGradeGroup.put('A', student1);
                studentGradeGroup.put('B', student2);
                studentGradeGroup.put('C', student3);
                studentGradeGroup.put('D', student4);
                studentGradeGroup.put('F', student5);
                return studentGradeGroup;
            }
        }
        return studentGradeGroup;
    }
}



