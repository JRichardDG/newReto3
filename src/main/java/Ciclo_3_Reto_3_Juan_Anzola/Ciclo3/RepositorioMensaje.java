/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3_Juan_Anzola.Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan
 */
@Repository
public class RepositorioMensaje{
    
    @Autowired
    private InterfaceMensaje crud;
    
    public  List<Mensaje> getAll(){
        return (List<Mensaje>) crud.findAll();
    }
    
    public Optional <Mensaje> getMessage (int id){
        return crud.findById(id);
    }
    
    public Mensaje save(Mensaje message){
        return crud.save(message);
    }
    
    public void delete(Mensaje message){
        crud.delete(message);
    }
}
