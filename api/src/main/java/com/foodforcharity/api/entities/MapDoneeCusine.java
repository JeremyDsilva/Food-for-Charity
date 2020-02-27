package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapDoneeCusine")
public class MapDoneeCusine {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="DoneeId")
    Donor donor;
    
    @OneToOne(mappedBy = "CusineId")
    Cusine cusine;

    // CONSTRAINT fk_MapDoneeCusine_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id);
    // CONSTRAINT fk_MapDoneeCusine_CusineId FOREIGN KEY(CusineId) REFERENCES b00074902.Cusine(Id)
}

