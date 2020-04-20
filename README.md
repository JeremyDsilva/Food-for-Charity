# Food for Charity 
This project is still under development

Food for Charity is a web-based application that connects restaurants who have food in excess and wish to donate with individuals and organizations who need food. Restaurant supply information on the food they are willing to donate and those in need can reserve this food. The goal of this app is to reduce food wastage in society. This is a group software engineering university project built using Spring Boot, Spring Data and Spring Security. Our professor is our primary client.

## About The App
The app handles the interaction between 3 main users: **Donor**, **Donee** and **Broker**.</br> 
<p>
The <b>Donor</b>, specifically, a restaurant, can donate a quantity of food to the app. They can add food to their menu, specifying the type of cuisine, meal-type, and allergens in the food. They then choose what to make available by specifying the quantity of the food they wish to donate. Donors are alerted when a donee makes a request and can mark a request complete once picked up. A donor can also file a complaint against the donee based on their interaction. Donors can exist in four states in the platform: Initial, Active, Inactive, or Suspended. Donors who register with the platform are in the Initial state awaiting approval from the broker. If a donor in Active state has not donated in two weeks their status becomes Inactive. Donors in the Suspended state cannot access the app.
</p> 
<p>
The <b>Donee</b>, an individual or organization, can request for donated food. Once they have selected a food item to order, they must specify the quantity and the time of pickup. There are limits to the amount of food they can order in a given time interval. The quantity they can request is based on the number of members they have registered with. A donee can rate or file a complaint against the donor based on their interaction. Donees can exist in three states: Initial, Active or Suspended. Donees who register with the platform are in the Initial state awaiting approval from the broker. Only donees in the Active state can make food request. Donees in the Suspended state cannot access the app.
</p>
<p> 
The <b>Broker</b> manages the system. Brokers can view all user profiles, requests, and donated food. The broker can update donor anddonee statuses and can resolve complaints.
</p>

## How To Run

<b>This project is still under development</b>

Clone this repository. Make sure you are using JDK 13 and Maven 4.0

You can build the project and run the tests by running:

   ```
    mvn clean install
   ```

You can run the application using:
    
  ```
   mvn -pl web spring-boot:run
  ```

Access the web application on your browser using http://localhost:8080/

## Acknowledgements
My team members are [Aghyad AlAhmad](https://github.com/aghyad97), [Priyanka Prakash](https://github.com/PriyankaPrakashChand) and [Mohammed Al-Zaabi](https://github.com/mAlZaabi). 
