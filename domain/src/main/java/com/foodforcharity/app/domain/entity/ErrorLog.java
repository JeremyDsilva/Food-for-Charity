package com.foodforcharity.app.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the ERROR_LOG database table.
 */
@Data
@Entity
@Table(name = "ERROR_LOG")
public class ErrorLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DESCRIPTION_TEXT")
    @NotNull
    private String descriptionText;

    @Column(name = "ERROR_TIME")
    @NotNull
    private Date errorTime;

}