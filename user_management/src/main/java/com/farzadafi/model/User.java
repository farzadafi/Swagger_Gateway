package com.farzadafi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    Long id;

    String email;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    String firstName;

    String lastName;

    String phoneNumber;

    String nationalCode;

    @Column(columnDefinition = "TEXT")
    String avatar;

    String about;

    Date registerDate;
}
