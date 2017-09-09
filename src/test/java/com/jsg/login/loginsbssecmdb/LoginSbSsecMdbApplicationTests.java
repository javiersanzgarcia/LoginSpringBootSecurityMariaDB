package com.jsg.login.loginsbssecmdb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jsg.login.resource.HelloResource;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginSbSsecMdbApplicationTests {

	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloResource helloResource;

	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
	}
	
	@Test
	public void testPublicUrl() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/all"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello Javi"));
				
	}

	@Test
	public void testPublicBadUrl() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/test"))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
				
	}
	
	@Test
	public void testPrivateUrl() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/secured/all"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Secured Hello"));
				
	}
	
	@Test
	public void testAlternatePrivateUrl() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/secured/alternate"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("alternate"));
				
	}
	
}
