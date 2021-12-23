package com.sofkareto.demo.service;

import com.sofkareto.demo.entity.Categoria;
import com.sofkareto.demo.enums.Dificultad;
import com.sofkareto.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean eliminarCategoria(int id) {
        try {
            categoriaRepository.deleteById(id);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void editarDificultad(Categoria categoria) {
        categoriaRepository.actualizarDificultad(categoria.getDificultad().toString(), categoria.getIdCategoria());
    }

    public List<String> obtenerDificultad() {
        List<String> dificultades = new ArrayList<>();
        Arrays.asList(Dificultad.values()).forEach(obj -> {
            dificultades.add(obj.toString());
        });
        return dificultades;
    }


}
