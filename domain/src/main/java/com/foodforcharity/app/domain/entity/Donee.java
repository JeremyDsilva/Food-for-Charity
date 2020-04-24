package com.foodforcharity.app.domain.entity;

import com.foodforcharity.app.domain.constant.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The persistent class for the DONEE database table.
 */
@Data
@Entity
@DiscriminatorValue("Donee")
public class Donee extends Person {
    private static final long serialVersionUID = 1L;

    @Column(name = "ADDRESS_DESCRIPTION")
    @NotNull
    private String addressDescription;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @Column(name = "DONEE_NAME")
    @NotNull
    private String doneeName;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Column(name = "MEMBER_COUNT")
    @NotNull
    private Integer memberCount;

    @Column(name = "PHONE_NUMBER")
    @NotNull
    private String phoneNumber;

    @Column(name = "QUANTITY_REQUESTED")
    @NotNull
    private Integer quantityRequested;

    @JoinColumn(name = "DONEE_STATUS")
    @Enumerated(EnumType.STRING)
    @NotNull
    private DoneeStatus doneeStatus;

    @JoinColumn(name = "DONEE_TYPE")
    @Enumerated(EnumType.STRING)
    @NotNull
    private DoneeType doneeType;

    // bi-directional many-to-one association to DoneePriceRange
    @OneToOne(mappedBy = "donee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DoneePriceRange priceRange;

    // bi-directional many-to-one association to DoneeSpiceRange
    @OneToOne(mappedBy = "donee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DoneeSpiceRange spiceRange;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Allergen.class)
    private Set<Allergen> allergens;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Cuisine.class)
    private Set<Cuisine> cuisines;

    // bi-directional many-to-one association to MapDoneeMealType
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = MealType.class)
    private Set<MealType> mealTypes;

    // bi-directional many-to-one association to Request
    @OneToMany(mappedBy = "donee", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Request> requests;

    public Request addRequest(Request request) {
        getRequests().add(request);
        request.setDonee(this);

        return request;
    }

    public void removeRequest(Request request) {
        getRequests().remove(request);
    }


    public Optional<String> getStatus() {
        return Optional.of(doneeStatus.name());
    }

    /**
     * @param allergen
     * @return
     * @see java.util.Set#add(java.lang.Object)
     */

    public boolean addAllergen(Allergen allergen) {
        return allergens.add(allergen);
    }

    /**
     * @param allergen
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */

    public boolean removeAllergen(Allergen allergen) {
        return allergens.remove(allergen);
    }

    /**
     * @param cuisine
     * @return
     * @see java.util.Set#add(java.lang.Object)
     */

    public boolean addCuisine(Cuisine cuisine) {
        return cuisines.add(cuisine);
    }


    /**
     * @param cuisine
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */

    public boolean removeCuisine(Cuisine cuisine) {
        return cuisines.remove(cuisine);
    }

    /**
     * @param mealType
     * @return
     * @see java.util.Set#add(java.lang.Object)
     */

    public boolean addMealType(MealType mealType) {
        return mealTypes.add(mealType);
    }


    /**
     * @param mealType
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */

    public boolean removeCuisine(MealType mealType) {
        return mealTypes.remove(mealType);
    }

}