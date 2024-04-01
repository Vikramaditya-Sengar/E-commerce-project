package com.App.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="category")

	public class Category {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="category_name")
		private String categoryName;
		
		private String description;
		
		@Column(name="image_url")
		private String imageUrl;

		@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
				cascade = CascadeType.ALL)
		Set<Product> product;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Set<Product> getProduct() {
			return product;
		}

		public void setProduct(Set<Product> product) {
			this.product = product;
		}

		public Category(Long id, String categoryName, String description, String imageUrl, Set<Product> product) {
			super();
			this.id = id;
			this.categoryName = categoryName;
			this.description = description;
			this.imageUrl = imageUrl;
			this.product = product;
		}

		public Category() {
			
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", categoryName=" + categoryName + ", description=" + description
					+ ", imageUrl=" + imageUrl + ", product=" + product + "]";
		}
	
		

}
