package com.foodforcharity.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "b00074902.DonorStatus")
public class DonorStatus {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "Name")
    String name;
}
