package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository is from Spring Data JPA, its different that normal JPA, its more high level,we dont need to write any extra code(implementation class, interface class and then injections) its just removes the boilerplate code

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {//Generice type takes in Entity class, and the type of primary key

/* reduced boilerplate code */
}
