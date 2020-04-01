----------------------------   Person Role   ----------------------------

INSERT INTO "B00074902"."PERSON_ROLE" (ID) VALUES ('Broker');
INSERT INTO "B00074902"."PERSON_ROLE" (ID) VALUES ('Donor');
INSERT INTO "B00074902"."PERSON_ROLE" (ID) VALUES ('Donee');

----------------------------   Donor Status   ----------------------------

INSERT INTO "B00074902"."DONOR_STATUS" (ID) VALUES ('Initial');
INSERT INTO "B00074902"."DONOR_STATUS" (ID) VALUES ('Active');
INSERT INTO "B00074902"."DONOR_STATUS" (ID) VALUES ('Inactive');
INSERT INTO "B00074902"."DONOR_STATUS" (ID) VALUES ('Suspended');

----------------------------   Donee Status   ----------------------------

INSERT INTO "B00074902"."DONEE_STATUS" (ID) VALUES ('Initial');
INSERT INTO "B00074902"."DONEE_STATUS" (ID) VALUES ('Active');
INSERT INTO "B00074902"."DONEE_STATUS" (ID) VALUES ('Suspended');

----------------------------   DoneeType   ----------------------------

INSERT INTO "B00074902"."DONEE_TYPE" (ID) VALUES ('Individual');
INSERT INTO "B00074902"."DONEE_TYPE" (ID) VALUES ('Organization');

----------------------------   Spice Level   ----------------------------

INSERT INTO "B00074902"."SPICE_LEVEL" (ID) VALUES ('No_Spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (ID) VALUES ('Mild_Spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (ID) VALUES ('Medium_Spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (ID) VALUES ('Hot');
INSERT INTO "B00074902"."SPICE_LEVEL" (ID) VALUES ('Extra_Hot');

----------------------------   Cuisine   ----------------------------

INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Italian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Chinese');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Indian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Thai');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Mongolian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Japanese');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Arab');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('French');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Spanish');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Mexican');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Indonasian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Philapino');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Greek');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Portugal');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Hawaain');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Brazilian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Vietnam');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Turkish');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('Belgravian');
INSERT INTO "B00074902"."CUISINE" (ID) VALUES ('NoPreference');

----------------------------   Allergen Table   ----------------------------

INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('Dairy');
INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('Nuts');
INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('SeaFood');
INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('Wheat');
INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('Soybeans');
INSERT INTO "B00074902"."ALLERGEN" (ID) VALUES('Glutten');

----------------------------   Meal Type   ----------------------------

INSERT INTO "B00074902"."MEAL_TYPE" (ID) VALUES ('Vegan');
INSERT INTO "B00074902"."MEAL_TYPE" (ID) VALUES ('Vegetarian');
INSERT INTO "B00074902"."MEAL_TYPE" (ID) VALUES ('Chicken');
INSERT INTO "B00074902"."MEAL_TYPE" (ID) VALUES ('Seafood');
INSERT INTO "B00074902"."MEAL_TYPE" (ID) VALUES ('RedMeat');

-----------------------------------------------------------------------