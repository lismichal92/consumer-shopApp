package com.consumer.shopApp.consumershopApp;

import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

import com.consumer.shopApp.consumershopApp.entity.Response_countProdoFCat;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractTest {


	public JacksonTester<Response_countProdoFCat> json;

	@Before
	public void setup() {
		ObjectMapper objectMappper = new ObjectMapper();
		JacksonTester.initFields(this, objectMappper);
	}
	
}
