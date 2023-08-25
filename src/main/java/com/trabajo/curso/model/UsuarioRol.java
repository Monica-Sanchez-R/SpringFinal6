package com.trabajo.curso.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarioRol")
public class UsuarioRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioRolId;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	private Rol rol;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalleAdministrativoId", referencedColumnName = "id")
	private Administrativo administrativo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalleClienteId", referencedColumnName = "id")
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalleProfesionalId", referencedColumnName = "id")
	private Profesional profesional;

	public UsuarioRol() {
		super();
	}

	public UsuarioRol(Long usuarioRolId, Usuario usuario, Rol rol, Administrativo administrativo, Cliente cliente,
			Profesional profesional) {
		super();
		this.usuarioRolId = usuarioRolId;
		this.usuario = usuario;
		this.rol = rol;
		this.administrativo = administrativo;
		this.cliente = cliente;
		this.profesional = profesional;
	}

	public Long getUsuarioRolId() {
		return usuarioRolId;
	}

	public void setUsuarioRolId(Long usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
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
		return "UsuarioRol [usuarioRolId=" + usuarioRolId + ", usuario=" + usuario + ", rol=" + rol
				+ ", administrativo=" + administrativo + ", cliente=" + cliente + ", profesional=" + profesional + "]";
	}

}