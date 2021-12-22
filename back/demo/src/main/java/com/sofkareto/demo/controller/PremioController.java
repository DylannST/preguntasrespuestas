package com.sofkareto.demo.controller;

import com.sofkareto.demo.entity.Premio;
import com.sofkareto.demo.service.PremioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class PremioController {

    @Autowired
    PremioService premioService;

    @PostMapping("api/premio")
    public Premio guardarPremio(@RequestBody Premio premio) {
        return premioService.guardarPremio(premio);
    }

    @DeleteMapping("api/premio/{id}")
    public void eliminarPremioPoId(@PathVariable int id) {
        premioService.eliminarPremio(id);
    }
}
