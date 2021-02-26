package pl.staszczykpiotr.truckforwarder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.staszczykpiotr.truckforwarder_backend.dto.BoughtTrucks;
import pl.staszczykpiotr.truckforwarder_backend.dto.Course;

import java.util.List;
import java.util.Map;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query
    (value = "SELECT c.id as id, c.start_time as start_time, c.end_time as end_time, c.duration as duration , c.progress as progress, bt.idbought_trucks as idbought_trucks, t.name as name, o.idorder as idorder, o.destination as destination, o.source as source, o.reward as reward from Course c, Order o, BoughtTrucks bt, Truck t where c.idbought = bt.idbought_trucks and bt.idtrucks = t.idtrucks and o.idorder = c.idorders and c.owner = :owner")
    List<Map> findCourses(@Param("owner") String owner);


    @Query
    (value = "SELECT c.id as id, c.progress as progress, c.duration as duration from Course c where c.id = :id")
    List<Map> getProgress(@Param("id") int id);

    Course findById(int id);

}
