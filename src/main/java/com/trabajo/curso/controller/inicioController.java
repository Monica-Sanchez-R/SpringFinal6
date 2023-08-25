package com.trabajo.curso.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class inicioController {

	@GetMapping("/")
	 public String verPaginaDeInicio() {
		 return "index";
	 }
}
