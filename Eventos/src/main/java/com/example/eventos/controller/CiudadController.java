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
import com.example.eventos.model.Ciudad;
import com.example.eventos.repo.CiudadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CiudadController {
 
	@Autowired
	CiudadRepository repository;
 
	@GetMapping("/ciudades")
	public List<Ciudad> getAllciudades() {
		System.out.println("Get all ciudades...");
 
		List<Ciudad> Ciudads = new ArrayList<>();
		repository.findAll().forEach(Ciudads::add);
 
		return Ciudads;
	}
 
	@PostMapping("/ciudades/create")
	public Ciudad postCustomer(@RequestBody Ciudad Ciudad) {
 
		Ciudad _Ciudad= repository.save(Ciudad);
		return _Ciudad;
	}
 
	@DeleteMapping("/ciudades/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/ciudades/delete")
	public ResponseEntity<String> deleteAllciudades() {
		System.out.println("Delete All ciudades...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All ciudades have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("ciudades/age/{age}")
	//public List<Ciudad> findByAge(@PathVariable int age) {
 
		//List<Ciudad> ciudades = repository.findByAge(age);
		//return ciudades;
	//}
 
	@PutMapping("/ciudades/{id}")
	public ResponseEntity<Ciudad> updateCustomer(@PathVariable("id") String id, @RequestBody Ciudad ciudad) {
		System.out.println("Update Customer with ID = " + id + "...");
		 
		Optional<Ciudad> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			Ciudad _customer = customerData.get();
			_customer.setNombre(ciudad.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}