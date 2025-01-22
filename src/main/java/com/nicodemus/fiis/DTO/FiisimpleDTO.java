package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Fii;

public class FiisimpleDTO { //esse dto retorna somente os dados do fii, sem aninhamento com o tipo

    private Long id;
    private String nome;
    private String descricao;

    public FiisimpleDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public FiisimpleDTO(Fii entity) { //construtor da entidade //passa os dados da entidade para o dto
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
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

}
