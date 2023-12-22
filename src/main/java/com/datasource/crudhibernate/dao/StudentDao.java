package com.datasource.crudhibernate.dao;

import com.datasource.crudhibernate.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllByLastName(String lastnameValue);

    void updateStudent(Student student);

    void deleteStudent(Integer studentObjectPK);

    int deleteAllStudent();
}
