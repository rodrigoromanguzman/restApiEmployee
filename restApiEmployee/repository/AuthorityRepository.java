package com.example.restApiEmployee.repository;

import com.example.restApiEmployee.entity.Authority;
import com.example.restApiEmployee.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByName(AuthorityName name);
}
