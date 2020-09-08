package com.ma.cityconnection.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CityServiceTest {
	
	private CityService service;
	
	@Before
	public void setUp() {
		this.service = new CityService("C:\\Users\\asksr\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\city-connectivity\\src\\test\\resources\\city.txt");
	}
	
	@Test
	public void itShouldReturnNo() throws Exception {
		assertThat(this.service.areCitiesConnected("Boston", "Albany"),
				is("no"));
	}
	
	@Test
	public void itShouldReturnYes() throws Exception {
		assertThat(this.service.areCitiesConnected("Boston", "Newark"),
				is("yes"));
	}

}
