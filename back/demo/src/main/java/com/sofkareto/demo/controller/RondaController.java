package com.sofkareto.demo.controller;

import com.sofkareto.demo.entity.Ronda;
import com.sofkareto.demo.service.RondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class RondaController {

    @Autowired
    RondaService rondaService;

    @PostMapping("api/ronda")
    public Ronda guardarRondaService(@RequestBody Ronda ronda) {
        return rondaService.guardarRonda(ronda);
    }
}
