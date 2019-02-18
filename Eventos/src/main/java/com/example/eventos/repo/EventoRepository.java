package com.example.eventos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, String>{
	//List<Evento> findByAge(int age);
	
	//public Boolean Create (Evento evento);
}
