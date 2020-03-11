package com.foodforcharity.common;

public class Enum {

    static public enum PersonRole {
        Broker(1), Donee(2), Donor(3);

        private final int value;

        private PersonRole(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    static public enum DonorStatus {
        Initial(1, false), Active(2, true), Inactive(3, true), Suspended(3, true);

        private final int value;
        private final boolean _hasAccess;

        private DonorStatus(final int value, final boolean hasAccess) {
            this.value = value;
            this._hasAccess = hasAccess;
        }

        public int getvalue() {
            return value;
        }

        public boolean hasAccess() {
            return _hasAccess;
        }

    }

    static public enum DoneeStatus {
        Initial(1, false), Active(2, true), Suspended(3, true);

        private final int value;
        private final boolean _hasAccess;

        private DoneeStatus(int value, boolean hasAccess) {
            this.value = value;
            this._hasAccess = hasAccess;
        }

        public int getvalue() {
            return value;
        }

        public boolean hasAccess() {
            return _hasAccess;
        }

    }

    static public enum DoneeType {
        Individual(1), Organization(2);

        private final int value;

        private DoneeType(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    static public enum Allergen {
        Dairy(1), Nuts(2), Seafood(3), Wheat(4), Soybeans(5), Gluten(6);

        private final int value;

        private Allergen(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    static public enum Cuisine {
        Italian(1), Chinese(2), Indian(3), Thai(4), Mongolian(5), Japanese(6), Arab(7), French(8), Spanish(9), Mexican(10), Indonasian(11), Philapino(12), Greek(13), Portugal(14), Hawaain(15), Brazilian(16), Vietnam(17), Turkish(18), Belgravian(19), NoPreference(20);

        private final int value;

        private Cuisine(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    static public enum MealType {
        Vegan(1), Vegetratian(2), Chicken(3), Seafood(4), RedMeat(5);

        private final int value;

        private MealType(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    static public enum SpiceLevel {
        NoSpice(1), MildSpice(2), MediumSpice(3), Hot(4), ExtraHot(5);

        private final int value;

        private SpiceLevel(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    private Enum(){};

}