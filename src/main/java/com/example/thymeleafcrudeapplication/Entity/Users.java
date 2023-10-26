package com.example.thymeleafcrudeapplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 40)
    private String email;
    @Column(length = 15)
    private String password;
    @Column(length = 45, nullable = false)
    private String firstName;
    @Column(length = 45, nullable = false)
    private String lastName;
    private boolean enabled;
}
