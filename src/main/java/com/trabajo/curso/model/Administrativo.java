package com.trabajo.curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "administrativo")
public class Administrativo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String area;
	private String experienciaPrevia;

	@OneToOne(mappedBy = "administrativo")
	@JsonIgnore
	private UsuarioRol usuariorol;

	
	public Administrativo() {
		super();
	}


	public Administrativo(Long id, String area, String experienciaPrevia, UsuarioRol usuariorol) {
		super();
		this.id = id;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
		this.usuariorol = usuariorol;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}


	public UsuarioRol getUsuariorol() {
		return usuariorol;
	}


	public void setUsuariorol(UsuarioRol usuariorol) {
		this.usuariorol = usuariorol;
	}


	@Override
	public String toString() {
		return "Administrativo [id=" + id + ", area=" + area + ", experienciaPrevia=" + experienciaPrevia
				+ ", usuariorol=" + usuariorol + "]";
	}
	
}
