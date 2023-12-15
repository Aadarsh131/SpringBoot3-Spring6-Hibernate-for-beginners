package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao;


import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController, @Repository, and @Service is all under @Component (so there basic functionally is same, helps in injecting beans)
@Repository
public class EmployeeDAOimpl implements EmployeeDAO{
    private EntityManager entityManager;
    private Employee theEmployee;

    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    //where are both service layer and DAO layer present, its best practice to use @Transactional on the service layer
    public Employee save(Employee theEmployee){
        //add or update(it will update if the id != 0)
        return entityManager.merge(theEmployee);
//       entityManager.persist(theEmployee);
    }

    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);

       return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theID){
        Employee employee = entityManager.find(Employee.class,theID);
        return employee;
    }

    @Override
    public void deleteById(int id){
        Employee employee = findById(id);
        entityManager.remove(employee);
    }
}
