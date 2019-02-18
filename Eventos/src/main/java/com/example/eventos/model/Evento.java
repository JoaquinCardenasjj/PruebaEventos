package com.example.eventos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity 
@Table(name = "EVENTO")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NOMBRE", columnDefinition = "text", nullable = false)
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TIPO_ID")
	private TipoEvento tipoEvento;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Localidad> localidades;
	private Date fecha;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Lugar> lugares;
	

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

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento TipoEvento) {
		this.tipoEvento = TipoEvento;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public List<Lugar> getLugares() {
		return lugares;
	}

	public void setLugares(List<Lugar> lugares) {
		this.lugares = lugares;
	}
	

}
