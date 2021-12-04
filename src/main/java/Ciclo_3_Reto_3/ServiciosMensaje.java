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
public class ServiciosMensaje {
    
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMensaje) {
        return metodosCrud.getMessage(idMensaje);
    }

    public Mensaje save(Mensaje mensaje) {
        if (mensaje.getIdMessage()== null) {
            return metodosCrud.save(mensaje);
        } else {
            Optional<Mensaje> e = metodosCrud.getMessage(mensaje.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(mensaje);
            } else {
                return mensaje;
            }
        }
    }

    public Mensaje update(Mensaje message) {
        if (message.getIdMessage()!= null) {
            Optional<Mensaje> ev = metodosCrud.getMessage(message.getIdMessage());
            if (!ev.isEmpty()) {
                if (message.getMessageText()!= null) {
                    ev.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save((ev.get()));
                return ev.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMensaje(int messageId) {
        Boolean boole = getMensaje(messageId).map((message) -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return boole;
    }
}
