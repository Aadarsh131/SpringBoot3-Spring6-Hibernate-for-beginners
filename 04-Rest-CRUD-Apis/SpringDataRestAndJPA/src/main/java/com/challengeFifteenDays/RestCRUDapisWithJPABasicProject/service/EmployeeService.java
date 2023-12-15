package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.service;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
}
