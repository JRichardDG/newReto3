/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo_3_Reto_3;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author g6
 */

@Entity
@Table(name = "reservations")
public class Reservaciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer IdReservation;
    private Date    startDate;
    private Date    devolutionDate;
    private String  status="created";
    
    @ManyToOne
    @JoinColumn(name="LibraryId")
    @JsonIgnoreProperties({"message, reservations"})
    private library library;
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"message, reservations"})
    
    private Cliente client;
    
    //@OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    //@JsonIgnoreProperties("reservation")
    //private Score score;
    private String score;

    public Integer getIdReservation() {
        return IdReservation;
    }

    public void setIdReservation(Integer idReservation) {
        IdReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public library getLibrary() {
        return library;
    }

    public void setLibrary(library library) {
        this.library = library;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    



}
