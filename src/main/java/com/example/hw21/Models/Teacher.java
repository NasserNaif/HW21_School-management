package com.example.hw21.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "integer not null")
    private Integer age;

    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @Column(columnDefinition = "integer not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
