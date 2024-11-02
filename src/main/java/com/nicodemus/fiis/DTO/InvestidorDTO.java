package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Investidor;

public class InvestidorDTO {

    //Attributes
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String corretora;

    //Constructors
    public InvestidorDTO() {
    }

    public InvestidorDTO(Long id, String nome, String email, String telefone, String corretora) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.corretora = corretora;
    }

    //Entity Constructor
    public InvestidorDTO(Investidor entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        corretora = entity.getCorretora();
    }

    //Get and Set method
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
}
