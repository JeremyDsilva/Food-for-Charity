package com.foodforcharity.api.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "b00074902.Person")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "UserName")
    String userName;

    @Column(name = "PasswordHash")
    String passwordHash;

    @Column(name = "PasswordSalt")
    String passwordSalt;

    @Column(name = "LastLoginTime")
    Date LastLoginTime;

}
