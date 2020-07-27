package pl.staszczykpiotr.truckforwarder_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;
import pl.staszczykpiotr.truckforwarder_backend.dto.User;
import pl.staszczykpiotr.truckforwarder_backend.repository.BoughtTrucksRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.PlayerRepository;

import java.security.Principal;

@CrossOrigin
@RestController
@CrossOrigin
@RequestMapping("/principal")
public class UserController {
    private PlayerRepository playerRepository;

    @Autowired
    public UserController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }


    @GetMapping
    public User transferPrincipal(@RequestParam String username, @RequestParam String password){
        User httpEntryUser = new User();

        httpEntryUser.setUsername(username);
        httpEntryUser.setPassword(password);

        return httpEntryUser;

    }

    @GetMapping("info")
    public Principal retrievePrincipal(Principal principal) {

        return principal;
    }



    @PostMapping()
    public Player loginUser(@RequestBody String username, String password){

        return playerRepository.findByOwner(SecurityContextHolder.getContext().getAuthentication().getName());

    }




}
