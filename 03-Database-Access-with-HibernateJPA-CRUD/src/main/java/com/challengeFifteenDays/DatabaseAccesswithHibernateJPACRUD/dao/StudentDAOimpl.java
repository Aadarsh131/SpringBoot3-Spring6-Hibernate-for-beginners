package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository //will give support for component scanning and exceptions translations of JDBC
public class StudentDAOimpl implements StudentDAO{

    private EntityManager entityManager;
    private Student theStudent;

    //inject entity manager using ctor injection
    @Autowired
    public StudentDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

   @Override
   @Transactional //will handle the db transactions
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
   }
}
