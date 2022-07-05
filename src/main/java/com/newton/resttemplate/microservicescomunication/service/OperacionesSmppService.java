package com.newton.resttemplate.microservicescomunication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newton.resttemplate.microservicescomunication.utils.UtilHeader;

@Service
public class OperacionesSmppService {
	
	@Autowired
	@Qualifier("restOperaciones")
	private RestTemplate restTemplate;
	
	
	
	public String autenticar(String userId, String password)
	{
		  
	      
	      return restTemplate.exchange("/operaciones", HttpMethod.GET,UtilHeader.obtenerHttpHeaderDefault(), String.class).getBody();
	   
		
	}

}
