package com.example.restApiEmployee.security;

import com.example.restApiEmployee.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final Authority authority;
    @Override
    public String getAuthority(){
        return authority.getName().toString();
    }
}
