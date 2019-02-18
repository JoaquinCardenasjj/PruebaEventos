package com.example.eventos.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, String>{
	//List<Ciudad> findByAge(int age);
}
