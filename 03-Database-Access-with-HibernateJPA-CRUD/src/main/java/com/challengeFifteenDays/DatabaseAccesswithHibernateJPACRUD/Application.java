package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao.StudentDAO;
import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao.StudentDAOimpl;
import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	//for making command line application; it is executed after the spring beans has been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			Student a = new Student("Aadarsh","Shah","aadarshkumar131@gmail.com");
			studentDAO.save(a);
			System.out.println(a.getId());
		};
	}
}
