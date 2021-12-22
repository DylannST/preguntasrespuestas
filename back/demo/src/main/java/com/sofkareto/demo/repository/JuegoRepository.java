package com.sofkareto.demo.repository;


import com.sofkareto.demo.entity.Juego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends CrudRepository<Juego,Integer> {
}
