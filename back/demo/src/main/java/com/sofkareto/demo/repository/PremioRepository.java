package com.sofkareto.demo.repository;

import com.sofkareto.demo.entity.Premio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends CrudRepository<Premio,Integer> {

}
