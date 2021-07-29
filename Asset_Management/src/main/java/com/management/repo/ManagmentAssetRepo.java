package com.management.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.model.Assest;

@Repository
public interface ManagmentAssetRepo extends JpaRepository<Assest, Integer>{

	@Query("select u from Assest u where u.assetName = ?1")
	Assest findByName(String assetName);
	
	
}
