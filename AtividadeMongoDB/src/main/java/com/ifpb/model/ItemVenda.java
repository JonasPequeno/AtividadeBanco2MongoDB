
package com.ifpb.model;

/**
 *
 * @author jonas
 */
public class ItemVenda {
    
    private Produto produtos;
    private int quantidade;

    public ItemVenda() {
    }

    public ItemVenda(Produto produtos, int quantidade) {
        this.produtos = produtos;
        this.quantidade = quantidade;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "produtos=" + produtos + ", quantidade=" + quantidade + '}';
    }
    
    
            
    
}
