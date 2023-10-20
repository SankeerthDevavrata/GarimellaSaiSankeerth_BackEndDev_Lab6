package com.gl.lab6.studentRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gl.lab6.studentRegistration.entity.studentRegistrationInfo;
import com.gl.lab6.studentRegistration.repository.StudentRegistrationRepo;

@Service
public class StudentRegistrationServiceImp implements StudentRegistrationService {
	
	@Autowired
	StudentRegistrationRepo studentRepository;

	@Override
	public List<studentRegistrationInfo> findAll() {
		
		List<studentRegistrationInfo> students = studentRepository.findAll();
		return students;
	}

	@Override
	public studentRegistrationInfo findById(int theId) {
		studentRegistrationInfo student = new studentRegistrationInfo();

		// find record with Id from the database table
		student = studentRepository.findById(theId).get();
		return student;
	}

	@Override
	public studentRegistrationInfo save(studentRegistrationInfo theStudent) {
		
		return studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

	@Override
	public studentRegistrationInfo updateRegistration(int id, studentRegistrationInfo updateRegistration) {
		studentRegistrationInfo registrationUpdate=findById(id);
		registrationUpdate.setFirstName(updateRegistration.getFirstName());
		registrationUpdate.setLastName(updateRegistration.getLastName());
		registrationUpdate.setCountry(updateRegistration.getCountry());
		registrationUpdate.setCourse(updateRegistration.getCourse());
		
		return save(updateRegistration);
	}
	
	public studentRegistrationInfo getRegistrationByFirstName(String name) {
		return studentRepository.findByFirstName(name);
	}

}
