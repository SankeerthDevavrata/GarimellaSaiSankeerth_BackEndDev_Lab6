package com.gl.lab6.studentRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.lab6.studentRegistration.entity.studentRegistrationInfo;

@Repository
public interface StudentRegistrationRepo extends JpaRepository<studentRegistrationInfo, Integer> {
	studentRegistrationInfo findByFirstName(String firstName);
}
