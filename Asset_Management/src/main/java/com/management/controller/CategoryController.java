package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.exceptionHandling.ResourceNotFoundException;
import com.management.model.Assest;
import com.management.model.Category;
import com.management.repo.ManagmentCategoryRepo;
import com.management.service.impl.CategoryService;

@RestController
public class CategoryController {

	@Autowired CategoryService categoryService;
	@Autowired ManagmentCategoryRepo categoryRepo;
	
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategoryDetails() {
		List<Category> list= this.categoryService.getAllCategoryDetails();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PutMapping("/category/{id}")
    public ResponseEntity < Category > updateAssetById(@PathVariable(value = "id") int id, @RequestBody Category category) throws ResourceNotFoundException {
        Category user = categoryRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));
        
        user.setDescription(category.getDescription());
        user.setName(category.getDescription());
        final Category cat = categoryRepo.save(user);
        return ResponseEntity.ok(cat);
    }
	
}
