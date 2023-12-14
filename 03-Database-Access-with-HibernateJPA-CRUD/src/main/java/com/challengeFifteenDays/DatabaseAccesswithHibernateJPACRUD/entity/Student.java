package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //we can do custom generation strategy too, for that we would need to override one of the springboot inbuilt methods(is commonly done)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //constructor (Entity class, annotated with @Entity must have 'public' or 'protected' no-args constructor
    //REFRESHER- if we donot declare any ctors, then we will get no-args ctor for free, but if we declare a ctor with args, then we will not get that free ctor by default, but we can ofcourse add a new no-args ctor anytime
    public Student() {

    }

    public Student(String firstname, String lastName, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
    }

    //getter/setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}