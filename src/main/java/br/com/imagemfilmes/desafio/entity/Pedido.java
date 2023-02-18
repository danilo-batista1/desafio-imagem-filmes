package br.com.imagemfilmes.desafio.entity;

import java.util.List;

public class Pedido {

    private Long id;
    private String IdPessoa;
    private List<PedidoItem> itens;
    
    public Long getId() {
        return id;
    }

    public Pedido setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIdPessoa() {
        return IdPessoa;
    }

    public Pedido setIdPessoa(String IdPessoa) {
        this.IdPessoa = IdPessoa;
        return this;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public Pedido s(List<PedidoItem> itens) {
        this.itens = itens;
        return this;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", pessoa=" + IdPessoa +
                '}';
    }
}
