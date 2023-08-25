package com.trabajo.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String correo;
	private String area;
	private String mensaje;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Contacto() {
		super();
	}

	public Contacto(Long id, String nombre, String correo, String area, String mensaje, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.area = area;
		this.mensaje = mensaje;
		this.cliente = cliente;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", area=" + area + ", mensaje="
				+ mensaje + ", cliente=" + cliente + "]";
	}

}