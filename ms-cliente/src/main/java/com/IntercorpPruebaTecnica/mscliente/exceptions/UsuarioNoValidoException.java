package com.IntercorpPruebaTecnica.mscliente.exceptions;


public class UsuarioNoValidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public UsuarioNoValidoException(String s){  
		  super(s);  
	}  

	public UsuarioNoValidoException(String s, Throwable cause){
		  super(s, cause);  
	} 
}
