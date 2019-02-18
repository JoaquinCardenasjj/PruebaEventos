package com.example.eventos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.example.eventos.model.Lugar;
import com.example.eventos.repo.LugarRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LugarController {
 
	@Autowired
	LugarRepository repository;
 
	@GetMapping("/lugar")
	public List<Lugar> getAllLugar() {
		System.out.println("Get all lugar...");
 
		List<Lugar> Lugars = new ArrayList<>();
		repository.findAll().forEach(Lugars::add);
 
		return Lugars;
	}
 
	@PostMapping("/lugar/create")
	public Lugar postLugar(@RequestBody Lugar Lugar) {
 
		Lugar _Lugar= repository.save(Lugar);
		return _Lugar;
	}
 
	@DeleteMapping("/lugar/{id}")
	public ResponseEntity<String> deleteLugar(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/lugar/delete")
	public ResponseEntity<String> deleteAllLugar() {
		System.out.println("Delete All lugar...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All lugar have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("lugar/age/{age}")
	//public List<Lugar> findByAge(@PathVariable int age) {
 
		//List<Lugar> lugar = repository.findByAge(age);
		//return lugar;
	//}
 
	@PutMapping("/lugar/{id}")
	public ResponseEntity<Lugar> updateLugar(@PathVariable("id") String id, @RequestBody Lugar lugar) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<Lugar> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			
			Lugar _customer = customerData.get();
			_customer.setNombre(lugar.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}