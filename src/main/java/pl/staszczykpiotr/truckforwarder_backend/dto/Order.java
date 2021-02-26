package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="orders")
public class Order {
    @Id
    @Column (name="id")
    private Integer idorder;
    private String source;
    private String destination;
    private Float reward;
    private Float distance;
    private Integer idcustomers;
    private Integer idcargos;

    public Order(){

    };

    public Integer getIdorder() {
        return idorder;
    }
    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Float getReward() {
        return reward;
    }
    public void setReward(Float reward) {
        this.reward = reward;
    }
    public Float getDistance() {
        return distance;
    }
    public void setDistance(Float distance) {
        this.distance = distance;
    }
    public Integer getIdcustomers() {
        return idcustomers;
    }
    public void setIdcustomers(Integer idcustomers) {
        this.idcustomers = idcustomers;
    }
    public Integer getIdcargos() {
        return idcargos;
    }
    public void setIdcargos(Integer idcargos) {
        this.idcargos = idcargos;
    }

}
