package com.management.controller;

import java.util.List;
import java.util.Optional;


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
import com.management.repo.ManagmentAssetRepo;
import com.management.service.impl.AssetService;

@RestController

public class AssetController {

	@Autowired
	private AssetService assetService;
	@Autowired
	private ManagmentAssetRepo mangAssetRepo;
	
	@GetMapping("/assets")
	public ResponseEntity<List<Assest>> getAllAssetDetails() {
		List<Assest> list= this.assetService.getAllAssetDetails();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	} 
	
	@PutMapping("/assets/{id}")
    public ResponseEntity < Assest > updateAssetById(@PathVariable(value = "id") int id, @RequestBody Assest asset) throws ResourceNotFoundException {
        Assest user = mangAssetRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));
        user.setAssetName(asset.getAssetName());
        user.setPurchaseDate(asset.getPurchaseDate());
        user.setConditionNote(asset.getConditionNote());
        user.setCategory(asset.getCategory());
        user.setAssignedStatus(asset.getAssignedStatus());
        final Assest updatedUser = mangAssetRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }
	
	@GetMapping("/assets/{name}")
	public ResponseEntity<Assest> getAssetByName(@PathVariable("name")String name)
	{
		 Assest asset=assetService.getAssetByName(name);
		 if(asset==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(asset));
	}
	
	
}
