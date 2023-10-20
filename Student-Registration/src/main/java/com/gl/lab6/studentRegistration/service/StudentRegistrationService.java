package com.gl.lab6.studentRegistration.service;

import java.util.List;

import com.gl.lab6.studentRegistration.entity.studentRegistrationInfo;



public interface StudentRegistrationService {
	
	public List<studentRegistrationInfo> findAll();

	public studentRegistrationInfo findById(int theId);

	public studentRegistrationInfo save(studentRegistrationInfo theStudent);

	public void deleteById(int theId);
	
	public studentRegistrationInfo updateRegistration(int id,studentRegistrationInfo updateRegistration);

}
