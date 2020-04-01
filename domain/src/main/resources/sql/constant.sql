----------------------------   Person Role   ----------------------------

INSERT INTO "B00074902"."PERSON_ROLE" (Name) VALUES ('Broker');
INSERT INTO "B00074902"."PERSON_ROLE" (Name) VALUES ('Donor');
INSERT INTO "B00074902"."PERSON_ROLE" (Name) VALUES ('Donee');

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

INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Italian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Chinese');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Indian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Thai');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Mongolian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Japanese');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Arab');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('French');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Spanish');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Mexican');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Indonasian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Philapino');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Greek');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Portugal');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Hawaain');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Brazilian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Vietnam');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Turkish');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('Belgravian');
INSERT INTO "B00074902"."CUISINE" (Name) VALUES ('NoPreference');

----------------------------   Allergen Table   ----------------------------

INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('Dairy');
INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('Nuts');
INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('SeaFood');
INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('Wheat');
INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('Soybeans');
INSERT INTO "B00074902"."ALLERGEN" (Name) VALUES('Glutten');

----------------------------   Meal Type   ----------------------------

INSERT INTO "B00074902"."MEAL_TYPE" (Name) VALUES ('Vegan');
INSERT INTO "B00074902"."MEAL_TYPE" (Name) VALUES ('Vegetarian');
INSERT INTO "B00074902"."MEAL_TYPE" (Name) VALUES ('Chicken');
INSERT INTO "B00074902"."MEAL_TYPE" (Name) VALUES ('Seafood');
INSERT INTO "B00074902"."MEAL_TYPE" (Name) VALUES ('RedMeat');

-----------------------------------------------------------------------