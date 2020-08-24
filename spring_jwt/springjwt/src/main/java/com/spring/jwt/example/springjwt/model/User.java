package com.spring.jwt.example.springjwt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERS_JWT",catalog ="SPRINGDATABASE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@SequenceGenerator(name="USERS_JWT_SEQ", sequenceName="USERS_JWT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_JWT_SEQ")
	@Column(name="ID", nullable = false)
	private long id;
	
	@NotBlank
	@Column(name="USERNAME")
	@Size(max = 50)
	private String  username;
	
	@NotBlank
	@Column(name="EMAIL")
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Column(name="PASSWORD")
	@Size(max = 120)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(	name = "USER_ROLES", 
				joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), 
				inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private Set<Role> roles = new HashSet<>();
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
