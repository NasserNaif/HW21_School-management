package com.example.hw21.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20)")
    private String area;
    @Column(columnDefinition = "varchar(20)")
    private String street;

    @Column(columnDefinition = "integer")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
