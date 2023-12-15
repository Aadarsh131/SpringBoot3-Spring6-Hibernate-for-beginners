package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.service;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao.EmployeeRepository;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    //have to inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }

    @Override
//    @Transactional //no need to add this annotation as JpaRepository provides it for us
    public Employee save(Employee theEmployee){
       return employeeRepository.save(theEmployee);
    }


    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id){
        Optional<Employee> result= employeeRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("didnot find the employee id: "+id);
        }
    }

    @Override
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
