package com.consumer.shopApp.consumershopApp.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity
public class CategoryDetails {

	public CategoryDetails() { };

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	//private String value;
	@JsonBackReference
	@ManyToOne
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getValue() {
//		return value;
//	}
//
//	public void setValue(String value) {
//		this.value = value;
//	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
