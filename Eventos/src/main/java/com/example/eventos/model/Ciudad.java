package com.example.eventos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "CIUDAD")
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", columnDefinition = "text", nullable = false)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Lugar> lugares;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Departamento departamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Lugar> getLugares() {
		return lugares;
	}

	public void setLugares(List<Lugar> lugares) {
		this.lugares = lugares;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	

}
