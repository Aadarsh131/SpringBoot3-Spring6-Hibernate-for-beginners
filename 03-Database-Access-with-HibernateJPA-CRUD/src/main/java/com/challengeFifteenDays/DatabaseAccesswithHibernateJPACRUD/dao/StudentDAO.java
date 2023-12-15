package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentDAO {
    //create
    void save(Student theStudent);

    //read
    Student findById(Integer Id);

    //readAll using JPQL (JPA's query langauge)
    List<Student> findAll();

    //find using Lastname (using JPQL)
    List<Student> findByLastName(String LastName);

    //update
    void update(Student student);

    //delete
    void delete(Student student);

    //deleteALL
    void deleteAll();
}
