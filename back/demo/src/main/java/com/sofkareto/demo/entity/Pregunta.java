package com.sofkareto.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Set<Opcion> opciones;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idcategoria")
    @JsonBackReference
    private Categoria categoria;


    public Pregunta() {
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Set<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<Opcion> opciones) {
        this.opciones = opciones;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
