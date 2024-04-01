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

import com.App.model.Category;
import com.App.repository.CategoryRepository;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@PostMapping("/categories")
	public String createNewCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return "Category is created";
	}
	
	@GetMapping("/categories")
	public ResponseEntity <List<Category>> getAllCategories(){
		List<Category>categoryList = new ArrayList<>();
		categoryRepo.findAll().forEach(categoryList :: add);
		return new ResponseEntity <List<Category>> (categoryList,HttpStatus.OK);
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity <Category> getCategoryById(@PathVariable long id){
		Optional<Category>categ= categoryRepo.findById(id);
		if(categ.isPresent()) {
			return new ResponseEntity<Category>(categ.get(),HttpStatus.FOUND);
			
		}else {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/categories/{id}")
	public String updateCategoryById(@PathVariable long id,@RequestBody Category category ) {
		Optional<Category> categ = categoryRepo.findById(id);
		if(categ.isPresent()) {
			Category existCategory = categ.get();
			existCategory.setCategoryName(category.getCategoryName()); 
			existCategory.setDescription(category.getDescription()); 
			existCategory.setImageUrl(category.getImageUrl());
			categoryRepo.save(existCategory);
			return "Category against id"+ id +"updated";
		}else {
			return "Details does not exist";
		}
	}
	
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategoryById(@PathVariable long id) {
		categoryRepo.deleteById(id);
		return "Category delete Sucessfully";
	}
	
	@DeleteMapping("/categories")
	public String deleteAllProduct() {
		categoryRepo.deleteAll();
		return "All Category delete Sucessfully";
	
}
	

}
