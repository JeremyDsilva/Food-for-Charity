package com.foodforcharity.app.usecase.profile.selectpreferences;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class SelectPreferencesCommand implements Command<Response<Void>> {
    long doneeId;
    Range<SpiceLevel>spiceRange;
    List<Allergen> allergens;
    Range<Integer> priceRange;
    List<Cuisine> cuisines;
    List<MealType> mealTypes;

    // public SelectPreferencesCommand() {

    // }

    @Value
    public class Range<T> {
        T start;
        T stop;

        // public Range(T start, T stop) {
        //     this.start = start;
        //     this.stop = stop;
        // }

    }

    // /**
    //  * Public Constructor
    //  *
    //  * @param doneeId
    //  * @param spiceRange
    //  * @param allergens
    //  * @param priceRange
    //  * @param cuisines
    //  * @param mealTypes
    //  */

    // public SelectPreferencesCommand(long doneeId) {
    //     this.doneeId = doneeId;
    //     this.spiceRange = Optional.empty();
    //     this.allergens = Optional.empty();
    //     this.priceRange = Optional.empty();
    //     this.cuisines = Optional.empty();
    //     this.mealTypes = Optional.empty();
    // }

    // /**
    //  * @param spiceRange
    //  */
    // public void setSpiceRange(Range<SpiceLevel> spiceRange) {
    //     this.spiceRange = Optional.of(spiceRange);
    // }

    // /**
    //  * @param allergens
    //  */
    // public void setAllergens(List<Allergen> allergens) {
    //     this.allergens = Optional.of(allergens);
    // }

    // /**
    //  * @param priceRange
    //  */
    // public void setPriceRange(Range<Integer> priceRange) {
    //     this.priceRange = Optional.of(priceRange);
    // }

    // /**
    //  * @param cuisines
    //  */
    // public void setCuisines(List<Cuisine> cuisines) {
    //     this.cuisines = Optional.of(cuisines);
    // }

    // /**
    //  * @param mealTypes
    //  */
    // public void setMealTypes(List<MealType> mealTypes) {
    //     this.mealTypes = Optional.of(mealTypes);
    // }
}