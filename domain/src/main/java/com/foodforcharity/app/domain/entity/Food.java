package com.foodforcharity.app.domain.entity;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the FOOD database table.
 */
@Data
@Entity
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DESCRIPTION_TEXT")
    @NotNull
    private String descriptionText;

    @Column(name = "FOOD_NAME")
    @NotNull
    private String foodName;

    @Column(name = "MEAL_FOR_N_PEOPLE")
    @NotNull
    private Integer mealForNPeople;

    @NotNull
    private Integer price;

    @Column(name = "QUANTITY_AVAILABLE")
    @NotNull
    private Integer quantityAvailable;

    // bi-directional many-to-one association to Donor
    @ManyToOne
    @NotNull
    private Donor donor;

    // bi-directional many-to-one association to SpiceLevel
    @JoinColumn(name = "SPICE_LEVEL")
    @Enumerated(EnumType.STRING)
    private SpiceLevel spiceLevel;

    // bi-directional many-to-one association to MapFoodAllergen
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Allergen.class)
    private Set<Allergen> allergens;

    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    // bi-directional many-to-one association to MapDoneeMealType
    @Enumerated(EnumType.STRING)
    @NotNull
    private MealType mealType;

    // bi-directional many-to-one association to SubRequest
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<SubRequest> subRequests;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Food && ((Food) obj).getId() == getId())
            return true;
        return false;
    }

    @PreRemove
    public void preRemove() {
        donor.removeFood(this);
    }


}