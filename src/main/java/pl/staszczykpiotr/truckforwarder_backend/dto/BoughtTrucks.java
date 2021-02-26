package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table (name = "bought_trucks")
public class BoughtTrucks {
    @Id
    @Column (name = "id")
    private Integer idbought_trucks;

    @Column
    private Integer idtrucks;
    private Integer idplayers;
    private Integer life;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean available;
    private String owner;

    public BoughtTrucks(Integer idbought_trucks, Integer idtrucks, Integer idplayers, Integer condition, Boolean available, String owner){
        this.idbought_trucks = idbought_trucks;
        this.idtrucks = idtrucks;
        this.idplayers = idplayers;
        this.life = condition;
        this.available = available;
        this.owner = owner;

    }

    public BoughtTrucks(){}

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

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer condition) {
        this.life = condition;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }




}
