package com.trabajo.curso.exception;

public class UsuarioNotFoundException extends Exception{
   
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(){
        super("El usuario no existe en la Base de datos");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}