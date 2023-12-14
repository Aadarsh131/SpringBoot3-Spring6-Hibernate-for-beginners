package com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.dao;

import com.challengeFifteenDays.DatabaseAccesswithHibernateJPACRUD.entity.Student;
import org.springframework.stereotype.Component;

public interface StudentDAO {
    void save(Student theStudent);
}
