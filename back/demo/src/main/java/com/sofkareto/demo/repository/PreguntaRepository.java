package com.sofkareto.demo.repository;

import com.sofkareto.demo.entity.Pregunta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE pregunta as p SET p.descripcion=?1 where p.idpregunta=?2", nativeQuery = true)
    void actualizar(String descripcion, int id);


    @Query(value = "SELECT * FROM pregunta as p WHERE p.idcategoria=?1", nativeQuery = true)
    List<Pregunta> obtenerPreguntasPorCategoria(int id);

    @Query(value = "SELECT p.idpregunta FROM pregunta as p WHERE p.descripcion=?1", nativeQuery = true)
     int obtenerPorNombre(String nombre);

}
