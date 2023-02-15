package com.IntercorpPruebaTecnica.mscliente.dto;

import java.util.Date;

public class UsuarioDTO {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String apellidos;

    private Date fechaNacimiento;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
