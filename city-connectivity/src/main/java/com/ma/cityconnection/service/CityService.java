package com.ma.cityconnection.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author srujan
 * This service checks whether given origin and destination are connected or not.
 *
 */
@Service
public class CityService {
	
	private String fileName;
	
	CityService(@Value("${filename}") String fileName) {
		this.fileName = fileName;
	}
	
	 /**
	  * In this service we will be comparing the origin and destination in the data file and will be returning yes if they
	  * are in the same line.
	 * @param origin
	 * @param destination
	 * @return Yes or No
	 */
	public String areCitiesConnected(String origin, String destination ) {
		//String fileName = "C:\\Users\\asksr\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\city-connectivity\\src\\main\\resources\\city.txt";
		System.out.println("fN: " + this.fileName);
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(this.fileName))) {

			
			list = stream
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).contains(origin) && list.get(i).contains(destination)) {
				return "yes";
			}
		}
		
		return "no";
	}
}
