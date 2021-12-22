package com.sofkareto.demo.controller;


import com.sofkareto.demo.entity.Acumulado;
import com.sofkareto.demo.service.AcumuladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class AcumuladoController {

    @Autowired
    AcumuladoService acumuladoService;

    @PostMapping("api/acumulado")
    public Acumulado crearAcumulado(@RequestBody Acumulado acumulado) {
        return acumuladoService.crearAcumulado(acumulado);
    }

    @PutMapping("api/acumulado/{id}/{total}")
    public Acumulado actualizarAcumulado(@PathVariable("id") int id, @PathVariable("total") Long total) {
        return acumuladoService.actualizarAcumulado(id, total);
    }

    @GetMapping("api/acumulado/{id}")
    public Acumulado obtenerAcumulado(@PathVariable("id") int id) {
        return acumuladoService.obtenerAcumulado(id);
    }

    @DeleteMapping("api/acumulado/{id}")
    public boolean eliminarAcumulado(@PathVariable("id") int id) {
        return acumuladoService.eliminarAcumulado(id);
    }
}
