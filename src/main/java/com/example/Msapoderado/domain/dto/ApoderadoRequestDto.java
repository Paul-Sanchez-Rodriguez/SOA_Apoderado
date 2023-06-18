package com.example.Msapoderado.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApoderadoRequestDto implements Serializable {

    private static final long serialVersionUID = 8222253670338491507L;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String dni;
    private String celular;
    private String domicilio;
    private String estado;
}
