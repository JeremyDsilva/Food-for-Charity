package com.foodforcharity.api.entities;
import javax.persistence.*;


@Entity
@Table(name="b00074902.MapDoneeAllergen")
public class MapDoneeAllergen {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy="DoneeId")
    Donor donor;

    @OneToOne(mappedBy="AllergenId")
    Allergen allergen;

    // CONSTRAINT fk_MapDoneeAllergen_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id);
    // CONSTRAINT fk_MapDoneeAllergen_AllergenId FOREIGN KEY(AllergenId) REFERENCES b00074902.Allergen(Id)
}

