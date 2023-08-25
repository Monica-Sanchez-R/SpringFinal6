package com.trabajo.curso.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cheklist")
public class ChekList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String Detalle;
    private String estado; 
    //(1 = Sin Problemas /2 = enObservaciones /3 No Apruebo)

    @ManyToOne(fetch = FetchType.LAZY)
    private Visita visita;

	public ChekList() {
		super();
	}

	public ChekList(Long id, String nombre, String detalle, String estado, Visita visita) {
		super();
		this.id = id;
		this.nombre = nombre;
		Detalle = detalle;
		this.estado = estado;
		this.visita = visita;
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

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	@Override
	public String toString() {
		return "ChekList [id=" + id + ", nombre=" + nombre + ", Detalle=" + Detalle + ", estado=" + estado + ", visita="
				+ visita + "]";
	}

}
