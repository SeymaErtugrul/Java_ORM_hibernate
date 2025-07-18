package org.example;

import jakarta.persistence.Table;
import org.example.Model.Student;
import org.example.Util.hibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Student student = new Student();
        student.getStudentById(2);

        Student.saveStudents("seymas", "ert");

        List<Student> allStudents = Student.getAllStudents();

        for (Student s : allStudents) {
            System.out.println(s.getName() + " " + s.getSurname());
        }

    }
}


