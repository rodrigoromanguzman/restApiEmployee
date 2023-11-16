package com.example.restApiEmployee.security;

import com.example.restApiEmployee.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    public SecurityUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        var user = this.userRepository.findByUsername(username);
        if(user.isPresent()){
            return new SecurityUser(user.get());
        }
        throw new UsernameNotFoundException("Usuario no se ha encontrado: "+username);
    }
}
