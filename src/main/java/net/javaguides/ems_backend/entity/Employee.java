package net.javaguides.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
        @Column(name = "first_name",nullable = false)
         private String firstname;
        @Column(name="last_name",nullable = false)
         private String lastname;
        @Column(name="email",nullable = false,unique = true)
         private String email;
}
