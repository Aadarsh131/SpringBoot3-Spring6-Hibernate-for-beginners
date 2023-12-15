package com.challengeFifteenDays.RESTCRUDAPIs.rest;

import com.challengeFifteenDays.RESTCRUDAPIs.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class crudapplication {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Aadash","Kr Shah"));
        students.add(new Student("Akshay","raina"));
        students.add(new Student("Sanjay","Sighania"));
    }

    @GetMapping("/students")
    //All the POJO objects will be automatically converted to JSON and vice versa by Spring in built Jackson
    public List<Student> getStudents(){
        return students; //Jackson will convert it into JSON behing the scenes
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if (studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("student id "+studentId +" Not found!");
        }
        return students.get(studentId);
    }





}
