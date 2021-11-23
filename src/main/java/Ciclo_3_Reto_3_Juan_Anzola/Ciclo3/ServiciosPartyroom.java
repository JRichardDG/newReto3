package Ciclo_3_Reto_3_Juan_Anzola.Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosPartyroom {

    @Autowired
    private RepositorioPartyroom metodosCrud;

    public List<Partyroom> getAll() {
        return metodosCrud.getALl();
    }

    public Optional<Partyroom> getPartyroom(int idPartyroom) {
        return metodosCrud.getPartyroom(idPartyroom);
    }

    public Partyroom save(Partyroom partyroom) {
        if (partyroom.getIdPartyroom() == null) {
            return metodosCrud.save(partyroom);
        } else {
            Optional<Partyroom> evt = metodosCrud.getPartyroom(partyroom.getIdPartyroom());
            if (evt.isEmpty()) {
                return metodosCrud.save(partyroom);
            } else {
                return partyroom;
            }
        }
    }

    public Partyroom update(Partyroom partyroom) {
        if (partyroom.getIdPartyroom() != null) {
            Optional<Partyroom> evt = metodosCrud.getPartyroom(partyroom.getIdPartyroom());
            if (!evt.isEmpty()) {
                if (partyroom.getName() != null) {
                    evt.get().setOwner(partyroom.getOwner());
                }
                if (partyroom.getCapacity() != null) {
                    evt.get().setCapacity(partyroom.getCapacity());
                }
                if (partyroom.getDescription() != null) {
                    evt.get().setDescription(partyroom.getDescription());
                }
                if (partyroom.getCategory() != null) {
                    evt.get().setCategory(partyroom.getCategory());
                }
                metodosCrud.save((evt.get()));
                return evt.get();
            } else {
                return partyroom;
            }
        } else {
            return partyroom;
        }
    }

    public boolean deletePartyroom(int i) {
        Boolean boolea = getPartyroom(i).map((partyroom) -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return boolea;
    }

}
