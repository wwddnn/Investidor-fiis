package com.nicodemus.fiis.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "tipo")
    private Set<Fii> fii = new HashSet<>();

    public Tipo() {
    }

    public Tipo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String tipo) {
        this.nome = tipo;
    }

    public Set<Fii> getFii() {
        return fii;
    }

}
