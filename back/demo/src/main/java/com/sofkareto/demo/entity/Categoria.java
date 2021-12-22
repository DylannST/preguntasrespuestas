package com.sofkareto.demo.entity;

import com.sofkareto.demo.enums.Dificultad;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcategoria")
    private int idCategoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Pregunta> preguntas;

    @Column
    private String descripcion;

    @Column
    private Dificultad dificultad;

    public Categoria() {
    }
}
