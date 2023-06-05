package com.example.homework27.Service;

import com.example.homework27.Model.User;
import com.example.homework27.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUsername(username);

        if(username==null){
            throw new UsernameNotFoundException("wrong username or password");
        }
        return user;
    }
}
