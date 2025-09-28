package portal.elearning.UserService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portal.elearning.UserService.dto.userRequestDto;
import portal.elearning.UserService.service.userService;


@RestController
public class userController {

    @Autowired
    userService userService;

//    @PostMapping("/login")
//    public void logIn(@RequestBody String email, String password){
//
//
//
//    }
    @PostMapping("/register")
    public String register(@RequestBody @Valid userRequestDto userDTO){
        userService.userRegister(userDTO);
        return "User Registered Successfully";


    }

}
