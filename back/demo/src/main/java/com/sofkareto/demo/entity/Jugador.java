package com.sofkareto.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "acumulado")
public class Jugador {
    @Id
    @Column(name = "idjugador", length = 10)
    private String idJugador;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Juego> juegos;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Acumulado> acumulados;

    public Jugador() {
    }
}
