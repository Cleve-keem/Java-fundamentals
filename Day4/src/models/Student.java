package models;
import java.util.Arrays;

public class Student {
    int id;
    String name;
    int score;
    String subject;
    String grade;

    Student(int id, String name, int score, String subject) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.subject = subject;
    }

    Student(int id, String name, int score, String subject, String grade) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.subject = subject;
        this.grade = grade;
    }

    static Student[] getPassingStudents(Student[] students, int passMark) {
        return Arrays.stream(students).filter(student -> student.score >= passMark).toArray(Student[]::new);
    }

    static double getAverageScore(Student[] students) {
        return Arrays.stream(students).map(student -> student.score).reduce(0, (sum, score) -> sum + score);
    }

    static Student getTopStudent(Student[] students) {
        Student topStudent = students[0];
        for (Student student : students) {
            if (student.score > topStudent.score)
                topStudent = student;
        }

        return topStudent;
    }

    static Student[] addStudentGrades(Student[] students) {
        return Arrays.stream(students).map(student -> new Student(student.id, student.name, student.score,
                student.subject, assignGrade(student.score))).toArray(Student[]::new);
    }

    @Override
    public String toString() {
        return name + "-" + score + "-" + subject;
    }

}