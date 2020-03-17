----------------------------   Person Role   ----------------------------

INSERT INTO "B00074902"."PERSON_ROLE" (NAME) VALUES ('Broker');
INSERT INTO "B00074902"."PERSON_ROLE" (NAME) VALUES ('Donor');
INSERT INTO "B00074902"."PERSON_ROLE" (NAME) VALUES ('Donee');

----------------------------   Authority   ----------------------------

INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('Broker');
INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('Donor');
INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('Donee');
INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('CreateRequest');
INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('MakeFoodAvailable');
INSERT INTO "B00074902"."AUTHORITY" (Authority) VALUES ('NoAuthority');

----------------------------   Donor Status   ----------------------------

INSERT INTO "B00074902"."DONOR_STATUS" (NAME, Authority_Id) VALUES ('Initial', 2);
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, Authority_Id) VALUES ('Active', 5);
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, Authority_Id) VALUES ('Inactive', 5);
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, Authority_Id) VALUES ('Suspended', 6);

----------------------------   Donee Status   ----------------------------

INSERT INTO "B00074902"."DONEE_STATUS" (NAME, Authority_Id) VALUES ('Initial', 3);
INSERT INTO "B00074902"."DONEE_STATUS" (NAME, Authority_Id) VALUES ('Active', 4);
INSERT INTO "B00074902"."DONEE_STATUS" (NAME, Authority_Id) VALUES ('Suspended', 6);

----------------------------   DoneeType   ----------------------------

INSERT INTO "B00074902"."DONEE_TYPE" (NAME) VALUES ('Indivisual');
INSERT INTO "B00074902"."DONEE_TYPE" (NAME) VALUES ('Organization');

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