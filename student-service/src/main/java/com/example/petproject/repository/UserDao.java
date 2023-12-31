package com.example.petproject.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {
    private final static List<UserDetails> APPLICATION_USERS =
            Arrays.asList(
                    new User("vpasemko@gmail.com",
                            "password",
                            List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))),
                    new User("olkosalo@gmail.com",
                            "password",
                            List.of(new SimpleGrantedAuthority("ROLE_USER")))
            );


    public UserDetails findUserByEmail(String email){
        return APPLICATION_USERS
                .stream()
                .filter(e->e.getUsername().equals(email))
                .findAny()
                .orElseThrow(()->new UsernameNotFoundException("No user was found"));

    }

}
