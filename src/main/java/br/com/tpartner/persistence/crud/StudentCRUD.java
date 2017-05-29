/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.crud;

import br.com.tpartner.persistence.model.Student;
import br.com.tpartner.persistence.model.TrajectorySummary;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface StudentCRUD {
    /* Client */
    public Student save(Student student);
    public Student update(Student student);
    public void delete(Student student);
    /* Aux */
    public Student findById(Long studentId);
    public List<Student> findAll();

    public TrajectorySummary getSummary(List<Student> students, Date startDate, Date endDate);
}
