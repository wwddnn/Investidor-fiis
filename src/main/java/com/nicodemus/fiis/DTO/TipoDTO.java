package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Tipo;

public class TipoDTO{

    private Long id;
    private String nome;

    public TipoDTO(Long id, String tipo) {
        this.id = id;
        this.nome = tipo;
    }

    public TipoDTO(Tipo entity) { //construtor da entidade //passa os dados da entidade para o dto
        id = entity.getId();
        nome = entity.getNome();
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
}
