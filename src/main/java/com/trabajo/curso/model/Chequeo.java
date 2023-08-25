package com.trabajo.curso.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chequeo")
public class Chequeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dia;
    private String hora;
    private String lugar;
    private String descripcion;
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    private Profesional profesional;
    
    
	public Chequeo() {
		super();
	}

	public Chequeo(Long id, String dia, String hora, String lugar, String descripcion, String estado, Cliente cliente,
			Profesional profesional) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.estado = estado;
		this.cliente = cliente;
		this.profesional = profesional;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "Chequeo [id=" + id + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", descripcion="
				+ descripcion + ", estado=" + estado + ", cliente=" + cliente + ", profesional=" + profesional + "]";
	}

    
    
}

