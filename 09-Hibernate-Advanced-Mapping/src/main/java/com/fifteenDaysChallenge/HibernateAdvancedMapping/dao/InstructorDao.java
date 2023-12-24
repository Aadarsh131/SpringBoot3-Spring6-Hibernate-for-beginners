package com.fifteenDaysChallenge.HibernateAdvancedMapping.dao;

import com.fifteenDaysChallenge.HibernateAdvancedMapping.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface InstructorDao extends JpaRepository<Instructor, Integer> {
}
