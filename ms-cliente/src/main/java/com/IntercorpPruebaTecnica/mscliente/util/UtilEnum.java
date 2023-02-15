package com.IntercorpPruebaTecnica.mscliente.util;

public class UtilEnum {
	private UtilEnum() {
		
	}
	
	public  enum ESTADO_OPERACION{
		EXITO(0,"EXITO"),
		ERROR(1,"ERROR"),
		USUARIO_CREANDO(51,"USUARIO CREANDO"),
		EXCEPTION(10,"EXCEPTION"),
		ERROR_DATOS_FORMULARIO(499,"ERROR DATOS FORMULARIO");

		private final int codigo;
		private final String texto;
		private ESTADO_OPERACION(int estado,String texto){
			this.codigo = estado;
			this.texto = texto;
		}
		public int getCodigo() {
			return codigo;
		}
		
		public String getTexto() {
			return texto;
		}
	}



}
