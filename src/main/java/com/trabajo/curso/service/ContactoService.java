package com.trabajo.curso.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.trabajo.curso.model.Contacto;



public interface ContactoService {

	public List<Contacto> getContacts();

	public Contacto newContact(Contacto contacto);

	public ResponseEntity<Object> updateContact(Contacto contacto);

	public ResponseEntity<Object> deleteContact(int id);

	public ResponseEntity<Object> getContact(int id);
}
