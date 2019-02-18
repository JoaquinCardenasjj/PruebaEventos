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
import com.example.eventos.model.Departamento;
import com.example.eventos.repo.DepartamentoRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DepartamentoController {
 
	@Autowired
	DepartamentoRepository repository;
 
	@GetMapping("/departamentos")
	public List<Departamento> getAlldepartamentos() {
	System.out.println("Get all departamentos...");
 
	List<Departamento> Departamentos = new ArrayList<>();
	repository.findAll().forEach(Departamentos::add);
 
	return Departamentos;
	}
 
	@PostMapping("/departamentos/create")
	public Departamento postDepartamento (@RequestBody Departamento departamento) {
 
		Departamento _Departamento= repository.save(departamento);
		return _Departamento;
	}
 
	@DeleteMapping("/departamentos/{id}")
	public ResponseEntity<String> deleteDepartamento(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/departamentos/delete")
	public ResponseEntity<String> deleteAllDepartamentos() {
		System.out.println("Delete All departamentos...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All departamentos have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("departamentos/age/{age}")
	//public List<Departamento> findByAge(@PathVariable int age) {
 
		//List<Departamento> departamentos = repository.findByAge(age);
		//return departamentos;
	//}
 
	@PutMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> updateDepartamento(@PathVariable("id") String id, @RequestBody Departamento departamento) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<Departamento> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			Departamento _customer = customerData.get();
			_customer.setNombre(departamento.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}