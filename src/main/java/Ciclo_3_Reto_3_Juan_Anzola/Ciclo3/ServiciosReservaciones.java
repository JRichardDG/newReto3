/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3_Juan_Anzola.Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan
 */

@Service
public class ServiciosReservaciones {
    
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation (int idReservation) {
        return metodosCrud.getReservation(idReservation);
    }

    public Reservaciones save(Reservaciones reservaciones) {
        if (reservaciones.getIdReservation()== null) {
            return metodosCrud.save(reservaciones);
        } else {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservaciones.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservaciones);
            } else {
                return reservaciones;
            }
        }
    }

    public Reservaciones update(Reservaciones reservaciones) {
        if (reservaciones.getIdReservation()!= null) {
            Optional<Reservaciones> ev = metodosCrud.getReservation(reservaciones.getIdReservation());
            if (!ev.isEmpty()) {
                if (reservaciones.getStartDate()!= null) {
                    ev.get().setStartDate(reservaciones.getStartDate());
                }
                if (reservaciones.getDevolutionDate()!= null) {
                    ev.get().setDevolutionDate(reservaciones.getDevolutionDate());
                }
                if (reservaciones.getStatus()!= null) {
                    ev.get().setStatus(reservaciones.getStatus());
                }
                metodosCrud.save((ev.get()));
                return ev.get();
            } else {
                return reservaciones;
            }
        } else {
            return reservaciones;
        }
    }

    public boolean deleteReservaciones (int ReservacionesId) {
        Boolean boole = getReservation(ReservacionesId).map((reservation) -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return boole;
    }
}
