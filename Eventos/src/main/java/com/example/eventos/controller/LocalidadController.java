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


import com.example.eventos.model.Localidad;
import com.example.eventos.repo.LocalidadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LocalidadController {
 
	@Autowired
	LocalidadRepository repository;
 
	@GetMapping("/localidad")
	public List<Localidad> getAllLocalidad() {
		System.out.println("Get all localidad...");
 
		List<Localidad> Localidads = new ArrayList<>();
		repository.findAll().forEach(Localidads::add);
 
		return Localidads;
	}
 
	@PostMapping("/localidad/create")
	public Localidad postLocalidad(@RequestBody Localidad Localidad) {
 
		Localidad _Localidad= repository.save(Localidad);
		return _Localidad;
	}
 
	@DeleteMapping("/localidad/{id}")
	public ResponseEntity<String> deleteLocalidad(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/localidad/delete")
	public ResponseEntity<String> deleteAllLocalidad() {
		System.out.println("Delete All localidad...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All localidad have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("localidad/age/{age}")
	//public List<Localidad> findByAge(@PathVariable int age) {
 
		//List<Localidad> localidad = repository.findByAge(age);
		//return localidad;
	//}
 
	@PutMapping("/localidad/{id}")
	public ResponseEntity<Localidad> updateLocalidad(@PathVariable("id") String id, @RequestBody Localidad localidad) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<Localidad> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			Localidad _customer = customerData.get();
			_customer.setNombre(localidad.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}