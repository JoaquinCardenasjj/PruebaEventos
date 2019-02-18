package com.example.eventos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventos.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, String>{
	//List<Departamento> findByAge(int age);
}
