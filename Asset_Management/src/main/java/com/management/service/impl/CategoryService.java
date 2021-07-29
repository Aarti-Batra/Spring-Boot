package com.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.model.Category;
import com.management.repo.ManagmentCategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private ManagmentCategoryRepo categoryRepo;
	
	
	public List<Category> getAllCategoryDetails() {
		List<Category> list = (List<Category>) this.categoryRepo.findAll();
		return list;
	}
}
