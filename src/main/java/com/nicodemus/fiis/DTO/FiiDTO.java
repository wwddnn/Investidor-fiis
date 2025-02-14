package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Fii;

public class FiiDTO { //esse dto retorna tanto o fii quanto seu tipo aninhado junto a ele

    private Long id;
    private String nome;
    private String descricao;

    private TipoDTO tipoDto; //pega do TipoDTO que esta aninhado

    public FiiDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public FiiDTO(Fii entity) { //construtor da entidade //passa os dados da entidade para o dto //ja consta o tipoDto que esta aninhado passando o tipo
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        tipoDto = new TipoDTO(entity.getTipo()); //copiei para o dto os dados do Tipo que esta dentro da entidade
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

    public TipoDTO getTipoDto() {
        return tipoDto;
    }
}
