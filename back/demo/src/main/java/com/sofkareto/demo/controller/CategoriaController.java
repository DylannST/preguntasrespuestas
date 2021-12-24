package com.sofkareto.demo.controller;

import com.sofkareto.demo.entity.Categoria;
import com.sofkareto.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.DELETE})
@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;



    @PostMapping("api/categoria")
    public List<Categoria> agregarCategoria(@RequestBody List<Categoria> categoria) {
        List<Categoria> cate = new ArrayList<>();
        categoria.forEach(val -> {
            cate.add(categoriaService.agregarCategoria(val));
        });
        return cate;
    }

    @PutMapping("api/categoria/{id}")
    public void actualizarCategoria(@RequestBody Categoria categoria) {
        categoriaService.editarDificultad(categoria);

    }

    @DeleteMapping("api/categoria/{id}")
    public void eliminarCategoria(@PathVariable("id") int id) {
        categoriaService.eliminarCategoria(id);
    }

    @GetMapping("api/dificultad")
    public List<String> obtenerDificultad() {
        return categoriaService.obtenerDificultad();

    }
}
