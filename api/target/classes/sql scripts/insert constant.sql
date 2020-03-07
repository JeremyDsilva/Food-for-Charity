----------------------------   Person Role   ----------------------------

INSERT INTO "B00074902"."PERSON_ROLE" (ID, NAME) VALUES ('1', 'Broker');
INSERT INTO "B00074902"."PERSON_ROLE" (ID, NAME) VALUES ('2', 'Donor');
INSERT INTO "B00074902"."PERSON_ROLE" (ID, NAME) VALUES ('3', 'Donee');

----------------------------   Donor Status   ----------------------------

INSERT INTO "B00074902"."DONOR_STATUS" (NAME, HAS_ACCESS) VALUES ('Initial', 'N');
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, HAS_ACCESS) VALUES ('Active', 'Y');
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, HAS_ACCESS) VALUES ('Inactive', 'Y');
INSERT INTO "B00074902"."DONOR_STATUS" (NAME, HAS_ACCESS) VALUES ('Suspended', 'N');

----------------------------   Donee Status   ----------------------------

INSERT INTO "B00074902"."DONEE_STATUS" (ID, NAME, HAS_ACCESS) VALUES ('Initial', 'N');
INSERT INTO "B00074902"."DONEE_STATUS" (ID, NAME, HAS_ACCESS) VALUES ('Active', 'Y');
INSERT INTO "B00074902"."DONEE_STATUS" (ID, NAME, HAS_ACCESS) VALUES ('Suspended', 'N');

----------------------------   DoneeType   ----------------------------

INSERT INTO "B00074902"."DONEE_TYPE" (NAME) VALUES ('Indivisual');
INSERT INTO "B00074902"."DONEE_TYPE" (NAME) VALUES ('Organization');

----------------------------   Spice Level   ----------------------------

INSERT INTO "B00074902"."SPICE_LEVEL" (NAME) VALUES ('No spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (NAME) VALUES ('Mild Spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (NAME) VALUES ('Medium Spice');
INSERT INTO "B00074902"."SPICE_LEVEL" (NAME) VALUES ('Hot');
INSERT INTO "B00074902"."SPICE_LEVEL" (NAME) VALUES ('Extra Hot');

----------------------------   Cuisine   ----------------------------

INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Italian');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Chinese');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Indian');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Thai');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Mongolian');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Japanese');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Arab');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('French');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Spanish');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Mexican');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Indonasian');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Philapino');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Greek');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Portugal');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Hawaain');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Brazilian');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Vietnam');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Turkish');
INSERT INTO "B00074902"."CUISINE" (ID, NAME) VALUES ('Belgravian');


----------------------------   Allergen Table   ----------------------------

INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Dairy');
INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Nuts');
INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Sea food');
INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Wheat');
INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Soybeans');
INSERT INTO "B00074902"."ALLERGEN" (name) VALUES('Glutten');

----------------------------   Meal Type   ----------------------------

INSERT INTO "B00074902"."MEAL_TYPE" (ID, NAME) VALUES ('1', 'vegan');
INSERT INTO "B00074902"."MEAL_TYPE" (ID, NAME) VALUES ('2', 'chicken');
INSERT INTO "B00074902"."MEAL_TYPE" (ID, NAME) VALUES ('3', 'vegetarian');
INSERT INTO "B00074902"."MEAL_TYPE" (ID, NAME) VALUES ('4', 'seafood');
INSERT INTO "B00074902"."MEAL_TYPE" (ID, NAME) VALUES ('5', 'red meat');

-----------------------------------------------------------------------