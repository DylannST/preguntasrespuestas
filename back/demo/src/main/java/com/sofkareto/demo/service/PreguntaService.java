package com.sofkareto.demo.service;

import com.sofkareto.demo.entity.Pregunta;
import com.sofkareto.demo.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository preguntaRepository;

    public void guardarPregunta(List<Pregunta> preguntas) {
        preguntas.forEach(pregunta -> {
            preguntaRepository.save(pregunta);
        });
    }

    public boolean editarPregunta(Pregunta pregunta) {
        try {
            preguntaRepository.actualizar(pregunta.getDescripcion(), pregunta.getIdPregunta());
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void eliminarPregunta(int id) {
        preguntaRepository.deleteById(id);
    }

    public Pregunta obtenerPregunta(int id) {
        return preguntaRepository.findById(id).orElseThrow();
    }

    public List<Pregunta> obtenerPreguntasPorCategoria(int id) {
        return preguntaRepository.obtenerPreguntasPorCategoria(id);
    }
}
