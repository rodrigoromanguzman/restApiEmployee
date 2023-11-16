package com.example.restApiEmployee.entity;

import com.example.restApiEmployee.utils.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="athorities")
public class Authority {
    public Authority(AuthorityName authorityName){
        this.name = authorityName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;
}
