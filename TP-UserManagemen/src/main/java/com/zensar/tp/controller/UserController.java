package com.zensar.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.repo.RegisterUserRepo;
import com.zensar.tp.service.RegisterUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserController { 
	@Autowired
    RegisterUserService registerService;
	
	//@Autowired
	//RegisterUserRepo repo;
	
	@PostMapping(value="/",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="create new user",notes="This service adds a new user")
	public ResponseEntity<RegisterUser> createNewUser(@RequestBody RegisterUser user,@RequestHeader("auth-token")String authToken) {
		if(authToken.equals("ABC123")) {
			
		user=registerService.createNewUser(user,authToken);
		return new ResponseEntity<RegisterUser>(user,HttpStatus.CREATED);
	}
	throw new InvalidUserDataException() ;
	}
}
