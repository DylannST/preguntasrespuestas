package com.sofkareto.demo.repository;


import com.sofkareto.demo.entity.Acumulado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AcumuladoRepository extends CrudRepository<Acumulado, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update acumulado as a SET a.total=?2 WHERE a.idacumulado=?1", nativeQuery = true)
    Acumulado actualizarAcumulado(int id, Long total);
}
