package com.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String p_name;
	private String description;
	private Float price;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "category_id", nullable = false)
	 Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long id, String p_name, String description, Float price, Category category) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", p_name=" + p_name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
	
	

	
	

}
