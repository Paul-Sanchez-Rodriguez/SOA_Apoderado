package com.example.Msapoderado.service.impl;

import com.example.Msapoderado.domain.dto.ApoderadoRequestDto;
import com.example.Msapoderado.domain.dto.ApoderadoResponseDto;
import com.example.Msapoderado.domain.mapper.ApoderadoMapper;
import com.example.Msapoderado.exception.ResourceNotFoundException;
import com.example.Msapoderado.repository.ApoderadoRepository;
import com.example.Msapoderado.service.ApoderadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.Msapoderado.domain.mapper.ApoderadoMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApoderadoServiceImpl implements ApoderadoService {

    private  final ApoderadoRepository apoderadoRepository;
    @Override
    public Mono<ApoderadoResponseDto> findById(Integer id) {
        return this.apoderadoRepository.findById(id)
                .map(ApoderadoMapper::toDto);
    }

    @Override
    public Flux<ApoderadoResponseDto> findAll() {
        return this.apoderadoRepository.findAll()
                .filter(apoderado -> apoderado.getEstado().equals("A"))
                .map(ApoderadoMapper::toDto);
    }

    @Override
    public Mono<ApoderadoResponseDto> create(ApoderadoRequestDto request) {
        return this.apoderadoRepository.save(toModel(request))
                .map(ApoderadoMapper::toDto);
    }

    @Override
    public Mono<ApoderadoResponseDto> update(ApoderadoRequestDto request, Integer id) {
        return this.apoderadoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(apoderado -> this.apoderadoRepository.save(toModel(apoderado.getId(),request)))
                .map(ApoderadoMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.apoderadoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(apoderado -> {
                    apoderado.setEstado("I");
                    return this.apoderadoRepository.save(apoderado);
                })
                .doOnSuccess(unused -> log.info("Se elimino el siguiente ID " +id))
                .then();
    }
}
