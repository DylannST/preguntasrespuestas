package com.sofkareto.demo.service;


import com.sofkareto.demo.entity.Acumulado;
import com.sofkareto.demo.repository.AcumuladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcumuladoService {

    @Autowired
    AcumuladoRepository acumuladoRepository;

    public Acumulado crearAcumulado(Acumulado acumulado) {
        return acumuladoRepository.save(acumulado);
    }

    public Acumulado actualizarAcumulado(int id, Long total) {
        return acumuladoRepository.actualizarAcumulado(id, total);
    }

    public Acumulado obtenerAcumulado(int id) {
        return acumuladoRepository.findById(id).orElseThrow();
    }

    public boolean eliminarAcumulado(int id) {
        try {
            acumuladoRepository.deleteById(id);
            return true;
        } catch (Error e) {
            return false;
        }
    }
}
