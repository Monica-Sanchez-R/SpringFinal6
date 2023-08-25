package com.trabajo.curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	@OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore // TODO-> @JsonIgnore para que no se genere un loop infinito al momento de hacer
				// la consulta de roles
	private Set<UsuarioRol> usuariosRol = new HashSet<>();

	public Rol() {
	}
	

	public Rol(Long id, String nombre, Set<UsuarioRol> usuariosRol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuariosRol = usuariosRol;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioRol> getUsuariosRol() {
		return usuariosRol;
	}

	public void setUsuariosRol(Set<UsuarioRol> usuariosRol) {
		this.usuariosRol = usuariosRol;
	}


	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", usuariosRol=" + usuariosRol + "]";
	}


}
