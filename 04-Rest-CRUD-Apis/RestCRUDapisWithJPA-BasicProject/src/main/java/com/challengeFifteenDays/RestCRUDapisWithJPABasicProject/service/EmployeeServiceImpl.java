package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.service;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao.EmployeeDAO;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao.EmployeeDAOimpl;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    //have to inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    //where are both service layer and DAO layer present, its best practice to use @Transactional on the service layer, hence keeping it here
    public Employee save(Employee theEmployee){
       return employeeDAO.save(theEmployee);
    }


    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id){
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id){
        employeeDAO.deleteById(id);
    }
}
