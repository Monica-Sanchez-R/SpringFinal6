package com.trabajo.curso.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagosCapacitacion")
public class PagosCapacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String metodoPago;
    private Double monto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Capacitacion capacitacion;

	public PagosCapacitacion() {
		super();
	}

	public PagosCapacitacion(Long id, String metodoPago, Double monto, Capacitacion capacitacion) {
		super();
		this.id = id;
		this.metodoPago = metodoPago;
		this.monto = monto;
		this.capacitacion = capacitacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Capacitacion getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}

	@Override
	public String toString() {
		return "PagosCapacitacion [id=" + id + ", metodoPago=" + metodoPago + ", monto=" + monto + ", capacitacion="
				+ capacitacion + "]";
	}
    
    

}
