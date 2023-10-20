package com.gl.lab6.studentRegistration.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.lab6.studentRegistration.entity.studentRegistrationInfo;
import com.gl.lab6.studentRegistration.service.StudentRegistrationServiceImp;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentRegistrationController {
	
	@Autowired
	StudentRegistrationServiceImp registrationService;
	
	@GetMapping("/")
	private String HomePage() {
		return "home";
	}
	
	@GetMapping("/registrations")
	private String studentRegistration(Model model) {
		model.addAttribute("registrations",registrationService.findAll());
		return "registrations";
	}
	
	@GetMapping("/registrations/new")
	private String newRegistration(Model model) {
		studentRegistrationInfo registrations = new studentRegistrationInfo();
		model.addAttribute("register",registrations);
		return "register_student";
	}

	@PostMapping("/registrations")
	private String saveRegistration(@ModelAttribute("register") studentRegistrationInfo student ) {
		registrationService.save(student);
		return "redirect:/registrations";
	}
	
	@GetMapping("/registrations/edit/{id}")
	private String editRegistration(@PathVariable int id , Model model) {
		model.addAttribute("register",registrationService.findById(id));
		return "edit_registration";
	}
	
	@PostMapping("/registrations/{id}")
	private String updateRegistrationById(@PathVariable int id ,@ModelAttribute("employee") studentRegistrationInfo registration ,Model model) {
		registrationService.updateRegistration(id, registration);
		return "redirect:/registrations";
	}

	@GetMapping("/registrations/{id}")
	private String deleteRegistrationseById(@PathVariable int id) {
		registrationService.deleteById(id);
		return "redirect:/registrations";
	}
	
	@PostMapping("/registrations/search")
    private String searchStudentByFirstName(@RequestParam String firstName, Model model) {
      studentRegistrationInfo studentSearch = registrationService.getRegistrationByFirstName(firstName);
      if (studentSearch != null) {
          model.addAttribute("registrations", Collections.singletonList(studentSearch));
      } else {
          model.addAttribute("registrations", Collections.emptyList());
      }
      return "search-student";
  }
	
	

}
