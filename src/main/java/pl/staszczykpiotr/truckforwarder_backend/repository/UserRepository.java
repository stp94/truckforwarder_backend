package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.staszczykpiotr.truckforwarder_backend.dto.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
