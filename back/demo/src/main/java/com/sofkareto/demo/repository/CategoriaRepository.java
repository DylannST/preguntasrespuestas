package com.sofkareto.demo.repository;

import com.sofkareto.demo.entity.Categoria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update categoria as c SET c.dificultad=?1 WHERE c.idcategoria=?2", nativeQuery = true)
    void actualizarDificultad(String dificultad, int id);
}
