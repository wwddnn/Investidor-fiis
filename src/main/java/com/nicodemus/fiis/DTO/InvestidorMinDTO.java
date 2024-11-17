package com.nicodemus.fiis.DTO;

import java.io.Serializable;

public class InvestidorMinDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String email;

    public InvestidorMinDTO() {
    }

    public InvestidorMinDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public InvestidorMinDTO(InvestidorMinDTO entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
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

}
