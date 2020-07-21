package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;

import java.util.List;


@Repository("TruckController")
public interface TruckRepository extends JpaRepository<Truck, Integer> {



}