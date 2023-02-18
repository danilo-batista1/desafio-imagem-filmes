package br.com.imagemfilmes.desafio.entity;

import java.math.BigDecimal;

public class Produto {
    private int registro;
    private String descricao;
    private BigDecimal valorUnitario;

    public int getRegistro() {
        return registro;
    }

    public Produto setRegistro(int registro) {
        this.registro = registro;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public Produto setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "registro=" + registro +
                ", descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
