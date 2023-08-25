package com.trabajo.curso.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "visita")
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer rut;
	private Date fechaAccidente;
	private Date hora;
	private String lugar;
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Profesional profesional;

	@OneToMany(mappedBy = "visita", fetch = FetchType.LAZY)
	private Set<ChekList> detalleVisita = new HashSet<ChekList>();

	public Visita() {
		super();
	}

	public Visita(Long id, Integer rut, Date fechaAccidente, Date hora, String lugar, String comentario,
			Cliente cliente, Profesional profesional, Set<ChekList> detalleVisita) {
		super();
		this.id = id;
		this.rut = rut;
		this.fechaAccidente = fechaAccidente;
		this.hora = hora;
		this.lugar = lugar;
		this.comentario = comentario;
		this.cliente = cliente;
		this.profesional = profesional;
		this.detalleVisita = detalleVisita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public Date getFechaAccidente() {
		return fechaAccidente;
	}

	public void setFechaAccidente(Date fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public Set<ChekList> getDetalleVisita() {
		return detalleVisita;
	}

	public void setDetalleVisita(Set<ChekList> detalleVisita) {
		this.detalleVisita = detalleVisita;
	}

	@Override
	public String toString() {
		return "Visita [id=" + id + ", rut=" + rut + ", fechaAccidente=" + fechaAccidente + ", hora=" + hora
				+ ", lugar=" + lugar + ", comentario=" + comentario + ", cliente=" + cliente + ", profesional="
				+ profesional + ", detalleVisita=" + detalleVisita + "]";
	}

}
