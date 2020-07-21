package pl.staszczykpiotr.truckforwarder_backend.dto;

import pl.staszczykpiotr.truckforwarder_backend.interfaces.ITruck;

import javax.persistence.*;


@Entity(name = "trucks")
@Table(name = "trucks")

public class Truck implements ITruck{


    @Id
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
    @Column(name = "status")
    protected Byte status;

    public Truck(){

    };


    @Override
    public Integer getID() {
        return idtrucks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLoading() {
        return loadingtype;
    }

    @Override
    public Float getLength() {
        return length;
    }

    @Override
    public Float getWidth() {
        return width;
    }

    @Override
    public Float getHeight() {
        return height;
    }

    @Override
    public Float getWeight() {
        return weight;
    }

    @Override
    public Float getCapacity() { return capacity;
    }

    @Override
    public Float getPrice() {
        return price;
    }


    @Override
    public Byte getStatus() {
        return status;
    }
}
