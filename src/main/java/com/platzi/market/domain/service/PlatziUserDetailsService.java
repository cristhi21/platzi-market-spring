package com.platzi.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailsService implements UserDetailsService {
    //Este usuario es un demo
    // Lo correcto es ir a una BD o un sistema con Auth0 para verificar un correcto inicio de session
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("cvargas", "{noop}12345", new ArrayList<>());
    }
}
