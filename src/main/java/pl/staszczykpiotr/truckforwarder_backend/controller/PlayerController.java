package pl.staszczykpiotr.truckforwarder_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.dto.BoughtTrucks;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;
import pl.staszczykpiotr.truckforwarder_backend.repository.BoughtTrucksRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.PlayerRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.TruckRepository;

import java.util.List;
import java.util.Map;

@RestController


public class PlayerController {
    private PlayerRepository playerRepository;
    private BoughtTrucksRepository boughtTrucksRepository;
    private TruckRepository truckRepository;



    @Autowired
    public PlayerController(PlayerRepository playerRepository, BoughtTrucksRepository boughtTrucksRepository, TruckRepository truckRepository ) {
        this.playerRepository = playerRepository;
        this.boughtTrucksRepository = boughtTrucksRepository;
        this.truckRepository = truckRepository;
    }

    @GetMapping("/trucks/all")

    public List<Truck> getTrucks() {
        return truckRepository.findAll();
    }


    @GetMapping("/session/player/info")

    public Player getPlayer() {
        return playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName());

    }

    @GetMapping("/session/player/bought_trucks")

    public List<Map> getBoughtTrucks() {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
            System.out.println(boughtTrucksRepository.findBoughtTrucks(SecurityContextHolder.getContext().getAuthentication().getName()));
        return boughtTrucksRepository.findBoughtTrucks(SecurityContextHolder.getContext().getAuthentication().getName());
    }


   


    @PostMapping("/session/player/purchase_truck")
    public void postPurchaseTruck(@RequestBody String SelectedTruck){

        StringBuilder stringBuilder = new StringBuilder();
        String selectedTruckByUser;
            stringBuilder.append(SelectedTruck);
            stringBuilder.delete(0,18);
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        selectedTruckByUser = stringBuilder.toString();
        BoughtTrucks boughtTrucks = new BoughtTrucks();
            boughtTrucks.setIdbought_trucks(Math.toIntExact(boughtTrucksRepository.count() + 1));
            boughtTrucks.setIdtrucks(truckRepository.findByName(selectedTruckByUser).getID());
            boughtTrucks.setIdplayers(playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()).getIdplayers());
            boughtTrucks.setLife(100);
            boughtTrucks.setAvailable(true);
            boughtTrucks.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());

        boughtTrucksRepository.save(boughtTrucks); // Add Bought Truck

        playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()).
                setCash(playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()).getCash() -
                        truckRepository.findByName(selectedTruckByUser).getPrice());

        playerRepository.save(playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()));



    }

    @PostMapping("/session/player/changeAvailability")
    public void changeAvailability (@RequestBody com.fasterxml.jackson.databind.JsonNode selectedTruck){

        System.out.println(selectedTruck.get("selectedTruckId"));
        BoughtTrucks bt = boughtTrucksRepository.findById(Integer.parseInt(selectedTruck.get("selectedTruckId").toString()));
        bt.setAvailable(false);
        boughtTrucksRepository.save(bt);

    }

    @PostMapping("/session/player/changeAvailabilityToTrue")
    public void changeAvailabilityToTrue (@RequestBody com.fasterxml.jackson.databind.JsonNode selectedTruck){

        System.out.println(selectedTruck.get("selectedTruckId"));
        System.out.println(selectedTruck.get("rewardCash"));
        playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()).
                setCash(playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()).getCash() + selectedTruck.get("rewardCash").floatValue()); // Set Cash Status
        playerRepository.save(playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName()));

        BoughtTrucks bt = boughtTrucksRepository.findById(Integer.parseInt(selectedTruck.get("selectedTruckId").toString()));
        bt.setAvailable(true);
        boughtTrucksRepository.save(bt);

    }






}
