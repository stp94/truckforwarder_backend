package pl.staszczykpiotr.truckforwarder_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.dto.Course;
import pl.staszczykpiotr.truckforwarder_backend.dto.Order;
import pl.staszczykpiotr.truckforwarder_backend.repository.CourseRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private CourseRepository courseRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, CourseRepository courseRepository){
        this.orderRepository = orderRepository;
        this.courseRepository = courseRepository;

    }


    @GetMapping("/order/all")

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/vieworders")
    public List<Map> getViewOrders(){
        return orderRepository.findOrders();
    }

    @GetMapping("/session/course/viewcourses")
    public List<Map> getViewCourses(){

        return courseRepository.findCourses(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @PostMapping("/session/course/new")
    public void postCreateCourse(@RequestBody com.fasterxml.jackson.databind.JsonNode userDataForCourse){



        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.SECOND,userDataForCourse.get("Distance").intValue());

        Course course = new Course();
        course.setId(Math.toIntExact(courseRepository.count()+1));
        course.setStart_time(startTime);
        course.setEnd_time(endTime);
        course.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        course.setIdbought(userDataForCourse.get("selectedTruckId").intValue());
        course.setIdorders(userDataForCourse.get("selectedOrderId").intValue());
        course.setDuration(userDataForCourse.get("Distance").floatValue());
        course.setFinished(false);
        course.setProgress(0);
        courseRepository.save(course);


        //System.out.println(userDataForCourse.get("selectedOrderId")+"||"+userDataForCourse.get("selectedTruckId")+"||"+ userDataForCourse.get("Distance"));

    }




    @GetMapping("/session/course/update_progress")
    public List<Map> getProgress(int id, int progress){


        Course c = courseRepository.findById(id);
        c.setProgress(progress);
        courseRepository.save(c);


        return courseRepository.getProgress(id);
    }




//    public List<Map> findCourses(){return courseRepository.findCourses(SecurityContextHolder.getContext().getAuthentication().getName());}

}
