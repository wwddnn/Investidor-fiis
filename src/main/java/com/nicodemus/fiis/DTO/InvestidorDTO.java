package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Investidor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvestidorDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String corretora;

    private List<FiiDTO> fiis = new ArrayList<>();

    public InvestidorDTO() {
    }

    public InvestidorDTO(Investidor entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        corretora = entity.getCorretora();
        //essa linha traz do banco, os fiis que estao associados ao investidor
        fiis = entity.getFiis().stream().map(x -> new FiiDTO(x)).collect(Collectors.toList());
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

    public List<FiiDTO> getFiis() {
        return fiis;
    }
}
