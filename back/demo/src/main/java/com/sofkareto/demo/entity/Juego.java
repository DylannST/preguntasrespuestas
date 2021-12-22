package com.sofkareto.demo.entity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "juego")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idjuego")
    private int idJuego;


    @OneToMany(mappedBy = "juego", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Ronda> rondas;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="idjugador", unique = true, nullable = false)
    private Jugador jugador;


    public Juego() {
    }

    public Juego(int idJuego, Set<Ronda> rondas, Jugador jugador) {
        this.idJuego = idJuego;
        this.rondas = rondas;
        this.jugador = jugador;
    }
}
