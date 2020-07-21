package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;
import pl.staszczykpiotr.truckforwarder_backend.dto.User;

@Repository("PlayerController")
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findByOwner(String owner);

}
