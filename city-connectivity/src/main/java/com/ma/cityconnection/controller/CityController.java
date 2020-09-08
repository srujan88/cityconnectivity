package com.ma.cityconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ma.cityconnection.service.CityService;

/**
 * @author srujan
 * This is the controller class. API's are defined here.
 * For Ex- /connected API -find below
 */
@RestController
public class CityController {
	
	public CityController(@Autowired CityService cityService) {
		
		this.cityService = cityService;
	}

	private CityService cityService;
	
	/**
	 * @param origin
	 * @param destination
	 * @return yes or No
	 * below method is called when /connected API has been consumed.
	 * Service method is called in this method and inputted origin,destination has been passed to service class.
	 * Service class has been autowired in controller.
	 */
	@RequestMapping("/connected")
	public String isConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
		System.out.println("origin: " + origin + " destination:" + destination);
		return cityService.areCitiesConnected(origin, destination);
	}

}
