package com.example.Msapoderado.repository;

import com.example.Msapoderado.domain.model.Apoderado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoderadoRepository extends ReactiveCrudRepository<Apoderado,Integer> {
}
