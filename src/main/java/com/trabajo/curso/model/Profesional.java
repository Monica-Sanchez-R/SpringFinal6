package com.trabajo.curso.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesional")
public class Profesional {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Date fechaIngreso;

    @OneToOne(mappedBy = "profesional")
    @JsonIgnore
    private UsuarioRol usuariorol;

    @OneToMany(mappedBy = "profesional", fetch = FetchType.LAZY)
    private Set<Visita> visita = new HashSet<Visita>();

	public Profesional() {
		super();
	}

	public Profesional(Long id, String titulo, Date fechaIngreso, UsuarioRol usuariorol, Set<Visita> visita) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
		this.usuariorol = usuariorol;
		this.visita = visita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public UsuarioRol getUsuariorol() {
		return usuariorol;
	}

	public void setUsuariorol(UsuarioRol usuariorol) {
		this.usuariorol = usuariorol;
	}

	public Set<Visita> getVisita() {
		return visita;
	}

	public void setVisita(Set<Visita> visita) {
		this.visita = visita;
	}

	@Override
	public String toString() {
		return "Profesional [id=" + id + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", usuariorol="
				+ usuariorol + ", visita=" + visita + "]";
	}

	
}
