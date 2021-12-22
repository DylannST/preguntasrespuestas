package com.sofkareto.demo.service;


import com.sofkareto.demo.entity.Premio;
import com.sofkareto.demo.repository.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremioService {

    @Autowired
    PremioRepository premioRepository;

    public Premio guardarPremio(Premio premio) {
        return premioRepository.save(premio);
    }

    public void eliminarPremio(int id) {
        premioRepository.deleteById(id);
    }
}
