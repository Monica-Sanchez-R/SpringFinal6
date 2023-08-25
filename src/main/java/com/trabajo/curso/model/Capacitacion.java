package com.trabajo.curso.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "capacitacion")
public class Capacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    private Double valorAPagar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(mappedBy = "capacitacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<PagosCapacitacion> pagosCapacitacion = new HashSet<>();

    @OneToMany(mappedBy = "capacitacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Asistentes> asistentes = new HashSet<>();

    
    
	public Capacitacion() {
		super();
	}


	public Capacitacion(Long id, String dia, String hora, String lugar, String duracion, int cantidadAsistentes,
			Double valorAPagar, Cliente cliente, Set<PagosCapacitacion> pagosCapacitacion, Set<Asistentes> asistentes) {
		super();
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
		this.valorAPagar = valorAPagar;
		this.cliente = cliente;
		this.pagosCapacitacion = pagosCapacitacion;
		this.asistentes = asistentes;
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


	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}


	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}


	public Double getValorAPagar() {
		return valorAPagar;
	}


	public void setValorAPagar(Double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Set<PagosCapacitacion> getPagosCapacitacion() {
		return pagosCapacitacion;
	}


	public void setPagosCapacitacion(Set<PagosCapacitacion> pagosCapacitacion) {
		this.pagosCapacitacion = pagosCapacitacion;
	}


	public Set<Asistentes> getAsistentes() {
		return asistentes;
	}


	public void setAsistentes(Set<Asistentes> asistentes) {
		this.asistentes = asistentes;
	}


	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", duracion="
				+ duracion + ", cantidadAsistentes=" + cantidadAsistentes + ", valorAPagar=" + valorAPagar
				+ ", cliente=" + cliente + ", pagosCapacitacion=" + pagosCapacitacion + ", asistentes=" + asistentes
				+ "]";
	}

    
}

