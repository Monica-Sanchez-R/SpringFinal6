package com.trabajo.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asesoria")
public class Asesoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private String descripcion;
	private String estado;

	@ManyToOne(fetch = FetchType.EAGER)
	private Profesional profesional;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Asesoria() {
		super();
	}

	public Asesoria(Long id, String dia, String hora, String lugar, String duracion, String descripcion, String estado,
			Profesional profesional, Cliente cliente) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.estado = estado;
		this.profesional = profesional;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Asesoria [id=" + id + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", Profesional=" + profesional + ", Cliente="
				+ cliente + "]";
	}

}