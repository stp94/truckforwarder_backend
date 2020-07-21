package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.staszczykpiotr.truckforwarder_backend.dto.BoughtTrucks;

public interface BoughtTrucksRepository extends JpaRepository<BoughtTrucks, Integer> {

    BoughtTrucks findByOwner(String owner);

}
