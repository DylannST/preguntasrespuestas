package com.sofkareto.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "acumulado")
public class Acumulado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idacumulado")
    private int idAcumulado;

    @Column
    private Long total;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idjugador", unique = true, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Jugador jugador;

    public Acumulado() {
    }
}
