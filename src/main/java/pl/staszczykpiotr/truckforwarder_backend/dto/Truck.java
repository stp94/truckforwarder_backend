package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.*;


@Entity
@Table(name = "trucks")

public class Truck {

    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idtrucks;

    @Column(name = "name")
    protected String name;
    @Column(name = "loadingtype")
    protected String loadingtype;
    @Column(name = "length")
    protected Float length;
    @Column(name = "width")
    protected Float width;
    @Column(name = "height")
    protected Float height;
    @Column(name = "weight")
    protected Float weight;
    @Column(name = "capacity")
    protected Float capacity;
    @Column(name = "price")
    protected Float price;


    public Truck(){

    };


    public Integer getID() {
        return idtrucks;
    }

    public String getName() {
        return name;
    }

    public String getLoading() {
        return loadingtype;
    }

    public Float getLength() {
        return length;
    }

    public Float getWidth() {
        return width;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getCapacity() { return capacity;
    }

    public Float getPrice() {
        return price;
    }

}
