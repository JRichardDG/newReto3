/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author g6
 */

@Service
public class serviciosCategoria {
    
    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Categoria> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }
    
    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Categoria> evt=metodosCrud.getCategoria(categoria.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    public Categoria update (Categoria categoria){
        if(categoria.getId()!= null){
            Optional<Categoria> ev=metodosCrud.getCategoria(categoria.getId());
            if(!ev.isEmpty()){
                if(categoria.getName()!=null){
                    ev.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    ev.get().setName(categoria.getName());
                }
                metodosCrud.save((ev.get()));
                return ev.get();
            }else{
                    return categoria;
            }
        }else{
              return categoria;
             }
        }
    
        public boolean deleteCategoria(int CategoriaId){
            Boolean boole = getCategoria(CategoriaId).map((categoria) -> {
                metodosCrud.delete(categoria);
                return true;
            }).orElse(false);
            return boole;
        }
}
