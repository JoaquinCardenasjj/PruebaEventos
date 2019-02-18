package com.example.eventos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, String>{
	//List<Lugar> findByAge(int age);
}
