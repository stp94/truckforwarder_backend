package pl.staszczykpiotr.truckforwarder_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.MyUserDetailService;
import pl.staszczykpiotr.truckforwarder_backend.MyUserPrincipal;
import pl.staszczykpiotr.truckforwarder_backend.dto.BoughtTrucks;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;
import pl.staszczykpiotr.truckforwarder_backend.dto.Truck;
import pl.staszczykpiotr.truckforwarder_backend.repository.BoughtTrucksRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.PlayerRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.TruckRepository;

import java.util.List;

@RestController


public class PlayerController {
    private PlayerRepository playerRepository;
    private BoughtTrucksRepository boughtTrucksRepository;





    @Autowired
    public PlayerController(PlayerRepository playerRepository, BoughtTrucksRepository boughtTrucksRepository) {
        this.playerRepository = playerRepository;
        this.boughtTrucksRepository = boughtTrucksRepository;
    }


    @GetMapping("/session/player/info")

    public Player getPlayer() {


            return playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName());

    }

    @GetMapping("/session/player/bought_trucks")

    public BoughtTrucks getBoughtTrucks(){

            return boughtTrucksRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName());
    }

   





}
