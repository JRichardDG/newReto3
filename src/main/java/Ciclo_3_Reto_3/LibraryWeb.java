
package Ciclo_3_Reto_3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Library")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LibraryWeb {
    
    @Autowired
    private ServiciosLibrary servicios;
    
    @GetMapping("/all")
    public List <library> getPartyroom(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional <library> getPartyroom(@PathVariable("id") int idLibrary) {
        return servicios.getLibrary(idLibrary);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public library save(@RequestBody library library){
        return servicios.save(library);
    }    
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public library update(@RequestBody library library){
        return servicios.update(library);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int IdLibrary){
        return servicios.deleteLibrary(IdLibrary);
    }
}
