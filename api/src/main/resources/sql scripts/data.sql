-----------------------------------------------------------------  Person  -----------------------------------------------------------------  
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('1', 'AnnitaRosinski', 'fbd0c71db0af10a9b60549bded720c06', '12079314335e5a3589d5585', TO_TIMESTAMP('2020-02-19 12:59:39.430000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('2', 'CamilaRawls', 'd9e4d9f25ddb19b1fa85efc77d77431f', '16788250185e5a3589d55c3', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('3', 'PetraOlds', '9a48bebbdfccae929b7844b9f8a3f469', '4305116105e5a3589d55fe', TO_TIMESTAMP('2020-02-12 12:59:46.677000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('4', 'GeorgettaDopp', '871f0688f4e886d15f1cb2c03fd7cb47', '116288065e5a3589d5638', TO_TIMESTAMP('2020-02-19 12:59:39.430000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('5', 'JeniseLongerbeam', '6d02149960798054d608148c357588f4', '16676126715e5a3589d5672', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('21', 'LucreciaSchieber', '19ba13a7e9ac2d876b337230dce74b66', '16702204125e5a3589d5a12', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('22', 'MN - El Pollo Rico #10', 'ed2b708fbb932cb9921cdabc16f2e3d0', '7925495785e5a3589d5a4b', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('23', 'Yager Food Store', 'd9cebea78b025029ee5be7305212b6df', '12774051815e5a3589d5a85', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('24', 'Verdes Grill', '55b09d426e89ec6bcf39763a55f523e7', '9304625765e5a3589d5ac0', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));
INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('25', 'Sonic', '839954a155a2757591372168f63c4fd6', '359436635e5a3589d5afa', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO "B00074902"."PERSON" (ID, USERNAME, PASSWORD_HASH, PASSWORD_SALT, LAST_LOGIN_TIME) VALUES ('30', 'Jeremy', '839954a155a2757591372168f63c4fd6', '359436635e5a3589d5afa', TO_TIMESTAMP('2020-02-03 12:59:20.202000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

-----------------------------------------------------------------  Map Person Role -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('2', '3');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('3', '3');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('4', '3');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('5', '3');

INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('21', '2');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('22', '2');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('23', '2');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('24', '2');
INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('25', '2');

INSERT INTO "B00074902"."MAP_PERSON_ROLE" (PERSON_ID, ROLE_ID) VALUES ('30', '1');

-------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------  Broker  -----------------------------------------------------------------

INSERT INTO "B00074902"."BROKER" (PERSON_ID) VALUES ('30');

-------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------  Donee  -----------------------------------------------------------------  

INSERT INTO "B00074902"."DONEE" (ID, DONEE_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, DONEE_STATUS_ID, DONEE_TYPE_ID, MEMBER_COUNT, QUANTITY_REQUESTED, PERSON_ID) VALUES ('1', 'Annita Rosinski', '(691) 696-7074', 'slanglois@verizon.net', 'Windbeach, Jackson Street', 'Pascoag', 'Quatar', '1', '1', '47', '52', '1');
INSERT INTO "B00074902"."DONEE" (ID, DONEE_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, DONEE_STATUS_ID, DONEE_TYPE_ID, MEMBER_COUNT, QUANTITY_REQUESTED, PERSON_ID) VALUES ('2', 'Camila Rawls', '(969) 597-6979', 'jimxugle@verizon.net', 'Faywater, Lincoln Street', 'El Portal', 'UAE', '2', '2', '71', '9', '2');
INSERT INTO "B00074902"."DONEE" (ID, DONEE_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, DONEE_STATUS_ID, DONEE_TYPE_ID, MEMBER_COUNT, QUANTITY_REQUESTED, PERSON_ID) VALUES ('3', 'Petra Olds', '(648) 446-8603', 'quinn@gmail.com', 'Ashhedge, York Street', 'Red Mills', 'UAE', '1', '2', '91', '23', '3');
INSERT INTO "B00074902"."DONEE" (ID, DONEE_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, DONEE_STATUS_ID, DONEE_TYPE_ID, MEMBER_COUNT, QUANTITY_REQUESTED, PERSON_ID) VALUES ('4', 'Georgetta Dopp', '(963) 381-7121', 'monopole@outlook.com', 'Beechley, Cypress Court', 'Little Ferry', 'Bahrain', '2', '1', '88', '49', '4');
INSERT INTO "B00074902"."DONEE" (ID, DONEE_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, DONEE_STATUS_ID, DONEE_TYPE_ID, MEMBER_COUNT, QUANTITY_REQUESTED, PERSON_ID) VALUES ('5', 'Jenise Longerbeam', '(457) 346-9130', 'bruck@mac.com', 'Fallbarrow, Mulberry Lane', 'Lost Creek', 'SaudiArabia', '2', '1', '38', '80', '5');

-----------------------------------------------------------------  Donee Spice Range  -----------------------------------------------------------------  

INSERT INTO "B00074902"."DONEE_SPICE_RANGE" (ID, DONEE_ID, START_LEVEL, END_LEVEL) VALUES ('1', '1', '3', '3');
INSERT INTO "B00074902"."DONEE_SPICE_RANGE" (ID, DONEE_ID, START_LEVEL, END_LEVEL) VALUES ('2', '2', '3', '3');
INSERT INTO "B00074902"."DONEE_SPICE_RANGE" (ID, DONEE_ID, START_LEVEL, END_LEVEL) VALUES ('3', '3', '3', '3');
INSERT INTO "B00074902"."DONEE_SPICE_RANGE" (ID, DONEE_ID, START_LEVEL, END_LEVEL) VALUES ('4', '4', '3', '4');
INSERT INTO "B00074902"."DONEE_SPICE_RANGE" (ID, DONEE_ID, START_LEVEL, END_LEVEL) VALUES ('5', '5', '1', '3');

-----------------------------------------------------------------  Donee Price Range  -----------------------------------------------------------------

INSERT INTO "B00074902"."DONEE_PRICE_RANGE" (ID, DONEE_ID, START_PRICE, END_PRICE) VALUES ('1', '1', '65.63', '92.96');
INSERT INTO "B00074902"."DONEE_PRICE_RANGE" (ID, DONEE_ID, START_PRICE, END_PRICE) VALUES ('2', '2', '59.23', '92.03');
INSERT INTO "B00074902"."DONEE_PRICE_RANGE" (ID, DONEE_ID, START_PRICE, END_PRICE) VALUES ('3', '3', '55.21', '91.82');
INSERT INTO "B00074902"."DONEE_PRICE_RANGE" (ID, DONEE_ID, START_PRICE, END_PRICE) VALUES ('4', '4', '69.56', '94.96');
INSERT INTO "B00074902"."DONEE_PRICE_RANGE" (ID, DONEE_ID, START_PRICE, END_PRICE) VALUES ('5', '5', '55.64', '75.03');

-----------------------------------------------------------------  Map Donee Allergen  -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('1', '1');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('3', '4');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('4', '1');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('4', '3');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('4', '6');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('4', '5');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('5', '6');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('5', '5');
INSERT INTO "B00074902"."MAP_DONEE_ALLERGEN" (DONEE_ID, ALLERGEN_ID) VALUES ('5', '2');

-----------------------------------------------------------------  Map Donee MealType  -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('1', '1');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('1', '5');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('2', '5');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('3', '1');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('3', '2');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('3', '3');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('4', '5');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('4', '4');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('4', '1');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('5', '4');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('5', '5');
INSERT INTO "B00074902"."MAP_DONEE_MEAL_TYPE" (DONEE_ID, MEAL_TYPE_ID) VALUES ('5', '2');

-----------------------------------------------------------------  Map Donee Cuisine  -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('1', '8');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('1', '12');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('1', '4');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('1', '17');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('2', '15');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('2', '11');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('2', '14');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('3', '8');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('3', '2');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('3', '14');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('3', '3');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('4', '7');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('4', '8');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('5', '11');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('5', '19');
INSERT INTO "B00074902"."MAP_DONEE_CUISINE" (DONEE_ID, CUISINE_ID) VALUES ('5', '2');

-------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------  Donor  -----------------------------------------------------------------  

INSERT INTO "B00074902"."DONOR" (ID, DONOR_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, RATING, NUMBER_OF_RATING, DONOR_STATUS_ID, PERSON_ID) VALUES ('1', 'Quick & Go', '(691) 696-7074', 'zeller@me.com', 'Bylyn , Clay Street', 'Red Mills', 'Oman', '5', '3', '4', '21');
INSERT INTO "B00074902"."DONOR" (ID, DONOR_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, RATING, NUMBER_OF_RATING, DONOR_STATUS_ID, PERSON_ID) VALUES ('2', 'MN - El Pollo Rico #10', '(969) 597-6979', 'fairbank@mac.com', 'Bybeech , Hawthorne Avenue', 'Little Ferry', 'Bahrain', '0', '3', '4', '22');
INSERT INTO "B00074902"."DONOR" (ID, DONOR_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, RATING, NUMBER_OF_RATING, DONOR_STATUS_ID, PERSON_ID) VALUES ('3', 'Yager Food Store', '(648) 446-8603', 'tbmaddux@optonline.net', 'Valbeach , Highland Avenue', 'Lost Creek', 'Oman', '2', '2', '4', '23');
INSERT INTO "B00074902"."DONOR" (ID, DONOR_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, RATING, NUMBER_OF_RATING, DONOR_STATUS_ID, PERSON_ID) VALUES ('4', 'Verdes Grill', '(963) 381-7121', 'treeves@msn.com', 'Beachbourne , State Street', 'Webbers Falls', 'UAE', '5', '2', '4', '24');
INSERT INTO "B00074902"."DONOR" (ID, DONOR_NAME, PHONE_NUMBER, EMAIL, ADDRESS_DESCRIPTION, CITY, COUNTRY, RATING, NUMBER_OF_RATING, DONOR_STATUS_ID, PERSON_ID) VALUES ('5', 'Sonic', '(457) 346-9130', 'nichoj@msn.com', 'Spellmont , Atlantic Avenue', 'Brave', 'Bahrain', '2', '4', '3', '25');

-----------------------------------------------------------------  Food Table  -----------------------------------------------------------------

INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('1', 'Consomme printaniere', 'Dried Prunes,Water,Corn Syrup,Sugar,Pectin', '23.96', '1', '58', '1', '1');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('2', 'Chicken gumbo', 'Dried Prunes,Water,Corn Syrup,Sugar,Pectin', '18.87', '1', '57', '4', '1');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('3', 'Tomato aux croutons', 'Salt,Sugar,Molasses (Refinery Syrup, Molas', '48.72', '2', '43', '3', '1');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('4', 'Onion au gratin', 'Salt, Yellow 5 Lake, Tricalcium Phosphate ', '24.35', '4', '32', '2', '1');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('5', 'St. Emilion', 'Mechanically hulled seasame seeds.Allergy ', '65.46', '1', '71', '1', '1');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('6', 'Radishes', 'FALSE', '50.31', '2', '39', '2', '2');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('7', 'Chicken soup with ri', 'Red Raspberries,Sugar,Glucose Syrup,Citric', '36.22', '3', '42', '3', '2');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('8', 'Clam broth (cup)', 'Noodles: wheat flour,water,wheat gluten,mo', '19.26', '4', '68', '2', '2');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('9', 'Cream of new asparag', 'Wheat Flour,Soybean Oil,Salt,Dehydrated Ga', '97.86', '2', '53', '3', '2');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('10', 'Clear green turtle', 'Rolled Oats,Brown Rice Syrup,Evaporated Ca', '49.68', '2', '54', '4', '2');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('11', 'Striped bass saute, ', 'Skim Milk,Sugar,Corn Syrup,Canola Oil,High', '8.98', '2', '58', '2', '3');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('12', 'Anchovies', 'Filtered Water,Whole Organic Soybeans,Orga', '96.49', '1', '58', '3', '3');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('13', 'Fresh lobsters in ev', 'Filtered Water,Whole Organic Soybeans,Orga', '83.15', '2', '36', '4', '3');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('14', 'Celery', 'Almondmilk (Filtered Water, Almonds),Evapo', '50.43', '3', '71', '3', '3');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('15', 'Pim-olas', 'Enriched Flour (Wheat Flour, Malted Barley', '33.24', '4', '45', '4', '3');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('16', 'Caviar', 'Anise Seed Used mainly to add flavor to co', '9.56', '4', '64', '2', '4');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('17', 'Sardines', 'Garlic Powder. 1/4 teaspoon garlic powder ', '83.6', '3', '30', '1', '4');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('18', 'India chutney', 'Sugar,Corn Syrup,Gelatin,Citric Acid,Lacti', '30.32', '3', '74', '3', '4');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('19', 'Pickles', 'CORN,PARTIALLY HYDROGENATED SOYBEAN AND/OR', '19.07', '1', '66', '1', '4');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('20', 'English walnuts', 'Pistachios,Almonds,Cashews,Peanut and/or C', '38.94', '2', '46', '2', '4');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('21', 'Pate de foies-gras', 'Cooked Enriched Pasta (Water, Elbow Macaro', '99.77', '2', '44', '3', '5');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('22', 'Pomard', 'Cumin Ground', '59.91', '4', '73', '4', '5');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('23', 'Brook trout, mountai', 'Rolled Oats*,Cane Sugar*,Soy Oil*,Dried Co', '35.74', '4', '66', '2', '5');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('24', 'Whitebait, sauce tar', 'Garlic Powder', '62.9', '4', '64', '4', '5');
INSERT INTO "B00074902"."FOOD" (ID, FOOD_NAME, DESCRIPTION_TEXT, PRICE, MEAL_FOR_N_PEOPLE, QUANTITY_AVAILABLE, SPICE_LEVEL, DONOR_ID) VALUES ('25', 'Clams', 'Sugar,Brown Sugar,Natural Flavor,Caramel C', '18.35', '2', '39', '1', '5');

----------------------------------------------------------------- Map Food MealType  -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('2', '2');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('3', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('4', '2');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('5', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('6', '5');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('7', '5');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('8', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('9', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('10', '4');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('11', '5');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('12', '2');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('13', '5');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('14', '1');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('15', '1');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('16', '5');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('17', '4');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('18', '1');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('19', '2');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('20', '4');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('21', '3');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('22', '1');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('23', '4');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('24', '1');
INSERT INTO "B00074902"."MAP_FOOD_MEAL_TYPE" (FOOD_ID, MEAL_TYPE_ID) VALUES ('25', '2');

-----------------------------------------------------------------  Map Food Cuisine  -----------------------------------------------------------------

INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('2', '19');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('3', '10');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('4', '1');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('5', '5');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('6', '18');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('7', '11');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('8', '9');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('9', '2');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('10', '2');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('11', '10');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('12', '2');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('13', '5');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('14', '6');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('15', '4');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('16', '9');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('17', '1');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('18', '7');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('19', '18');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('20', '1');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('21', '11');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('22', '14');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('23', '17');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('24', '2');
INSERT INTO "B00074902"."MAP_FOOD_CUISINE" (FOOD_ID, CUISINE_ID) VALUES ('25', '3');

------------------------------------------------------------------  Map Food Allergen  -----------------------------------------------------------------  

INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('1', '3');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('1', '6');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('2', '5');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('3', '1');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('3', '2');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('3', '3');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('4', '1');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('4', '5');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('6', '6');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('7', '6');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('8', '3');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('8', '6');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('9', '4');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('9', '5');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('10', '5');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('11', '3');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('12', '1');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('13', '1');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('14', '3');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('15', '4');
INSERT INTO "B00074902"."MAP_FOOD_ALLERGEN" (FOOD_ID, ALLERGEN_ID) VALUES ('16', '2');

---------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------  Request  -----------------------------------------------------------------
INSERT INTO "B00074902"."REQUEST" (ID, DONOR_ID, DONEE_ID, FINAL_PRICE, DISCOUNT_APPLIED, REQUEST_TIME, IS_ACTIVE, IS_RATED) VALUES ('1', '1', '1', '173.28', '155', TO_TIMESTAMP('2020-03-09 17:41:32.038000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'Y', 'N');
INSERT INTO "B00074902"."REQUEST" (ID, DONOR_ID, DONEE_ID, FINAL_PRICE, DISCOUNT_APPLIED, REQUEST_TIME, IS_ACTIVE, IS_RATED) VALUES ('2', '1', '3', '170.46', '531', TO_TIMESTAMP('2020-03-09 17:41:32.038000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'N', 'Y');
INSERT INTO "B00074902"."REQUEST" (ID, DONOR_ID, DONEE_ID, FINAL_PRICE, DISCOUNT_APPLIED, REQUEST_TIME, IS_ACTIVE, IS_RATED) VALUES ('3', '2', '5', '158.14', '98', TO_TIMESTAMP('2020-03-09 17:41:32.038000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'N', 'N');

----------------------------------------------------------------Sub Request------------------------------------------------------------------
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('1', '1', '3', '2', '15');
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('2', '1', '19', '3', '49');
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('3', '2', '7', '4', '19');
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('4', '2', '20', '10', '36');
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('5', '2', '12', '15', '39');
INSERT INTO "B00074902"."SUB_REQUEST" (ID, REQUEST_ID, FOOD_ID, QUANTITY, PRICE_AT_PURCHASE) VALUES ('6', '3', '9', '25', '98');