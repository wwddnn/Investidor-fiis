package com.nicodemus.fiis.DTO;

import com.nicodemus.fiis.entities.Tipo;

public class TipoDTO {

    private Long id;
    private String tipo;

    public TipoDTO(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoDTO(Tipo entity) {
        id = entity.getId();
        tipo = entity.getTipo();
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
