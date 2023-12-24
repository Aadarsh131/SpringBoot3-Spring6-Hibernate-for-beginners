package com.fifteenDaysChallenge.SpringMVCCRUD.dao;


import com.fifteenDaysChallenge.SpringMVCCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
