/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3_Juan_Anzola.Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan
 */

@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud;
    
    public  List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud.findAll();
    }
    
    public Optional <Reservaciones> getReservation (int id){
        return crud.findById(id);
    }
    
    public Reservaciones save(Reservaciones reservation){
        return crud.save(reservation);
    }
    
    public void delete(Reservaciones reservation){
        crud.delete(reservation);
    }
}
