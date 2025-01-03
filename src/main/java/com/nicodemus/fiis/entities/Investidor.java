package com.nicodemus.fiis.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_investidor")
public class Investidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String corretora;

    @ManyToMany
    @JoinTable(name = "tb_investidor_fii",
            joinColumns = @JoinColumn(name = "investidor_id"),
            inverseJoinColumns = @JoinColumn(name = "fii_id"))
    private Set<Fii> fiis = new HashSet<>();

    public Investidor() {
    }

    public Investidor(Long id, String nome, String email, String telefone, String corretora) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.corretora = corretora;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public Set<Fii> getFiis() {
        return fiis;
    }
}
