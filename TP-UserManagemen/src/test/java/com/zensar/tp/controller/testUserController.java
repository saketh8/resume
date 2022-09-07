package com.zensar.tp.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.service.RegisterUserService;


@WebMvcTest(UserController.class)
public class testUserController {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	RegisterUserService userService;
	@Autowired
	ObjectMapper objectMapper;
	@Test
	public void testRegisterUser() throws Exception{
		RegisterUser user = new RegisterUser();
		user.setFirstName("Anand");
		user.setLastName("Kulkarni");
		user.setUserName("anand");
		user.setPassword("anand123");
		user.setEmail("anand@gmail.com");
		user.setPhone("9999999999");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("auth-token", "ABC123");
		
		when(this.userService.createNewUser(user, "ABC123")).thenReturn(user);
		
		MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:9030/user/")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user))
				.headers(httpHeaders))
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("Anand")))
				.andReturn();
		
				String response = mvcResult.getResponse().getContentAsString();
				assertEquals(response.contains("Anand"), true);
		}
	
	 @Test
	 public void testRegisterUser1() throws Exception{
					RegisterUser user = new RegisterUser();
					user.setFirstName("Anand");
				    user.setLastName("Kulkarni");
				    user.setUserName("anand");
				    user.setPassword("anand123");
				    user.setEmail("anand@gmail.com");
				    user.setPhone("9999999999");
				    
				    HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.set("auth-token", "ABC123");
					
				    when(this.userService.createNewUser(user,"ABC123")).thenReturn(user);
				    
				    MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:9030/user/")
				    		.contentType("application/json")
				    		.content(objectMapper.writeValueAsString(user))
				    		.headers(httpHeaders))
				    		.andExpect(status().isCreated())
				    		.andReturn();
				    		String response = mvcResult.getResponse().getContentAsString();
							assertEquals(response.contains("Saketh"), false);
	 }
}


