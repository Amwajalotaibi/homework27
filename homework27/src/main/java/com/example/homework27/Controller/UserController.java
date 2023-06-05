package com.example.homework27.Controller;


import com.example.homework27.Model.User;
import com.example.homework27.Service.BlogService;
import com.example.homework27.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        List<User> userList=userService.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }


    @PostMapping("/register")
    public ResponseEntity register (@RequestBody User user){
        userService.register(user);

        return ResponseEntity.status(200).body("user register");
    }

    @PostMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.status(200).body("login");
    }

    @PostMapping ("/logout")
    public ResponseEntity logout(){

        return ResponseEntity.status(200).body("logout");
    }


    @PostMapping("/user")
    public ResponseEntity user (){

        return ResponseEntity.status(200).body("Welcome user");
    }



}
