//package com.gl.lab6.studentRegistration.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.gl.lab6.studentRegistration.entity.User;
//import com.gl.lab6.studentRegistration.repository.UserRepository;
//import com.gl.lab6.studentRegistration.security.MyUserDetails;
//
//
//
//
//
//public class UserDetailsServiceImp implements UserDetailsService {
//
//	   @Autowired
//	    private UserRepository userRepository;
//	     
//	    @Override
//	    public UserDetails loadUserByUsername(String username)
//	            throws UsernameNotFoundException {
//	        User user = userRepository.findByUsername(username);
//	         
//	        if (user == null) {
//	            throw new UsernameNotFoundException("Could not find user");
//	        }
//	         
//	        return new MyUserDetails(user);
//	    }
//
//}
