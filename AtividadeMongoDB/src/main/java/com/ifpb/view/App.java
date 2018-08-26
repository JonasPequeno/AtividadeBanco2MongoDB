package com.ifpb.view;

import com.ifpb.dao.VendaDao;
import com.ifpb.model.Produto;
import com.ifpb.model.Venda;
import java.util.List;

/**
 *
 * @author jonas
 */
public class App {
    public static void main(String[] args) {
           VendaDao dao = new VendaDao();
        Venda venda = new Venda();
        
        Produto p3 = new Produto(4, "Manga", 3.40);
        
        System.out.println(dao.deletaVendaCodigo(1));
        
        List<Venda> listar = dao.listar();
        
        for(int i = 0; i<listar.size(); i++) {
            System.out.println(listar.get(i).toString());
        }
        
    }
}
