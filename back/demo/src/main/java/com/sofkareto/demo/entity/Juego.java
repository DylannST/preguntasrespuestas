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
    @JoinColumn(name="idjugador")
    private Jugador jugador;


    public Juego() {
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public Set<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(Set<Ronda> rondas) {
        this.rondas = rondas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
