package com.example.Msapoderado.domain.mapper;

import com.example.Msapoderado.domain.dto.ApoderadoRequestDto;
import com.example.Msapoderado.domain.dto.ApoderadoResponseDto;
import com.example.Msapoderado.domain.model.Apoderado;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApoderadoMapper {

    public static Apoderado toModel(ApoderadoRequestDto dto){
        return new Apoderado(
                dto.getNombre(),
                dto.getApellidopaterno(),
                dto.getApellidomaterno(),
                dto.getDni(),
                dto.getCelular(),
                dto.getDomicilio(),
                dto.getEstado()
        );
    }

    public static Apoderado toModel(Integer id, ApoderadoRequestDto dto){
        return new Apoderado(
                id,
                dto.getNombre(),
                dto.getApellidopaterno(),
                dto.getApellidomaterno(),
                dto.getDni(),
                dto.getCelular(),
                dto.getDomicilio(),
                dto.getEstado()
        );
    }

    public static ApoderadoResponseDto toDto(Apoderado model){
        return new ApoderadoResponseDto(
                model.getId(),
                model.getNombre(),
                model.getApellidopaterno(),
                model.getApellidomaterno(),
                model.getDni(),
                model.getCelular(),
                model.getDomicilio(),
                model.getEstado()
        );
    }
}
