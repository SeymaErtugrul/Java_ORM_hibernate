package org.example;

import jakarta.persistence.Table;
import org.example.Model.Student;
import org.example.Util.hibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

Session session= hibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();
            Student student=new Student("seyma","ert");

            Student student1=new Student();
            student1.setName("nana");
            student1.setSurname("ikinci");
            session.save(student1);
            transaction.commit();
            session.close();
       } catch (Exception e) {
            e.printStackTrace();
        }
    }
}