
package com.ifpb.dao;

import com.ifpb.database.MongoConnectionPojo;
import com.ifpb.model.ItemVenda;
import com.ifpb.model.Venda;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Updates.push;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class VendaDao {
    
    private final MongoCollection collection;
    
    public VendaDao() {
        collection = new MongoConnectionPojo().getCollection("Vendas", Venda.class);
        criaIndice();
        
    }     
    
    
    public void salvar (Venda venda) {
        collection.insertOne(venda);
    }
    
    public List<Venda> listar() {
        
        List<Venda> vendas = new ArrayList<>();
        MongoCursor cursor = collection.find().iterator();
        
        //castring venda
        while(cursor.hasNext()) {
            vendas.add( (Venda) cursor.next());
        }
        return vendas;                      
        
    }
    
    public Venda getVendaCodigo(int codigo) {
        Venda venda = (Venda) collection.find( eq("codigo", codigo)).first(); 
        if(venda != null) {
            return venda;
        }else return null;
    }
    
    public boolean deletaVendaCodigo(int codigo) {
        DeleteResult deleteOne = collection.deleteOne(eq ("codigo",codigo));
        return deleteOne.getDeletedCount() > 0;
    }
    
    public void insereItemVenda(int codigo, ItemVenda item) {
       collection.updateOne( eq("codigo",codigo),(push("itens",item)));
    }
    
    public void criaIndice() {
        
        IndexOptions opcoes = new IndexOptions().unique(true);
        collection.createIndex(Indexes.ascending("codigo"), opcoes);      
    }
}
