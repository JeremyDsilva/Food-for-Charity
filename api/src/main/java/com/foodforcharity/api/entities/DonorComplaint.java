package com.foodforcharity.api.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="b00074902.DonorComplaint")
public class DonorComplaint {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "DonerId")
    Donor donor;
    
    @OneToOne(mappedBy = "DoneeId")
    Donee donee;

    @Column(name = "DescriptionText")
    String descriptionText  ;

    @Column(name = "ComplaintTime")
    Date complaintTime;
    
    @Column(name = "IsActive")
    char isActive;

    // CONSTRAINT fk_DonorComplaint_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id);
    // CONSTRAINT fk_DonorComplaint_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id)
}

