//package com.gl.lab6.studentRegistration.entity;
//
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.*;
//
//
//
//@Entity
//@Table(name = "users")
//public class User {
//
//	@Id
//	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column(name = "username")
//	private String username;
//	
//	@Column(name = "password")
//	private String password;
//
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(		name = "users_roles", 
//					joinColumns = @JoinColumn(name = "user_id"), 
//					inverseJoinColumns = @JoinColumn(name = "role_id")
//	)
//	private List<Role> roles = new ArrayList<>();
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//
//	public User(Long id, String username, String password, List<Role> roles) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.roles = roles;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
//	}
//
//	public User() {
//
//	}
//	
//	
//}
