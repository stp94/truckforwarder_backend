package pl.staszczykpiotr.truckforwarder_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.staszczykpiotr.truckforwarder_backend.dto.Player;
import pl.staszczykpiotr.truckforwarder_backend.dto.User;
import pl.staszczykpiotr.truckforwarder_backend.repository.PlayerRepository;
import pl.staszczykpiotr.truckforwarder_backend.repository.UserRepository;

@CrossOrigin
@RestController
@CrossOrigin
@RequestMapping("/principal")
public class UserController {
    private PlayerRepository playerRepository;
    private UserRepository userRepository;

    @Autowired
    public UserController(PlayerRepository playerRepository, UserRepository userRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;

    }


    @PostMapping("/login")
    public String loginUser(@RequestBody String username, String password) {

        return "login_success";


    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.OK)
    public String processRegister(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(true);
        user.setId((long) Math.toIntExact(playerRepository.count() + 1));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        Player player = new Player();
        player.setIdplayers(Math.toIntExact(playerRepository.count() + 1));
        player.setName(username);
        player.setSpeed(100F);
        player.setResponsibility(100F);
        player.setRespect(100F);
        player.setCash(15000F);
        player.setFinished_courses(0);
        player.setFailed_courses(0);
        player.setOwner(username);

        playerRepository.save(player);


        return "login success";
    }

}




