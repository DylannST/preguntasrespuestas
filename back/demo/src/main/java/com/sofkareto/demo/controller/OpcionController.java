package com.sofkareto.demo.controller;

import com.sofkareto.demo.entity.Opcion;
import com.sofkareto.demo.service.OpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class OpcionController {
    @Autowired
    OpcionService opcionService;

    @PostMapping("api/opcion")
    public void guardarOpcion(@RequestBody List<Opcion> opciones) {
        opcionService.guardarOpciones(opciones);
    }

    @DeleteMapping("api/opcion/{id}")
    public boolean eliminarOpcion(@PathVariable("id") int id) {
        return opcionService.eliminarOpcion(id);
    }

    @GetMapping("api/opcion/{id}")
    public List<Opcion> obtenerOpcionesPorPregunta(@PathVariable("id") int id) {
        return opcionService.obtenerOpcionPorPregunta(id);
    }

    @DeleteMapping("api/opcion/pregunta/{id}")
    public void nombreMetodo(@PathVariable("id") int id) {
        opcionService.eliminarOpcionPorPregunta(id);
    }
}
