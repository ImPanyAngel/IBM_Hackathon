package com.example.lab1_s2.service;

import com.example.lab1_s2.model.User;
import com.example.lab1_s2.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetails implements UserDetailsService {
    private UserRepository userRepository;
    public UserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public org.springframework.security.core.userdetails.UserDetails
    loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.
                withUsername(user.getUsername()).password(user.getPassword()).
                build();
    }
}
