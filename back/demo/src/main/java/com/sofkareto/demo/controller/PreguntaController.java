package com.sofkareto.demo.controller;


import com.sofkareto.demo.entity.Pregunta;
import com.sofkareto.demo.service.PreguntaService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @PostMapping("api/pregunta")
    public List<Pregunta> guardarPregunta(@RequestBody List<Pregunta> preguntas) {
        return preguntaService.guardarPregunta(preguntas);
    }

    @DeleteMapping("api/pregunta/{id}")
    public void eliminarPregunta(@PathVariable("id") int id) {
        preguntaService.eliminarPregunta(id);
    }

    @PutMapping("api/pregunta")
    public boolean actualizarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.editarPregunta(pregunta);
    }

    @GetMapping("api/pregunta/{id}")
    public Pregunta obtenerPregunta(@PathVariable("id") int id) {
        return preguntaService.obtenerPregunta(id);
    }

    @GetMapping("api/pregunta/categoria/{id}")
    public List<Pregunta> obtenerPreguntasPorCategoria(@PathVariable("id") int id) {
        return preguntaService.obtenerPreguntasPorCategoria(id);
    }

    @GetMapping("api/pregunta/{descripcion}")
    public int obtenerPorPregunta(@PathVariable("descripcion") String descripcion) {
        return preguntaService.obtenerPorPregunta(descripcion);
    }


    @GetMapping("api/pregunta/form")
    public List<Object> obtenerPreguntaForm() {
        return preguntaService.obtenerPreguntaForm();
    }

    @GetMapping("api/pregunta/dificultad")
    public List<Object> obtenerPreguntaDificultad(){
        return preguntaService.obtenerPreguntasDificultad();
    }


}
