package com.sofkareto.demo.controller;


import com.sofkareto.demo.entity.Juego;
import com.sofkareto.demo.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class JuegoController {

    @Autowired
    JuegoService juegoService;

    @PostMapping("api/juego")
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoService.crearJuego(juego);
    }

    @GetMapping("api/juego/{id}")
    public Juego obtenerJuego(@PathVariable("id") int id) {
        return juegoService.obtenerJuego(id);
    }
}
