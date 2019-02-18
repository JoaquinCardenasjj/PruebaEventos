package com.example.eventos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.TipoEvento;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, String>{
	//List<TipoEvento> findByAge(int age);
}
