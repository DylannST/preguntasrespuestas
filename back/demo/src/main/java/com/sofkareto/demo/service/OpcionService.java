package com.sofkareto.demo.service;


import com.sofkareto.demo.entity.Opcion;
import com.sofkareto.demo.repository.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionService {

    @Autowired
    OpcionRepository opcionRepository;

    public void guardarOpciones(List<Opcion> opciones) {
        opciones.forEach(opcion -> {
            opcionRepository.save(opcion);
        });
    }

    public boolean eliminarOpcion(int id) {
        try {
            opcionRepository.deleteById(id);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public List<Opcion> obtenerOpcionPorPregunta(int id) {
        return opcionRepository.obtenerOpcionesPorPregunta(id);
    }


    public void eliminarOpcionPorPregunta(int id) {
        opcionRepository.eliminarOpcionPorPregunta(id);
    }
}
