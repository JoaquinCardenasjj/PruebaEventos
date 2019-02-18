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


import com.example.eventos.model.TipoEvento;
import com.example.eventos.repo.TipoEventoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TipoEventoController {
 
	@Autowired
	TipoEventoRepository repository;
 
	@GetMapping("/tipoevento")
	public List<TipoEvento> getAllTipoEvento() {
		System.out.println("Get all tipoevento...");
 
		List<TipoEvento> TipoEventos = new ArrayList<>();
		repository.findAll().forEach(TipoEventos::add);
 
		return TipoEventos;
	}
 
	@PostMapping("/tipoevento/create")
	public TipoEvento postTipoEvento(@RequestBody TipoEvento TipoEvento) {
 
		TipoEvento _TipoEvento= repository.save(TipoEvento);
		return _TipoEvento;
	}
 
	@DeleteMapping("/tipoevento/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/tipoevento/delete")
	public ResponseEntity<String> deleteAllTipoEvento() {
		System.out.println("Delete All tipoevento...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All tipoevento have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("tipoevento/age/{age}")
	//public List<TipoEvento> findByAge(@PathVariable int age) {
 
		//List<TipoEvento> tipoevento = repository.findByAge(age);
		//return tipoevento;
	//}
 
	@PutMapping("/tipoevento/{id}")
	public ResponseEntity<TipoEvento> updateTipoEvento(@PathVariable("id") String id, @RequestBody TipoEvento tipoevento) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<TipoEvento> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			
			TipoEvento _customer = customerData.get();
			_customer.setNombre(tipoevento.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}