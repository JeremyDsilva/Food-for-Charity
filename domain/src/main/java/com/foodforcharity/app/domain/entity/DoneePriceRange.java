package com.foodforcharity.app.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The persistent class for the DONEE_PRICE_RANGE database table.
 */
@Data
@Entity
@Table(name = "DONEE_PRICE_RANGE")
public class DoneePriceRange implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @OneToOne
    @NotNull
    private Donee donee;

    @Column(name = "END_PRICE")
    @NotNull
    private Integer endPrice;

    @Column(name = "START_PRICE")
    @NotNull
    private Integer startPrice;

}