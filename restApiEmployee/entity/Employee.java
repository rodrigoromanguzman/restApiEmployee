package com.example.restApiEmployee.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NonNull
    @Column(name="first_name")
    private String firstName;

    @NonNull
    @Column(name="last_name")
    private String lastName;

    @NonNull
    @Column(name="email")
    private String email;
}
