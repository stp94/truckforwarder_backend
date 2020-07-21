package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table (name = "bought_trucks")
public class BoughtTrucks {
    @Id
    private Integer idbought_trucks;

    @Column
    private Integer idtrucks;
    private Integer idplayers;
    private Integer condition;
    private Boolean available;
    private String owner;




    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getIdbought_trucks() {
        return idbought_trucks;
    }

    public void setIdbought_trucks(Integer idbought_trucks) {
        this.idbought_trucks = idbought_trucks;
    }

    public Integer getIdtrucks() {
        return idtrucks;
    }

    public void setIdtrucks(Integer idtrucks) {
        this.idtrucks = idtrucks;
    }

    public Integer getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(Integer idplayers) {
        this.idplayers = idplayers;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }




}
