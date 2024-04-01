package com.App.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.model.Product;
import com.App.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("/products")
	public String createNewProduct(@RequestBody Product product) {
		productRepo.save(product);
		return "Product is created";
	}
	
	@GetMapping("/products")
	public ResponseEntity <List<Product>> getAllProducts(){
		List<Product>productList = new ArrayList<>();
		productRepo.findAll().forEach(productList :: add);
		return new ResponseEntity <List<Product>> (productList,HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity <Product> getProductById(@PathVariable long id){
		Optional<Product>product = productRepo.findById(id);
		if(product.isPresent()) {
			return new ResponseEntity<Product>(product.get(),HttpStatus.FOUND);
			
		}else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/products/{id}")
	public String updateProductById(@PathVariable long id,@RequestBody Product product ) {
		Optional<Product> product1 = productRepo.findById(id);
		if(product1.isPresent()) {
			Product existProduct = product1.get();
			existProduct.setP_name(product.getP_name()); 
			existProduct.setDescription(product.getDescription()); 
			existProduct.setPrice(product.getPrice());
			productRepo.save(existProduct);
			return "Product details against id"+ id +"updated";
		}else {
			return "Details does not exist";
		}
	}
	
	
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable long id) {
		productRepo.deleteById(id);
		return "Product delete Sucessfully";
	}
	
	@DeleteMapping("/products")
	public String deleteAllProduct() {
		productRepo.deleteAll();
		return "All Product delete Sucessfully";
	
}
	


}
