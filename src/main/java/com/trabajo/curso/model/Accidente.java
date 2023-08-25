package com.trabajo.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accidente")
public class Accidente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dia;
    private String hora;
    private String lugar;
    private String descripcion;
    private String estado;
    private String tipo;
    private String gravedad;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

	public Accidente() {
		super();
	}

	public Accidente(Long id, String dia, String hora, String lugar, String descripcion, String estado, String tipo,
			String gravedad, Cliente cliente) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
		this.gravedad = gravedad;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Accidente [id=" + id + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", descripcion="
				+ descripcion + ", estado=" + estado + ", tipo=" + tipo + ", gravedad=" + gravedad + ", cliente="
				+ cliente + "]";
	}
    
}
