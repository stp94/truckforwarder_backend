package pl.staszczykpiotr.truckforwarder_backend.dto;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table (name = "courses")

public class Course {
    @Id
    @Column(name = "id")
    private int id;

    public Course(){

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdorders() {
        return idorders;
    }

    public void setIdorders(Integer idorders) {
        this.idorders = idorders;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getIdbought() {
        return idbought;
    }

    public void setIdbought(Integer idbought) {
        this.idbought = idbought;
    }

    public Calendar getStart_time() {
        return start_time;
    }

    public void setStart_time(Calendar start_time) {
        this.start_time = start_time;
    }

    public Calendar getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Calendar end_time) {
        this.end_time = end_time;
    }



    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    @Column
    Integer idorders;
    String owner;
    Integer idbought;
    Float duration;

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    Integer progress;

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    Boolean finished;
    @Temporal(TemporalType.DATE)
    Calendar start_time;
    @Temporal(TemporalType.DATE)
    Calendar end_time;
}


