package com.example.homework27.Service;


import com.example.homework27.Model.User;
import com.example.homework27.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    public void register(User user){
        String hash=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        user.setRole("USER");
        userRepository.save(user);
    }

}
