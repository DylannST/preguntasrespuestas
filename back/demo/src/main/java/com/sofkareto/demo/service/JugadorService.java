package com.sofkareto.demo.service;

import com.sofkareto.demo.entity.Jugador;
import com.sofkareto.demo.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class JugadorService {
    @Autowired
    JugadorRepository jugadorRepository;

    public Jugador registrarJugador(Jugador jugador) {

        return jugadorRepository.save(jugador);
    }

    public Jugador obtener(int id){
        return jugadorRepository.findById(id).get();
    }
}
