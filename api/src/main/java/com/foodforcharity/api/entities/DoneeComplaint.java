package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="b00074902.DoneeComplaint")
public class DoneeComplaint {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "DoneeId")
    Donee donee;

    @OneToOne(mappedBy = "DonerId")
    Donor donor;

    @Column(name = "DescriptionText")
    String descriptionText;

    @Column(name = "ComplaintTime")
    Date complaintTime;

    @Column(name = "IsActive")
    char IsActive;

    // CONSTRAINT fk_DoneeComplaint_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id);
    // CONSTRAINT fk_DoneeComplaint_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id)
}

