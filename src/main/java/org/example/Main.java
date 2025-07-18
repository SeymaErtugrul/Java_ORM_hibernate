package org.example;

import jakarta.persistence.Table;
import org.example.Model.Student;
import org.example.Util.hibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionManagementException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

Session session= hibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();
            Student student=new Student("seyma","ert");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}