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
public class ServiciosCliente {

    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int idCliente) {
        return metodosCrud.getCliente(idCliente);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdClient() == null) {
            return metodosCrud.save(cliente);
        } else {
            Optional<Cliente> e = metodosCrud.getCliente(cliente.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente update(Cliente cliente) {
        if (cliente.getIdClient()!= null) {
            Optional<Cliente> ev = metodosCrud.getCliente(cliente.getIdClient());
            if (!ev.isEmpty()) {
                if (cliente.getName() != null) {
                    ev.get().setName(cliente.getName());
                }
                if (cliente.getAge() != null) {
                    ev.get().setName(cliente.getName());
                }
                if (cliente.getPassword()!= null) {
                    ev.get().setPassword(cliente.getPassword());
                }
                metodosCrud.save((ev.get()));
                return ev.get();
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }

    public boolean deleteCliente(int ClienteId) {
        Boolean boole = getCliente(ClienteId).map((cliente) -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return boole;
    }
}

