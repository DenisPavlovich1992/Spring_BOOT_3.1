package com.spring_boot.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Surname is required")
    @Column(name = "surname", nullable = false)
    private String surname;

    @Pattern(regexp = ".*@gmail\\.com", message = "Only @gmail.com emails are allowed")
    @Email(message = "Email is not valid")
    @Column
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}