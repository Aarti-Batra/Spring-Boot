package com.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.model.Category;

@Repository
public interface ManagmentCategoryRepo extends JpaRepository<Category, Integer> {

}
