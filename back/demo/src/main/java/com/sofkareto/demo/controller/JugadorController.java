package com.sofkareto.demo.controller;

import com.sofkareto.demo.entity.Jugador;
import com.sofkareto.demo.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class JugadorController {
    @Autowired
    JugadorService jugadorService;


    @PostMapping("api/jugador")
    public Jugador agregarJugador(@RequestBody Jugador jugador) {
        return jugadorService.registrarJugador(jugador);

    }

    @GetMapping("api/jugador/{id}")
    public Jugador obtener(@PathVariable("id") int id) {
        return jugadorService.obtener(id);
    }
}
