package pl.staszczykpiotr.truckforwarder_backend.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;
import pl.staszczykpiotr.truckforwarder_backend.repository.TruckRepository;

import java.util.Iterator;
import java.util.List;


@RestController
public class TruckController {



    private TruckRepository truckRepository;

    @Autowired
    public TruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }


    @GetMapping("/trucks/all")

    public List<Truck> getTrucks() {


        return truckRepository.findAll();
    }



}




