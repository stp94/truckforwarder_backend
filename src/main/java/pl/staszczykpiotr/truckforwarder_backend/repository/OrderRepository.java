package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.staszczykpiotr.truckforwarder_backend.dto.Order;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query
            (value = "SELECT ord.idorder as id, ord.source as source, ord.destination as destination , " +
                     "ord.distance as distance, ord.reward as reward, " +
                     "carg.type as type, carg.size as size, carg.length as length, carg.width as width, " +
                     "carg.height as height, carg.weight as weight, carg.capacity as capacity, carg.desc as desc,  " +
                     "cst.name as client  from Order ord, Cargo carg, Customer cst where ord.idcustomers = cst.id and ord.idcargos = carg.id")
    List<Map> findOrders();


}
