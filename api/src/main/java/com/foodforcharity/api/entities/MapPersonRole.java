package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapPersonRole")
public class MapPersonRole {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "PersonId")
    Person person;

    @OneToOne(mappedBy = "RoleId")
    PersonRole userRole;

    // CONSTRAINT fk_MapPersonRole_PersonId FOREIGN KEY(PersonId) REFERENCES b00074902.Person(Id);
    // CONSTRAINT fk_MapPersonRole_RoleId FOREIGN KEY(RoleId) REFERENCES b00074902.PersonRole(Id)
}

