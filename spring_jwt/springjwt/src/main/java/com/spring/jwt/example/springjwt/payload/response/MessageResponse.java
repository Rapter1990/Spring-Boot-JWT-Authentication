package com.spring.jwt.example.springjwt.payload.response;

import javax.validation.constraints.NotBlank;

import com.spring.jwt.example.springjwt.model.Role;
import com.spring.jwt.example.springjwt.roles.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

	private String message;
}
