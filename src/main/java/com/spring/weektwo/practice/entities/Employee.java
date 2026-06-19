package com.spring.weektwo.practice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,updatable = true,length = 100)
    private String name;
    @Column(nullable = false,unique = true,updatable = true,length = 100)
    private String email;
    @Column(nullable = false,length = 2)
    private Integer age;
    @Column(nullable = false)
    private String role;
    @CreatedDate
    private LocalDate doj;
    @Column(nullable = false)
    private BigDecimal salary;
    @Column(nullable = false)
    private Boolean isActive;
}
