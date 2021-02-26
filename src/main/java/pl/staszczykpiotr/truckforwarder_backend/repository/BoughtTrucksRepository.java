package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.staszczykpiotr.truckforwarder_backend.dto.BoughtTrucks;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.hibernate.loader.Loader.SELECT;

public interface BoughtTrucksRepository extends JpaRepository<BoughtTrucks, Integer> {

    @Query
            (value = "SELECT bt.idbought_trucks as id, t.name as name, bt.life as life , bt.available as available, t.length as length, t.height as height, t.width as width, t.weight as weight from Truck t, BoughtTrucks bt where bt.idtrucks = t.idtrucks and bt.owner = :owner")
            List<Map> findBoughtTrucks(@Param("owner") String owner);


    BoughtTrucks findByOwner(String owner);
    List<BoughtTrucks> findAllByOwner(String owner);

    BoughtTrucks findById(int id);

}
