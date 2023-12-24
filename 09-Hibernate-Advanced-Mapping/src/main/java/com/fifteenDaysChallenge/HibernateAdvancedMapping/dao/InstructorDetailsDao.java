package com.fifteenDaysChallenge.HibernateAdvancedMapping.dao;

import com.fifteenDaysChallenge.HibernateAdvancedMapping.entity.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailsDao extends JpaRepository<InstructorDetails,Integer> {
}
