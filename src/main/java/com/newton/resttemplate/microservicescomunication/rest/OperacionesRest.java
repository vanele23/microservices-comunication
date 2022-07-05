package com.newton.resttemplate.microservicescomunication.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.resttemplate.microservicescomunication.service.*;
import com.newton.resttemplate.microservicescomunication.rest.OperacionesRest;

@RestController
@RequestMapping(value="/smpp", produces = MediaType.APPLICATION_JSON_VALUE)
public class OperacionesRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesRest.class);

    @Autowired
    OperacionesSmppService operacionesSmpp;
    
    @Autowired 
    PoiService poiService;
    
    @GetMapping("/operaciones")
    public ResponseEntity<String> operaciones() {
        LOGGER.info("Comunicacion con Operaciones SMPP");
        
        String respuesta =  operacionesSmpp.autenticar("demo","12456");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @GetMapping("/poi")
    public ResponseEntity<String> poi() {
        LOGGER.info("Comunicacion con login SIPOI");
        //password incorrecto
       String respuesta;
       //respuesta=  poiService.autenticar("federix","testing");
       //password correcto
       respuesta =  poiService.autenticar("federix","ae2b1fca515949e5d54fb22b8ed95575");
       return new ResponseEntity<>(respuesta, HttpStatus.OK);
      
    }

}

