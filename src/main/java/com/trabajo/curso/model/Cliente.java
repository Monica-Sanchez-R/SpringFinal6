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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;

    @OneToOne(mappedBy = "cliente")
    @JsonIgnore
    private UsuarioRol usuariorol;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Visita> visita = new HashSet<Visita>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Capacitacion> capacitaciones = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Accidente> accidentes = new HashSet<>();

    
    
    
	public Cliente() {
		super();
	}

	public Cliente(Long id, String nombres, String telefono, String afp, int sistemaSalud, String direccion,
			UsuarioRol usuariorol, Set<Visita> visita, Set<Capacitacion> capacitaciones, Set<Accidente> accidentes) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.usuariorol = usuariorol;
		this.visita = visita;
		this.capacitaciones = capacitaciones;
		this.accidentes = accidentes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Set<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(Set<Capacitacion> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	public Set<Accidente> getAccidentes() {
		return accidentes;
	}

	public void setAccidentes(Set<Accidente> accidentes) {
		this.accidentes = accidentes;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombres=" + nombres + ", telefono=" + telefono + ", afp=" + afp
				+ ", sistemaSalud=" + sistemaSalud + ", direccion=" + direccion + ", usuariorol=" + usuariorol
				+ ", visita=" + visita + ", capacitaciones=" + capacitaciones + ", accidentes=" + accidentes + "]";
	}
   

    

}
