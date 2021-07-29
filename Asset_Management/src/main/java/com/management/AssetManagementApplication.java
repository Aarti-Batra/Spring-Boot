package com.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementApplication.class, args);
	}

}


//Add category of assets. Categories can be like - electronics, furniture etc. A category will have a unique ID, name and description
//DONE=Update category 
//DONE=List of all categories 
//Add an asset. Asset will have a name, purchase date, condition notes, a category, assignment status - Available, Assigned, Recovered. 
//DONE=List of assets
//DONE=Search assets based on name 
//DONE=Update an asset. 
//Assign an asset to an employee 
//Recover an asset from an employee 
//Delete an asset.  The rules here are : An asset cannot be delete which is in assigned state 
//Assume that employees are already there in the database with the following information about them - id (unique id of the employee), full name, designation
