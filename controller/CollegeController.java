package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Colleges;
import com.example.demo.repository.CollegeRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //Used to map request with handler, Can be used with class and method
public class CollegeController {
	
	@Autowired //Using Bean of CollegeRepository Class So we don't ourselves need to make object 
	//CollegeRepository have @component annotation
	private CollegeRepository collegerepository;
	
	//Get Api that will get all Colleges in DB
	//https://localhost:8080/api/v1/colleges
	@GetMapping("/colleges")
	public List<Colleges> getAllColleges()
	{
		return collegerepository.findAll();
	}
	
	//ADD College API a new College inserted into the DB using Post Api
	//https://localhost:8080/api/v1/colleges
	@PostMapping("/colleges")
	public Colleges createCollege(@RequestBody Colleges college)//Post Request Contains Json Body Request so we use RequestBody annotation to map json object with College object
	{
		return collegerepository.save(college);
	}
	
	//Get College by Id
	//https://localhost:8080/api/v1/colleges/2
	@GetMapping("/colleges/{id}")
	public ResponseEntity<Colleges> getCollegeById(@PathVariable Long id)
			{
		       
		     Colleges college = collegerepository.findById(id) //return type is optional	
		    		              .orElseThrow(()-> new ResourceNotFoundException("College does not exist with id: "+id));
		     return ResponseEntity.ok(college);//ResponseEntity to return JSON Object and Status set to 200
		     }
	
	//Edit College Record in DB
	//https://localhost:8080/api/v1/college/3
	@PutMapping("/colleges/{id}")
	public ResponseEntity<Colleges> updatebyId(@PathVariable Long id, @RequestBody Colleges collegeDetails)
	{
		Colleges college = collegerepository.findById(id)
				            .orElseThrow(()-> new ResourceNotFoundException("College does not exist with id: "+id));
		college.setAddress(collegeDetails.getAddress());
		college.setName(collegeDetails.getName());
		college.setRank(collegeDetails.getRank());
		Colleges updatedCollege = collegerepository.save(college);//We can use save method to update the entry as well, return type is entity it self
		return ResponseEntity.ok(updatedCollege); //Status set to Ok
	}
	
	//Delete College Record from the DB
	//https://localhost:8080/api/v1/college/2
	@DeleteMapping("/colleges/{id}")
	public ResponseEntity<Map<String,Boolean>> deletebyId(@PathVariable Long id)
	{
		Colleges college = collegerepository.findById(id)
				              .orElseThrow(()->new ResourceNotFoundException("College does not exist with the id:"+id));
		collegerepository.delete(college);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	

}
