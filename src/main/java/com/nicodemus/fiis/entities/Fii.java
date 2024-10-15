package com.nicodemus.fiis.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_fii")
public class Fii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "fiis")
    private List<Investidor> investidores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    public Fii() {
    }

    public Fii(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Investidor> getInvestidores() {
        return investidores;
    }

}
