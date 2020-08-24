package com.spring.jwt.example.springjwt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.spring.jwt.example.springjwt.roles.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ROLES_JWT",catalog ="SPRINGDATABASE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"}, exclude = "users")
public class Role {

	@Id
	@SequenceGenerator(name="ROLES_JWT_SEQ", sequenceName="ROLES_JWT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_JWT_SEQ")
	@Column(name="ID", nullable = false)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="NAME",length = 20)
	private ERole name;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="roles")
	private Set<User> users = new HashSet<>();
}
