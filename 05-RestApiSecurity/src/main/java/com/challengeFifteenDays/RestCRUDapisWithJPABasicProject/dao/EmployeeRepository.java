package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.dao;

import com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//JpaRepository is from Spring Data JPA, its different that normal JPA, its more high level,we dont need to write any extra code(implementation class, interface class and then injections) its just removes the boilerplate code

//@RepositoryRestResource(path="members")//custom path name/endpoint, instead of default pluralized form  of the entity name
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {//Generice type takes in Entity class, and the type of primary key

/* reduced boilerplate code */
}
