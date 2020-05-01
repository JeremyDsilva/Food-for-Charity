package com.foodforcharity.app.domain.entity;

import com.foodforcharity.app.domain.constant.SpiceLevel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The persistent class for the DONEE_SPICE_RANGE database table.
 */
@Data
@Entity
@Table(name = "DONEE_SPICE_RANGE")
public class DoneeSpiceRange implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @OneToOne
    @NotNull
    private Donee donee;

    // bi-directional many-to-one association to SpiceLevel
    @Enumerated(EnumType.STRING)
    @NotNull
    private SpiceLevel startLevel;

    // bi-directional many-to-one association to SpiceLevel
    @Enumerated(EnumType.STRING)
    @NotNull
    private SpiceLevel endLevel;

}