package com.sofkareto.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ronda")
public class Ronda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idronda")
    private int idRonda;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpremio", unique = true, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Premio premio;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idjuego", unique = true, nullable = false)
    private Juego juego;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpregunta", unique = true, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pregunta pregunta;


    public Ronda() {
    }
}
