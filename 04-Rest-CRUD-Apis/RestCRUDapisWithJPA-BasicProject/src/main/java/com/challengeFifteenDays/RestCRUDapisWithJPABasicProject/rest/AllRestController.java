package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.rest;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao.EmployeeDAO;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao.EmployeeDAOimpl;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AllRestController {

    private EmployeeService employeeService;
    @Autowired
    public AllRestController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee fetchById(@PathVariable int id){ //@PathVariable will capture the id passed as params
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee id not found" + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){ //@RequestBody will take the JSON entered by the user and jakson will convert it to POJO as `Employee` object

        //also just in case they pass in an id in JSON, then set the id to 0
        //this is to force the save of new item instead of update
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
       return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("employee id not found: "+id);
        }
        employeeService.deleteById(id);
        return employee;
    }
}
