package com.newton.resttemplate.microservicescomunication.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.newton.resttemplate.microservicescomunication.utils.UtilHeader;

@Service
public class PoiService {

	@Autowired
	@Qualifier("restPoi")
	private RestTemplate restTemplate;
	
	
	
	public String autenticar(String username, String password)
	{
		try {
			Map<String, Object> body = new HashMap<>();
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("username", username);
			jsonUser.put("password", password);
			
			ResponseEntity<String> response= restTemplate.postForEntity("/api/auth", UtilHeader.obtenerHttpHeaderDefaultWithBody(jsonUser), String.class);
			
			System.out.println("Respuesta");
		    System.out.println(response.getBody());
		    return response.getBody();
		}
		catch (HttpClientErrorException ex)
		{
			System.out.println("Error");
		    System.out.println(ex.getStatusCode());
			return ex.getResponseBodyAsString();
		}
		
	}
}
