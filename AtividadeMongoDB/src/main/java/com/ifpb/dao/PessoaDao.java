package com.ifpb.dao;

import com.ifpb.database.MongoConnection;
import com.ifpb.model.Pessoa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jonas
 */
public class PessoaDao {
    
    private final MongoCollection collection ;
    
    public PessoaDao() {
        
        collection = new MongoConnection().getCollection("Pessoa");
    }
    
    public void salvar(Pessoa p) {       
       collection.insertOne(p.toDocument());
    }
    
    public List<Pessoa> listar() {
       List<Pessoa> pessoas = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while(cursor.hasNext()) {
                pessoas.add(new Pessoa(cursor.next()));
            }
            
            return pessoas;            
        }
    
    }
    
    public Pessoa buscarCpf (String cpf) {
        Document doc = (Document) collection.find(eq("cpf", cpf)).first(); 
        
        if(doc != null) {
            return new Pessoa(doc);
        }
        return null;
         
    }
    
    public boolean deleteCpf (String cpf) {
        DeleteResult deleteResult = collection.deleteOne(eq("cpf",cpf));
        
        return deleteResult.getDeletedCount() > 0;
    }
    
    public boolean update(Pessoa p) {
        UpdateResult result = collection.updateOne(eq("cpf", p.getCpf()),
            new Document("$set",
                    new Document("nome",p.getNome())
                            .append("idade", p.getIdade())
                        )
            );
        return result.getModifiedCount() > 0;
            
    }
    
}
