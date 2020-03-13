package com.foodforcharity.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Broker", schema = "b00074902")
@PrimaryKeyJoinColumn(name = "PersonId")
public class Broker extends Person  {
    // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long brokerId;

}