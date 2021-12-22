package com.sofkareto.demo.service;


import com.sofkareto.demo.entity.Juego;
import com.sofkareto.demo.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuegoService {
    @Autowired
    JuegoRepository juegoRepository;

    public Juego crearJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    public Juego obtenerJuego(int id){
        return juegoRepository.findById(id).orElseThrow();
    }
}
