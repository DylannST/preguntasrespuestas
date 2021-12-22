package com.sofkareto.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @Column(name = "idjugador")
    private int idJugador;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Juego> juegos;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Acumulado> acumulados;

    public Jugador() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(Set<Juego> juegos) {
        this.juegos = juegos;
    }

    public Set<Acumulado> getAcumulados() {
        return acumulados;
    }

    public void setAcumulados(Set<Acumulado> acumulados) {
        this.acumulados = acumulados;
    }
}
