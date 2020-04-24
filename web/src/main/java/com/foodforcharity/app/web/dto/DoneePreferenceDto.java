package com.foodforcharity.app.web.dto;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.DoneePriceRange;
import com.foodforcharity.app.domain.entity.DoneeSpiceRange;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class DoneePreferenceDto {

    private PriceRange priceRange;

    private SpiceRange spiceRange;

    private Set<Allergen> allergens;

    private Set<Cuisine> cuisines;

    private Set<MealType> mealTypes;

    public DoneePreferenceDto(Donee donee) {
        this.allergens = donee.getAllergens();
        this.cuisines = donee.getCuisines();
        this.mealTypes = donee.getMealTypes();
        this.priceRange = new PriceRange(donee.getPriceRange());
        this.spiceRange = new SpiceRange(donee.getSpiceRange());
    }

    @Data
    public class PriceRange {

        @NotNull
        private Integer endPrice;

        @NotNull
        private Integer startPrice;

        public PriceRange(DoneePriceRange priceRange) {
            this.startPrice = priceRange.getStartPrice();
            this.endPrice = priceRange.getEndPrice();
        }

    }

    @Data
    public class SpiceRange {

        @NotNull
        private SpiceLevel startLevel;

        @NotNull
        private SpiceLevel endLevel;

        public SpiceRange(DoneeSpiceRange spiceRange) {
            this.startLevel = spiceRange.getStartLevel();
            this.endLevel = spiceRange.getEndLevel();
        }

    }

}