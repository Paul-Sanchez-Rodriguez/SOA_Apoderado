package com.example.Msapoderado.web;

import com.example.Msapoderado.domain.dto.ApoderadoRequestDto;
import com.example.Msapoderado.domain.dto.ApoderadoResponseDto;
import com.example.Msapoderado.service.ApoderadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/apoderado")
@RequiredArgsConstructor
public class ApoderadoController {
    private final ApoderadoService apoderadoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<ApoderadoResponseDto> findAll(){
        return this.apoderadoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ApoderadoResponseDto> findById(@PathVariable Integer id){
        return this.apoderadoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ApoderadoResponseDto> create(@RequestBody ApoderadoRequestDto dto){
        return this.apoderadoService.create(dto);
    }
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ApoderadoResponseDto> update(@RequestBody ApoderadoRequestDto dto, @PathVariable Integer id){
        return this.apoderadoService.update(dto,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return this.apoderadoService.delete(id);
    }

}
