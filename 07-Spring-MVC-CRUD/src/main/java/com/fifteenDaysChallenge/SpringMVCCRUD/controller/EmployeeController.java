package com.fifteenDaysChallenge.SpringMVCCRUD.controller;

import com.fifteenDaysChallenge.SpringMVCCRUD.entity.Employee;
import com.fifteenDaysChallenge.SpringMVCCRUD.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {


		// add to the spring model
		theModel.addAttribute("employees", employeeService.findAll());
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
				return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theemployee){ //@ModelAttribute helps to mkae the form data being passed in (data binding)
		employeeService.save(theemployee);

		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int id, Model model){
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}









