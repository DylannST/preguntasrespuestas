package com.sofkareto.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Set<Pregunta> preguntas;

    @Column
    private String descripcion;

    @Column
    private Dificultad dificultad;

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
}
