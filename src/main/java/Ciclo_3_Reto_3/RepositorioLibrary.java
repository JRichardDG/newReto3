/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author g6
 */

@Repository
public class RepositorioLibrary {
    @Autowired
    private Interfacelibrary crud;
    
    public List<library> getALl(){
        return (List<library>) crud.findAll();
    }
    
    public Optional <library> getLibrary(int id){
        return crud.findById(id);
    }
    
    public library save(library partyroom){
        return crud.save(partyroom);
    }
    
    public void delete (library partyroom){
        crud.delete(partyroom);
    }
}
