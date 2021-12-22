package com.sofkareto.demo.entity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idopcion")
    private int idOpcion;

    @Column
    private String descripcion;

    @Column(name = "esverdadero")
    private boolean esVerdadero;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idpregunta", unique = true, nullable = false)
    private Pregunta pregunta;

    public Opcion() {
    }
}
