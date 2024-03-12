package com.example.ProjectDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ProjectDemo.Service.MainService;
import com.example.ProjectDemo.entity.Country;
import com.example.ProjectDemo.entity.Employee2;

@RestController
@RequestMapping("/apicountry")

public class MainController {

	@Autowired
	MainService service;
	
	@PostMapping("/addCountry")
	public String addCountry(@RequestBody Country c) {
		
		String msg=service.addCountry(c);
		return msg;
	}
	
	
	@PutMapping("/updateData")
	public String updateData(@RequestBody Country c) {
		
		String msg=service.updateData(c);
		return msg;
	}
	
	@DeleteMapping("/deleteCountry")
	public String deleteCountry(@RequestBody Country c) {
		
		String msg=service.deleteCountry(c);
		return msg;
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee2 e) {
		
		String msg=service.addEmployee(e);
		return msg;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee2 e) {
		
		String msg=service.updateEmployee(e);
		return msg;
	}
	@GetMapping("/getparticulardata/{id}")
	public Country getParticularRecordById(@PathVariable int id) {
		
		Country c= service.getParticularRecord(id);
		return c;		
	}
	@GetMapping("/getAll")
	public List<Country> getAllRecord(){
		
		List<Country> list= service.getAllRecord();
		return list;
		
	}
	@GetMapping("/getPerticularRecord")
	public String getPerticularRecord(@RequestBody Country c) {
		
		String msg=service.getPerticularRecord(c);
		return msg;
	}
	
	
	
}
