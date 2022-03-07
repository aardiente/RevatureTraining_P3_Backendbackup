package com.revature.revspace.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.revature.revspace.app.RevSpaceWebServiceApplication;
import com.revature.revspace.models.User;
import com.revature.revspace.services.UserService;
import com.revature.revspace.services.UserServiceImpl;
import com.revature.revspace.testutils.ModelGenerators;

@AutoConfigureMockMvc
@SpringBootTest(classes = RevSpaceWebServiceApplication.class)
@TestPropertySource("classpath:application-test.properties")
public class SearchControllerTest {
	
	private static final String TEST_EMAIL = "testemail@revature.net";
	
	private static final String TEST_NAME = "Search Feature";
	
	@MockBean
	private UserService service;
	
//	@MockBean
//	private UserServiceImpl serviceI;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@WithMockUser(username=TEST_EMAIL)
	void getUserByEmail() throws Exception
	{
		User user = ModelGenerators.makeRandomUser();

		Mockito.when(service.getUserByEmail(TEST_EMAIL))
			.thenReturn(user);
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/users/search/email?email=testemail@revature.net")
			.contentType("application/json")
			.content("{}"));
		actions.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@WithMockUser(value=TEST_NAME)
	void getUserByName() throws Exception
	{
		User user = ModelGenerators.makeRandomUser();
		
		String[] userName = TEST_NAME.split("\\s+");

		Mockito.when(service.getUserByName(userName[0], userName[1]))
			.thenReturn(user);
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/users/search/name?firstname=Search&lastname=Feature")
			.contentType("application/json")
			.content("{}"));
		actions.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
