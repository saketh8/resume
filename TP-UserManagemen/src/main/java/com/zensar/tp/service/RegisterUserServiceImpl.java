package com.zensar.tp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.entity.RegisterUserEntity;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.repo.RegisterUserRepo;
import com.zensar.tp.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
	@Autowired
	RegisterUserRepo userRepo;
	
	ModelMapper mapper=new ModelMapper();
	
	@Override
	public RegisterUser createNewUser(RegisterUser user,String authToken) {
		if((user.getFirstName()!= null) && (user.getLastName()!= null) && (user.getUserName()!= null) && 
				(user.getEmail()!= null) && (user.getPassword()!= null) && (user.getPhone()!= null)) {
			RegisterUserEntity entity=mapper.map(user,RegisterUserEntity.class);
			entity=userRepo.save(entity);
			user=mapper.map(entity, RegisterUser.class);
			return user;
		}
		throw new InvalidUserDataException( );
	}
}