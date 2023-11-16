package com.example.restApiEmployee.utils;

import com.example.restApiEmployee.entity.Authority;
import com.example.restApiEmployee.entity.User;
import com.example.restApiEmployee.repository.AuthorityRepository;
import com.example.restApiEmployee.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    public Runner(UserRepository userRepository,AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }
    @Override
    public void run(String... args) throws Exception{
        if(this.authorityRepository.count()==0){
            this.authorityRepository.saveAll(
                    List.of(
                            new Authority(AuthorityName.ADMIN),
                            new Authority(AuthorityName.READ),
                            new Authority(AuthorityName.WRITE)

                    )
            );
        }
        if(this.userRepository.count() == 0){
            var enconders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(
                    List.of(
                            new User("rodrigoroman",enconders.encode("rroman123"),List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()) ),
                            new User("User01", enconders.encode("user123"),List.of(this.authorityRepository.findByName(AuthorityName.READ).get()) )
                    )
            );
        }
    }

}
