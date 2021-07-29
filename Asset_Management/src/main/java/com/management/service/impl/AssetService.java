package com.management.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.model.Assest;
import com.management.repo.ManagmentAssetRepo;

@Service
public class AssetService {

	@Autowired
	private ManagmentAssetRepo mangAssetRepo;
	
	
	public List<Assest> getAllAssetDetails() {
		List<Assest> list = (List<Assest>) this.mangAssetRepo.findAll();
		return list;
	}
	
	
	public Assest getAssetByName(String name) {
		Assest asset = null;
		try {
		asset=this.mangAssetRepo.findByName(name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return asset;
	}
	
	public void deleteBook(int bid) {
		Assest asset= new Assest();
		
		
		
		this.mangAssetRepo.deleteById(bid);
		
	}
}

