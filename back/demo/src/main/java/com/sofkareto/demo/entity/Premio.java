package com.sofkareto.demo.entity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpremio")
    private int idPremio;

    @Column
    private int puntos;

    @OneToOne(mappedBy = "premio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ronda ronda;

    public Premio() {
    }
}
