package com.example.Msapoderado.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Apoderado {
    @Id
    private Integer id;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String dni;
    private String celular;
    private String domicilio;
    private String estado;

    public Apoderado(String nombre, String apellidopaterno, String apellidomaterno, String dni, String celular, String domicilio, String estado) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.dni = dni;
        this.celular = celular;
        this.domicilio = domicilio;
        this.estado = estado;
    }

    public Apoderado(Integer id, String nombre, String apellidopaterno, String apellidomaterno, String dni, String celular, String domicilio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.dni = dni;
        this.celular = celular;
        this.domicilio = domicilio;
        this.estado = estado;
    }
}
