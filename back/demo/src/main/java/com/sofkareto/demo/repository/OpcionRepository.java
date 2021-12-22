package com.sofkareto.demo.repository;

import com.sofkareto.demo.entity.Opcion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Integer> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM opcion as op WHERE op.idpregunta=?1", nativeQuery = true)
    List<Opcion> obtenerOpcionesPorPregunta(int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM opcion WHERE idpregunta=?1", nativeQuery = true)
    void eliminarOpcionPorPregunta(int id);


}
