package com.nicodemus.fiis.DTO;

public class InvestidorCorretoraDTO {

    private String corretora;
    private Long count;

    public InvestidorCorretoraDTO(String corretora, Long count) {
        this.corretora = corretora;
        this.count = count;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InvestidorCorretoraDTO{" +
                "corretora='" + corretora + '\'' +
                ", count=" + count +
                '}';
    }
}
