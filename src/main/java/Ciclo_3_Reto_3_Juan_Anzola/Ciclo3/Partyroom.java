
package Ciclo_3_Reto_3_Juan_Anzola.Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Partyroom")

public class Partyroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer IdPartyroom;
    private String  Name;
    private String  Owner;
    private Integer Capacity;
    private String  Description; 
    
    @ManyToOne
    @JoinColumn(name="CategoriaId")
    @JsonIgnoreProperties("partyroom")
    private Categoria category;
    
    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom", "client"})
    private List<Mensaje> message;
    
    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom", "client"})
    private List<Reservaciones> reservations;

    public Integer getIdPartyroom() {
        return IdPartyroom;
    }

    public void setIdPartyroom(Integer IdPartyroom) {
        this.IdPartyroom = IdPartyroom;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public Integer getCapacity() {
        return Capacity;
    }

    public void setCapacity(Integer Capacity) {
        this.Capacity = Capacity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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
