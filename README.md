"# ExchangeRateApp" 
-------------------------
WARNING (IMPORTANT) : 
I dont have access to premium api key so have commented @Scheduled annotation in ScheduledService, by this, application will not fetch and store the data.

To use full functionality, before initializing the application kindly go to ScheduledService class (path : src/main/java/com/rishabh/exchangeRate/services/SchedulerService.java) and REPLACE the "API KEY" in String baseURL with a valid premium key to fetch historical data and un-comment the @Scheduled annotation.

Else, manually feed the data to database and test other functionalities of application.
-------------------------
Exchange Rate API Documentation
Overview :
The Exchange Rate API provides endpoints to retrieve exchange rate differences for various currencies and to manage exchange rate data.

Prerequisite :
-> Java 17
-> Maven
-> Spring Boot
-> MongoDB 
    -> Start MongoDB server in your local machine with default port : 27017
    -> Add new Database named myDB with collection rates

How to Run Locally :
-> Clone the repository:
    git clone https://github.com/rishxbh/ExchangeRateApp.git
-> Navigate to the project directory:
    cd exchangeRate
-> Build the project:
    ./mvnw clean package
-> Run the application:
    java -jar target/exchangeRate-0.0.1-SNAPSHOT.jar
-> The application will start, and you can access the API endpoints locally using a tool like Postman or curl.

Endpoints :
-> Get Exchange Rate Difference
   URL: https://localhost:8080/api/exchangeRate/diff/{curr}
   Path Parameters:
        curr: curr should be valid currency code INR, CAD, AED;
-> Post Exchange Rate Data
   URL: https://localhost:8080/api/exchangeRate/post
   Request Body:
        date: Date in yyyy-MM-dd format
        currencies: Map containing currency codes and their corresponding exchange rates
-> Put Exchange Rate Data
   URL: https://localhost:8080/api/exchangeRate/put
   Request Body:
        date: Date in yyyy-MM-dd format
        currencies: Map containing currency codes and their corresponding exchange rates
-> Delete Exchange Rate Data
   URL: https://localhost:8080/api/exchangeRate/delete/{date}
   Path Parameters:
        date: Date in yyyy-MM-dd format
