package com.consumer.shopApp.consumershopApp.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumer.shopApp.consumershopApp.entity.Response_countProdoFCat;

@RestController
@RequestMapping(value = "/categoryApi/")
public class CategoryController {

	public CategoryController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	private final RestTemplate restTemplate;

	final int port = 8080;

	@RequestMapping(value = "/getCategoryById/{id}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response_countProdoFCat> getCategoryById(@PathVariable("id") int id) {
	
		RequestEntity re = new RequestEntity<Response_countProdoFCat>
		(HttpMethod.GET,URI.create("http://localhost:" + port + "/category/countProductsOfCategory/" + id));
		
		ResponseEntity<Response_countProdoFCat> response = this.restTemplate
				.exchange(re,Response_countProdoFCat.class);
		return response;

	}
	

}
