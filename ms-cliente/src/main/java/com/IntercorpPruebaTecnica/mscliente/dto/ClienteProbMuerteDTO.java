package com.IntercorpPruebaTecnica.mscliente.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class ClienteProbMuerteDTO {



    private static final long serialVersionUID = 1L;


    private String nombre;


    private String apellidos;


    private int edad;

    private Date FechaProbMuerte;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaProbMuerte() {
        return FechaProbMuerte;
    }

    public void setFechaProbMuerte(Date fechaProbMuerte) {
        FechaProbMuerte = fechaProbMuerte;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private Date fechaNacimiento;
}
