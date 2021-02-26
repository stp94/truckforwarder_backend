package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cargos")
public class Cargo {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column
    String type;
    Float size;
    Float length;
    Float width;
    Float height;
    Float weight;
    Float capacity;
    String desc;
}
