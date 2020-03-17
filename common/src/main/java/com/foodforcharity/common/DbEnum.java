package com.foodforcharity.common;

public class DbEnum {

    static public enum DoneeType implements DbEnumeration<DoneeType> {
        Individual(1), Organization(2);

        private final int value;

        private DoneeType(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    // static public enum Allergen implements DbEnumeration<Allergen> {
    //     Dairy(1), Nuts(2), Seafood(3), Wheat(4), Soybeans(5), Gluten(6);

    //     private final int value;

    //     private Allergen(final int value) {
    //         this.value = value;
    //     }

    //     public int getvalue() {
    //         return value;
    //     }

    // }

    // static public enum Cuisine implements DbEnumeration<Cuisine> {
    //     Italian(1), Chinese(2), Indian(3), Thai(4), Mongolian(5), Japanese(6), Arab(7), French(8), Spanish(9), Mexican(10), Indonasian(11), Philapino(12), Greek(13), Portugal(14), Hawaain(15), Brazilian(16), Vietnam(17), Turkish(18), Belgravian(19), NoPreference(20);

    //     private final int value;

    //     private Cuisine(final int value) {
    //         this.value = value;
    //     }

    //     public int getvalue() {
    //         return value;
    //     }

    // }

    // static public enum MealType implements DbEnumeration<MealType> {
    //     Vegan(1), Vegetratian(2), Chicken(3), Seafood(4), RedMeat(5);

    //     private final int value;

    //     private MealType(final int value) {
    //         this.value = value;
    //     }

    //     public int getvalue() {
    //         return value;
    //     }

    // }

    static public enum SpiceLevel implements DbEnumeration<SpiceLevel> {
        NoSpice(1), MildSpice(2), MediumSpice(3), Hot(4), ExtraHot(5);

        private final int value;

        private SpiceLevel(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    private DbEnum(){};

}