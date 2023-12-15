package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao.StudentDAO;
import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao.StudentDAOimpl;
import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	//for making command line application; it is executed after the spring beans has been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {

			//save()
			Student a = new Student("Aadarsh","Shah","aadarshkumar131@gmail.com");
			Student b = new Student("Atul","Kumar","atul@gmail.com");
			Student c = new Student("Rahul","Jain","rahul34jain@gmail.com");
			studentDAO.save(a);
			studentDAO.save(b);
			studentDAO.save(c);
//			System.out.println(a.getId());
//			System.out.println(b.getId());
//			System.out.println(c.getId());

			//some important CRUD methods
			/*
			//findByID()
			findUsingID(studentDAO,7);

			//findAll()
			List<Student> listOfAllStudent = studentDAO.findAll();
			for(Student student : listOfAllStudent){
				System.out.println(student);
			}

			//findByLastName()
			List<Student> StudentByLastName = studentDAO.findByLastName("Shah");
			for(Student student: StudentByLastName){
				System.out.println(student);
			}

			//update()
			Student student = studentDAO.findById(5);
			student.setEmail("aadarsh@gmail.com");
			studentDAO.update(student);

			//delete()
			Student student1 = studentDAO.findById(2);
			System.out.println(student1);
			studentDAO.delete(student1);

			 */

			studentDAO.deleteAll();
		};
	}

//	public void findUsingID(StudentDAO studentDAO, Integer Id){
//	Student student = studentDAO.findById(Id);
//		System.out.println(student); //is possible because of the Student.toString() method
//	}
}
