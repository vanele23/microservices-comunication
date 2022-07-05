package com.newton.resttemplate.microservicescomunication.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.newton.resttemplate.microservicescomunication.rest.OperacionesRest;

public class UtilHeader {
	 private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesRest.class);

	public static HttpEntity <String> obtenerHttpHeaderDefault()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    return entity;
	}
	public static <T> HttpEntity <String> obtenerHttpHeaderDefaultWithBody(JSONObject body)
	{
		LOGGER.info("El body es "+body.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity <String> entity = new HttpEntity<>(body.toString(),headers);
	    return entity;
	}
}
