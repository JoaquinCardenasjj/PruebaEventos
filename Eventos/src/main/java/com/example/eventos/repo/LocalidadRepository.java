package com.example.eventos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.Localidad;

public interface LocalidadRepository extends JpaRepository<Localidad, String>{
	//List<Localidad> findByAge(int age);
}
