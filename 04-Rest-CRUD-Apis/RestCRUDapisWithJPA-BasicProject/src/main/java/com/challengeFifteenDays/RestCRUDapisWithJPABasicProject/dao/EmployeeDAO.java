package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee theEmployee);
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
}
