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


import com.example.eventos.model.Evento;
import com.example.eventos.repo.EventoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EventoController {
 
	@Autowired
	EventoRepository repository;
 
	@GetMapping("/eventos")
	public List<Evento> getAllEventos() {
		System.out.println("Get all eventos...");
 
		List<Evento> eventos = new ArrayList<>();
		repository.findAll().forEach(eventos::add);
 
		return eventos;
	}
 
	@PostMapping("/eventos/create")
	public Evento postEvento(@RequestBody Evento evento) {
 
		Evento _evento= repository.save(evento);
		return _evento;
	}
 
	@DeleteMapping("/eventos/{id}")
	public ResponseEntity<String> deleteEvento(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/eventos/delete")
	public ResponseEntity<String> deleteAllEvento() {
		System.out.println("Delete All eventos...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All eventos have been deleted!", HttpStatus.OK);
	}
 
	//@GetMapping("eventos/age/{age}")
	//public List<Evento> findByAge(@PathVariable int age) {
 
		//List<Evento> eventos = repository.findByAge(age);
		//return eventos;
	//}
 
	@PutMapping("/eventos/{id}")
	public ResponseEntity<Evento> updateEvento(@PathVariable("id") String id, @RequestBody Evento evento) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<Evento> customerData = repository.findById(id);
 
		if (customerData.isPresent()) {
			Evento _customer = customerData.get();
			_customer.setNombre(evento.getNombre());
		
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}