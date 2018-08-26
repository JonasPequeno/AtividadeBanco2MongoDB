package com.ifpb.model;

import org.bson.Document;

/**
 *
 * @author jonas
 */
public class Pessoa {
    
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa() {};
    
    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public Pessoa (Document doc) {
        cpf = doc.getString("cpf");
        nome = doc.getString("nome");
        idade = doc.getInteger("idade");
      
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + '}';
    }
    
    
    public Document toDocument (){
        return new Document("cpf" , cpf)
                .append("nome", nome)
                .append("idade", idade);
    }           
            
}
