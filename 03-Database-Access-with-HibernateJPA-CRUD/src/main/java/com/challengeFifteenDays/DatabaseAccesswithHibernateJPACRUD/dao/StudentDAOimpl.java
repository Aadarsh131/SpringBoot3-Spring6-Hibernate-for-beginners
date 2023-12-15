package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

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

    //no need to to add @Transaction as we are only doing read only work
   @Override
    public Student findById(Integer Id){
        return entityManager.find(Student.class,Id);
   }

   //no need to to add @Transaction as we are only doing read only work
   @Override
    public List<Student> findAll(){
        //JPQL only works with the entity name and entity fields (it doen't know about the actual table name)
       TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class); //"Student" is the entity name; "lastName" is the entity field (which is different from actual column name and table name)
       return theQuery.getResultList();
   }

   @Override
    public List<Student> findByLastName(String LastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData",LastName);
        return theQuery.getResultList();
   }

    @Override
    @Transactional
    public void update(Student student){
        //using JPQL
//        System.out.println(entityManager.createQuery("UPDATE Student SET lastName = 'Tester'").executeUpdate());//update all table rows's last_name to 'Tester'
        entityManager.merge(student);
   }

   @Override
    @Transactional
    public void delete(Student student){
       entityManager.remove(theStudent);

       //using JPQL
//       int rowsDeleted = entityManager.createQuery("DELETE FROM Student WHERE firstname='Aadarsh'").executeUpdate();
//       System.out.println(rowsDeleted);

    }

    @Override
    @Transactional
    public void deleteAll(){
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(rowsDeleted);
    }
}
