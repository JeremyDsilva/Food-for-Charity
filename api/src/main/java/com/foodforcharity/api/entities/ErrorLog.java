package com.foodforcharity.api.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ErrorLog", schema = "b00074902")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "DescriptionText")
    String descriptionText;

    @Column(name = "ErrorTime")
    Date errorTime;

}
