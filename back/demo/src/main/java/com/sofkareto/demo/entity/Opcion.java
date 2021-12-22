package com.sofkareto.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "idpregunta")
    @JsonBackReference
    private Pregunta pregunta;

    public Opcion() {
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsVerdadero() {
        return esVerdadero;
    }

    public void setEsVerdadero(boolean esVerdadero) {
        this.esVerdadero = esVerdadero;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
