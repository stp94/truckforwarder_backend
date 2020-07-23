package pl.staszczykpiotr.truckforwarder_backend.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.dto.User;

import java.security.Principal;



@RestController
@CrossOrigin
@RequestMapping("/principal")
public class UserController {


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







}
