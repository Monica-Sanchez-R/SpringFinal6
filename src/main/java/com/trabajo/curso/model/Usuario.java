package com.trabajo.curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabajo.curso.security.jwt.Authority;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	@Column(unique = true)
	public String run;

	private String password;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String email;
	private Date fechanacimiento;
	private String perfil;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> autoridades = new HashSet<>();
		this.usuarioRoles.forEach(usuarioRol -> {
			autoridades.add(new Authority(usuarioRol.getRol().getNombre()));
		});
		return autoridades;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Usuario() {
		super();
	}

	public Usuario(Long id, String username, String run, String password, String nombre, String apellido, String email,
			Date fechanacimiento, String perfil, Set<UsuarioRol> usuarioRoles) {
		super();
		this.id = id;
		this.username = username;
		this.run = run;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechanacimiento = fechanacimiento;
		this.perfil = perfil;
		this.usuarioRoles = usuarioRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", run=" + run + ", password=" + password + ", nombre="
				+ nombre + ", apellido=" + apellido + ", email=" + email + ", fechanacimiento=" + fechanacimiento
				+ ", perfil=" + perfil + ", usuarioRoles=" + usuarioRoles + "]";
	}	
	
}
