package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {
    @Id
    private int idplayers;

    @Column
    private String name;
    private Float speed;
    private Float responsibility;
    private Float respect;
    private Float cash;
    private Integer finished_courses;
    private Integer failed_courses;
    private String owner;




    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(int idplayers) {
        this.idplayers = idplayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Float responsibility) {
        this.responsibility = responsibility;
    }

    public Float getRespect() {
        return respect;
    }

    public void setRespect(Float respect) {
        this.respect = respect;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public Integer getFinished_courses() {
        return finished_courses;
    }

    public void setFinished_courses(Integer finished_courses) {
        this.finished_courses = finished_courses;
    }

    public Integer getFailed_courses() {
        return failed_courses;
    }

    public void setFailed_courses(Integer failed_courses) {
        this.failed_courses = failed_courses;
    }
}
