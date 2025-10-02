package portal.elearning.UserService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portal.elearning.UserService.dto.userRequestDto;
import portal.elearning.UserService.dto.userResponseDto;
import portal.elearning.UserService.entity.userEntity;
import portal.elearning.UserService.repository.userRepository;
import portal.elearning.UserService.service.userService;

import java.util.List;


@RestController
@RequestMapping
public class userController {

    @Autowired
    private userService userService;


   // private userRepository userRepository;

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody @Valid userEntity userDTO){
        userEntity savedUser=userService.userRegister(userDTO);
        if(savedUser!=null){
            return ResponseEntity.ok("registered!");
        }else{
            return ResponseEntity.badRequest().body("user already registered!");
        }
    }
    @PostMapping("/login")
    public String login(@RequestBody @Valid userRequestDto userDTO){
        boolean success=userService.userLogin(userDTO);
        return success?"Login successful":"Invalid Credentials";

    }
    @GetMapping("/getAllUsers")
    public List<userEntity>getAllUsers(){
        return userService.getAllusers();

    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "User Deleted successfully";
    }

}
