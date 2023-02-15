package com.IntercorpPruebaTecnica.mscliente.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nombres_usuario", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos_usuario", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "edad_usuario", nullable = false)
    private int edad;

    @Column(name = "fechaNacimiento_usuario", nullable = false)
    private Date fechaNacimiento;
}
