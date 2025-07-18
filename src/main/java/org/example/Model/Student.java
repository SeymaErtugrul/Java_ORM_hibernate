package org.example.Model;

import jakarta.persistence.*;
import org.example.Util.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="studentName")
    String name;
    @Column(name="studentSurname")
    String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Student getStudentById(int id) {
        Session session = null;
        Transaction transaction = null;
        Student student = null;
        try {
            session = hibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return student;
    }

    public static void saveStudents(String name,String surname) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static List<Student> getAllStudents() {
        Session session = null;
        Transaction transaction = null;
        List<Student> students = null;

        try {
            session = hibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            students = session.createQuery("from Student", Student.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return students;
    }
    public static void updateStudent(int id, String newName, String newSurname) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setName(newName);
                student.setSurname(newSurname);
                session.update(student);
            } else {
                System.out.println("Öğrenci bulunamadı id: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
