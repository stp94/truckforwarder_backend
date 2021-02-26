package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;

    @Column
    private String name;
}
