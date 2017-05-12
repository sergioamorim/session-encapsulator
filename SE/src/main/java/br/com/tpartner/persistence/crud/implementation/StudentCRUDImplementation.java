/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.crud.implementation;

import br.com.tpartner.persistence.crud.StudentCRUD;
import br.com.tpartner.persistence.model.Student;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sergio
 */
@Repository
public class StudentCRUDImplementation implements StudentCRUD {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getCurrentSession() {
        return sessionFactory.openSession();
    }
    
    @Override
    public Student save(Student student) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        return student;
    }
    
    @Override
    public Student update(Student student) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
        return student;
    }
    
    @Override
    public void delete(Student student) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(student);
        tx.commit();
        session.close();
    }

    @Override
    public Student findById(Long studentId) {
        Session session = getCurrentSession();
        Criteria createCriteria = session.createCriteria(Student.class);
        createCriteria.add(Restrictions.eq("id", studentId));
        Student student = (Student) createCriteria.uniqueResult();
        session.close();
        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = getCurrentSession();
        List<Student> students = session.createCriteria(Student.class).list();
        session.close();
        return students;
    }
    
}
