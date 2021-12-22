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
    @JoinColumn(name = "idjugador")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Jugador jugador;

    public Acumulado() {
    }

    public int getIdAcumulado() {
        return idAcumulado;
    }

    public void setIdAcumulado(int idAcumulado) {
        this.idAcumulado = idAcumulado;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
