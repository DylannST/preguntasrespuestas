package com.sofkareto.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pregunta")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpregunta")
    private int idPregunta;

    @Column
    private String descripcion;

    @OneToOne(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ronda ronda;

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Opcion> opciones;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idcategoria", unique = true, nullable = false)
    private Categoria categoria;



    public Pregunta() {
    }
}
