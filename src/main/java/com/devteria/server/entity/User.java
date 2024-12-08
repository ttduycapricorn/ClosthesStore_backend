package com.devteria.server.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String phone;

    LocalDate birthDay;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    Roles role;
}
