package com.sofkareto.demo.service;


import com.sofkareto.demo.entity.Ronda;
import com.sofkareto.demo.repository.RondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RondaService {

    @Autowired
    RondaRepository rondaRepository;

    public Ronda guardarRonda(Ronda ronda) {
        return rondaRepository.save(ronda);
    }
}
