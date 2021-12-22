package com.sofkareto.demo.repository;

import com.sofkareto.demo.entity.Ronda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RondaRepository extends CrudRepository<Ronda, Integer> {
}
