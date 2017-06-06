package com.consumer.shopApp.consumershopApp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.consumer.shopApp.consumershopApp.controller.CategoryController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
//tutaj inaczej???????????????????????  @AutoConfigureStubRunner(workOffline = true , ids = "com.example:shopApp")
@AutoConfigureStubRunner(workOffline = false)
@DirtiesContext
public class CategoryControllerTest {
	
	

	@Autowired MockMvc mockMvc;
	@Autowired CategoryController categoryController;

	@Test public void should_give_me_a_category() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/categoryApi/countProductsOfCategory/1").
				accept(new MediaType("application", "json")))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"categoryName\":\"Motoryzacja\",\"categoryId\":1,\"productCount\":7}"));
	}
	

}
