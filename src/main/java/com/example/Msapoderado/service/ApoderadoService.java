package com.example.Msapoderado.service;

import com.example.Msapoderado.domain.dto.ApoderadoRequestDto;
import com.example.Msapoderado.domain.dto.ApoderadoResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ApoderadoService {
    Mono<ApoderadoResponseDto> findById(Integer id);
    Flux<ApoderadoResponseDto> findAll();
    Mono<ApoderadoResponseDto> create(ApoderadoRequestDto request);
    Mono<ApoderadoResponseDto> update(ApoderadoRequestDto request, Integer id);
    Mono<Void> delete(Integer id);
}
