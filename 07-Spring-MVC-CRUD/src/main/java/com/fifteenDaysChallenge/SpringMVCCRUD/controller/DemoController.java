package com.fifteenDaysChallenge.SpringMVCCRUD.controller;

import com.fifteenDaysChallenge.SpringMVCCRUD.dao.EmployeeRepository;
import com.fifteenDaysChallenge.SpringMVCCRUD.entity.Employee;
import com.fifteenDaysChallenge.SpringMVCCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //for Rest api we must use @RestController; for templates we should use @Controller
@CrossOrigin("http://localhost:5173")
public class DemoController {

	private EmployeeService employeeService;

	@Autowired
	public DemoController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "helloworld";
	}

	@GetMapping("/emplist")
	public List<Employee> list(){
		return employeeService.findAll();
	}
}








