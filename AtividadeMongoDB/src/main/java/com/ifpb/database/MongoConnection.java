package com.ifpb.database;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author jonas
 */
public class MongoConnection {
    
    private final MongoClient client;
    private final MongoDatabase database;    
    
    public MongoConnection() {
        //startando o cliente mongo
        client = MongoClients.create("mongodb://localhost:27017");
        //startando banco de dados/ passando o banco aula
        database = client.getDatabase("aula");
    }    
    
    public MongoCollection getCollection (String nome) {
        return database.getCollection(nome);
    }
        
}
