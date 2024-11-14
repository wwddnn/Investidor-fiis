package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Fii;
import com.nicodemus.fiis.entities.Investidor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class FiiDTO {

    //Attributes
    private Long id;
    @NotBlank(message = "Necessário um email válido")
    @Size(min = 3, max = 60, message = "Ter entre 3 e 60 caracteres")
    private String nome;
    @NotBlank(message = "Campo requerido")
    private String descricao;

    //Constructors
    public FiiDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public FiiDTO(Fii entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
    }

    //Get method
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
