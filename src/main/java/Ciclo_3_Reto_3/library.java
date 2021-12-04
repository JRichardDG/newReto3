
package Ciclo_3_Reto_3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "library")

public class library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String  name;
    private String  target;
    private Integer capacity;
    private String  description; 
    
    @ManyToOne
    @JoinColumn(name="CategoriaId")
    @JsonIgnoreProperties("library")
    private Categoria category;
    
    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "library")
    @JsonIgnoreProperties({"library", "client"})
    private List<Mensaje> message;
    
    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "library")
    @JsonIgnoreProperties({"library", "client"})
    private List<Reservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessage() {
        return message;
    }

    public void setMessage(List<Mensaje> message) {
        this.message = message;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }

   
}