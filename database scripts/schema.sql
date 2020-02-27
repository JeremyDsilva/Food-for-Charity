CREATE TABLE b00074902.PersonRole
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20) NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.Person
(
    Id int NOT NULL PRIMARY KEY,
    Username VARCHAR(255) NOT NULL UNIQUE,
    PasswordHash VARCHAR(255) NOT NULL,
    PasswordSalt VARCHAR(255) NOT NULL,
    LastLoginTime TIMESTAMP NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.MapPersonRole
(
    Id int NOT NULL PRIMARY KEY,
    PersonId int NOT NULL,
    RoleId int NOT NULL,
    CONSTRAINT fk_MapPersonRole_PersonId FOREIGN KEY(PersonId) REFERENCES b00074902.Person(Id),
    CONSTRAINT fk_MapPersonRole_RoleId FOREIGN KEY(RoleId) REFERENCES b00074902.PersonRole(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MealType
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20)
        NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.Allergen
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20)
        NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.Cuisine
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20)
        NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.DoneeType
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20) NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.DoneeStatus
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20)
        NOT NULL
);
-------------------------------------------------------

CREATE TABLE b00074902.Donee
(
    Id int NOT NULL PRIMARY KEY,
    DoneeName VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL,
    EmailAddress VARCHAR(255) NOT NULL,
    AddressDescription VARCHAR(255) NOT NULL,
    City VARCHAR(255) NOT NULL,
    Country VARCHAR(255) NOT NULL,
    StatusId int NOT NULL,
    TypeId int NOT NULL,
    MemberCount int NOT NULL check (0 < MemberCount),
    QuantityRequested int NOT NULL check (0 <= QuantityRequested),
    PersonId int NOT NULL,
    CONSTRAINT fk_Donee_StatusId FOREIGN KEY(StatusId) REFERENCES b00074902.DoneeStatus(Id),
    CONSTRAINT fk_Donee_TypeId FOREIGN KEY(TypeId) REFERENCES b00074902.DoneeType(Id),
    CONSTRAINT fk_Donee_PersonId FOREIGN KEY(PersonId) REFERENCES b00074902.Person(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapDoneeAllergen
(
    Id int NOT NULL PRIMARY KEY,
    DoneeId int NOT NULL,
    AllergenId int NOT NULL,
    CONSTRAINT fk_MapDoneeAllergen_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id),
    CONSTRAINT fk_MapDoneeAllergen_AllergenId FOREIGN KEY(AllergenId) REFERENCES b00074902.Allergen(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapDoneeCuisine
(
    Id int NOT NULL PRIMARY KEY,
    DoneeId int NOT NULL,
    CuisineId int NOT NULL,
    CONSTRAINT fk_MapDoneeCuisine_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id),
    CONSTRAINT fk_MapDoneeCuisine_CuisineId FOREIGN KEY(CuisineId) REFERENCES b00074902.Cuisine(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapDoneeMealType
(
    Id int NOT NULL PRIMARY KEY,
    DoneeId int NOT NULL,
    MealTypeId int NOT NULL,
    CONSTRAINT fk_MapDoneeMealType_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id),
    CONSTRAINT fk_MapDoneeMealType_MealTypeId FOREIGN KEY(MealTypeId) REFERENCES b00074902.MealType(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.DonorStatus
(
    Id int NOT NULL PRIMARY KEY,
    Name varchar(20) NOT NULL
);

-------------------------------------------------------

CREATE TABLE b00074902.Donor
(
    Id int NOT NULL PRIMARY KEY,
    DonorName VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL,
    Email VARCHAR(255) NOT NULL CHECK(REGEXP_LIKE (EMAIL,'^[A-Za-z]+[A-Za-z0-9.]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$')),
    AddressDescription VARCHAR(255) NOT NULL,
    City VARCHAR(255) NOT NULL,
    Country VARCHAR(255) NOT NULL,
    Rating int NOT NULL,
    NumberOfRating int NOT NULL check (0 <= NumberOfRating),
    StatusId int NOT NULL,
    PersonId int NOT NULL,
    CONSTRAINT fk_Donor_StatusId FOREIGN KEY(StatusId) REFERENCES b00074902.DonorStatus(Id),
    CONSTRAINT fk_Donor_PersonId FOREIGN KEY(PersonId) REFERENCES b00074902.Person(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.Food
(
    Id int NOT NULL PRIMARY KEY,
    FoodName varchar(20) NOT NULL,
    DescriptionText varchar(255) NOT NULL,
    Price int NOT NULL check (0 <= Price),
    MealForNPeople number(5,2) NOT  NULL check (0 < MealForNPeople and MealForNPeople < 999),
    QuantityAvailable int NOT NULL check (0 <= QuantityAvailable),
    DonorId int NOT NULL,
    CONSTRAINT fk_Food_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapFoodAllergen
(
    Id int NOT NULL PRIMARY KEY,
    FoodId int NOT NULL,
    AllergenId int NOT NULL,
    CONSTRAINT fk_MapFoodAllergen_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id),
    CONSTRAINT fk_MapFoodAllergen_AllergenId FOREIGN KEY(AllergenId) REFERENCES b00074902.Allergen(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapFoodCuisine
(
    Id int NOT NULL PRIMARY KEY,
    FoodId int NOT NULL,
    CuisineId int NOT NULL,
    CONSTRAINT fk_MapFoodCuisine_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id),
    CONSTRAINT fk_MapFoodCuisine_CuisineId FOREIGN KEY(CuisineId) REFERENCES b00074902.Cuisine(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.MapFoodMealType
(
    Id int NOT NULL PRIMARY KEY,
    FoodId int NOT NULL,
    MealTypeId int NOT NULL,
    CONSTRAINT fk_MapFoodMealType_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id),
    CONSTRAINT fk_MapFoodMealType_MealTypeId FOREIGN KEY(MealTypeId) REFERENCES b00074902.MealType(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.Request
(
    Id int NOT NULL PRIMARY KEY,
    FoodId int NOT NULL,
    DoneeId int NOT NULL,
    Quantity int NOT NULL check (0 <= Quantity),
    RequestTime TIMESTAMP NOT NULL,
    IsActive CHAR(1) NOT NULL CHECK (IsActive IN ('Y','N')),
    CONSTRAINT fk_Request_FoodId FOREIGN KEY(FoodId) REFERENCES b00074902.Food(Id),
    CONSTRAINT fk_Request_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.DoneeComplaint
(
    Id int NOT NULL PRIMARY KEY,
    DoneeId int NOT NULL,
    DonorId int NOT NULL,
    DescriptionText varchar(255) NOT NULL,
    ComplaintTime TIMESTAMP NOT NULL,
    IsActive CHAR(1) NOT NULL CHECK (IsActive IN ('Y','N')),
    CONSTRAINT fk_DoneeComplaint_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id),
    CONSTRAINT fk_DoneeComplaint_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id)
);

-------------------------------------------------------

CREATE TABLE b00074902.DonorComplaint
(
    Id int NOT NULL PRIMARY KEY,
    DonorId int NOT NULL,
    DoneeId int NOT NULL,
    DescriptionText varchar(255) NOT NULL,
    ComplaintTime TIMESTAMP NOT NULL,
    IsActive CHAR(1) NOT NULL CHECK (IsActive IN ('Y','N')),
    CONSTRAINT fk_DonorComplaint_DonorId FOREIGN KEY(DonorId) REFERENCES b00074902.Donor(Id),
    CONSTRAINT fk_DonorComplaint_DoneeId FOREIGN KEY(DoneeId) REFERENCES b00074902.Donee(Id)
);

-------------------------------------------------------
