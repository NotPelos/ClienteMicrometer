package com.example.ClienteMicrometer.services;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class StatusService{
	
	private final static Logger logger = LoggerFactory.getLogger(StatusService.class);
	
	RestTemplate rtplate = new RestTemplate();
	
	String url = "http://localhost:8888/";
	
	public String open() {
		String resourceUrl = url + "abierto";	
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("Estado abierto");
		return res.getBody();
	}
	
	public String close() {
		String resourceUrl = url + "cerrado";	
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("Estado cerrado");
		return res.getBody();
	}
	
	public String halfOpen() {
		String resourceUrl = url + "semiabierto";	
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("Estado semiabierto");
		return res.getBody();
	}
	
	
}

