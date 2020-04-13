# Food for Charity 
The project is a food donation managment web application that allows resturaunts and individuals (donors) to donate food to individuals in need (donees). The purpose of this project is to utilize extra food to charity instead of it going to waste. The project was assigned to us by our professor as a course requirement for the software engineering course offered at the American University of Sharjah. The professor was the primary client whom we were assigned to capturing the project's requirements that he provided.  
## About The App
The app handles the interaction between 3 main users: **Donor**, **Donee** and **Broker**.</br> 
<p>
The <b>Donor</b> , specifically a restaurant, can donate a quantity of food to the app. They do this by adding their entire menu to the app. Then, they choose what menu item will be available to order by specifying the quantity of said item. Once the menu has been submitted to the app, they can specify the type of cusine and any allergens that may be in their food.
</p> 
<p>
The <b>Donee</b>, an individual or organization, can request food that has been donated by the donor. They can filter the food choices by cusine or to not include an allergen. They can also filter the food choices based on preference. Once they have selected a food item to order, they must specify quantity and the time of delivery. There are limits to the amount of food they can order. For example, the donee cannot order an unlimited amount of food. The quantity requested must be approved by the broker before taking effect. The Donee can also rate the Donor using a five-star rating system to share their experience with other donees.
</p>
<p>
The following is only true for both Donor and Donee:
</p>

* Both can file complaints based on their interaction with each other to the broker.

* Both have a status indicating their state of activity (active/inactive/suspended) that the broker can update.

<p> 
The <b>Broker</b> is responsible for managing the system which includes: updating user status and resolving complaints. If a user, other than the broker, has not interacted with the system, then it is up to the broker to inform the other users of that user's activity. The <b>system</b> fuffils that responsibility by <i>automatically</i> updating the status of the user. The same responisblity is applied if a user has interacted with the system after a long period of inactivity. If a user (both Donor and Donee) behaves in a way that voilates the terms of service provided by the app, other users can file a complaint that the broker has to evaluate and resolve. The broker then confirms whether a user has indeed voilated the terms of service, and prevents them from further interacting with the system. The broker can also view all requests made by the system.
</p>

## How To Run

  - Clone this repository

  - Make sure you are using JDK 13 and Maven 3.x
  
  - You can build the project and run the tests by running

   ```
    mvn clean install
   ```

  - Once successfully built, you can run using:
    
  ```
   mvn spring-boot:run
  ```

  - Access the web application on your browser using:

  ```
  http://localhost:8080/
  ``` 

[comment]: <> (Will be changed)
[comment]: <> (Start) 
## Running the project with MySQL,
[comment]: <> (End)
### In pom.xml add:

```
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
```

### Append this to the end of application.yml:


```
---
spring:
  profiles: mysql

  datasource:
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql://<your_mysql_host_or_ip>/bootexample
    username: <your_mysql_username>
    password: <your_mysql_password>

  jpa:
    hibernate:
      dialect: org.hibernate.dialect.MySQLInnoDBDialect
      ddl-auto: update # todo: in non-dev environments, comment this out:


hotel.service:
  name: 'test profile:'
```

### Then run is using the 'mysql' profile:


```
  java -jar -Dspring.profiles.active=mysql target/spring-boot-rest-example-0.5.0.war
or
  mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=mysql"
``` 

## Acknowledgements
Aghad AlAhmad: https://github.com/aghyad97</br> 
Mohammed Al-Zaabi: https://github.com/mAlZaabi</br>
Priyanka Prakash: https://github.com/PriyankaPrakashChand </br>



