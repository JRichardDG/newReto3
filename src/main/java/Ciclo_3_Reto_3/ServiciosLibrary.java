package Ciclo_3_Reto_3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosLibrary{

    @Autowired
    private RepositorioLibrary metodosCrud;

    public List<library> getAll() {
        return metodosCrud.getALl();
    }

    public Optional<library> getLibrary(int idLibrary) {
        return metodosCrud.getLibrary(idLibrary);
    }

    public library save(library library) {
        if (library.getId() == null) {
            return metodosCrud.save(library);
        } else {
            Optional<library> evt = metodosCrud.getLibrary(library.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(library);
            } else {
                return library;
            }
        }
    }

    public library update(library library) {
        if (library.getId() != null) {
            Optional<library> evt = metodosCrud.getLibrary(library.getId());
            if (!evt.isEmpty()) {
                if (library.getName() != null) {
                    evt.get().setTarget(library.getTarget());
                }
                if (library.getCapacity() != null) {
                    evt.get().setCapacity(library.getCapacity());
                }
                if (library.getDescription() != null) {
                    evt.get().setDescription(library.getDescription());
                }
                if (library.getCategory() != null) {
                    evt.get().setCategory(library.getCategory());
                }
                metodosCrud.save((evt.get()));
                return evt.get();
            } else {
                return library;
            }
        } else {
            return library;
        }
    }

    public boolean deleteLibrary(int i) {
        Boolean boolea = getLibrary(i).map((partyroom) -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return boolea;
    }

}
