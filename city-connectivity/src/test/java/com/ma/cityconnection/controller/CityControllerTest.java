package com.ma.cityconnection.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ma.cityconnection.service.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	private CityService service;
	@InjectMocks
	private CityController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	public void itShouldReturnYes() throws Exception {
		/*
		 * when(this.service.areCitiesConnected(any(String.class), any(String.class)))
		 * .thenReturn("yes");
		 */
		this.mockMvc.perform(get("/connected?origin=Boston&destination=Newark"))
		.andExpect(view().name("yes"));
	}
	
	@Test
	public void itShouldReturnNo() throws Exception {
		/*
		 * when(this.service.areCitiesConnected(any(String.class), any(String.class)))
		 * .thenReturn("no");
		 */
		when(this.service.areCitiesConnected("Boston","Albany"))
		  .thenReturn("no");
		this.mockMvc.perform(get("/connected?origin=Boston&destination=Albany"))
		.andExpect(view().name("no"));
	}

}
