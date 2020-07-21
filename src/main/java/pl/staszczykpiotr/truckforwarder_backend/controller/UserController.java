package pl.staszczykpiotr.truckforwarder_backend.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/principal")
public class UserController {


    @GetMapping
    public Principal retrievePrincipal(Principal principal) {

        return principal;
    }


    @PostMapping(path = "/principal/login")
    public void transferPrincipal(@RequestParam String username, @RequestParam String password) {


        System.out.println("test");


    }




}
