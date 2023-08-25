package com.trabajo.curso.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asistentes")
public class Asistentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String identificador;

    @ManyToOne(fetch = FetchType.EAGER)
    private Capacitacion capacitacion;

	public Asistentes() {
		super();
	}

	public Asistentes(Long id, String nombre, String apellido, String identificador, Capacitacion capacitacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
		this.capacitacion = capacitacion;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Capacitacion getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}

	@Override
	public String toString() {
		return "Asistentes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificador="
				+ identificador + ", capacitacion=" + capacitacion + "]";
	}
    
}
