package com.datasource.crudhibernate.dao;

import com.datasource.crudhibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDaoImpl implements  StudentDao{

   // Define entityManager object
    private EntityManager entityManager;

    @Autowired
   // initialise entity manager object using constructor injection
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

   // Define save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student",Student.class);

        List<Student> students = theQuery.getResultList();

        return students;
    }

    @Override
    public List<Student> findAllByLastName(String lastnameValue) {
       TypedQuery<Student> theQuery =  entityManager.createQuery("from Student where last_name = :lastNameData",Student.class);

       theQuery.setParameter("lastNameData",lastnameValue);

       return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer studentObjectPK) {
        Student tempStudent = entityManager.find(Student.class,studentObjectPK);
        entityManager.remove(tempStudent);
    }

    @Override
    @Transactional
    public int deleteAllStudent() {
        int numOfRowsUpdated = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numOfRowsUpdated;
    }


}
