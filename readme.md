# Spring Boot REST API + Keycloak and Angular Web App

#### Web Scrapping using JSoup blog: https://ganeshtiwaridotcomdotnp.blogspot.com/2018/12/web-scrapping-in-java-using-jsoup.html

## Overview
- A sample app to demonstrate Spring Boot - Angular Web App
- The server scraps the websites (uses JSoup) to read Quotes and store into db.
    - see `WebScraper` interface
    - see also `GoodReadsScrapper`
- The client (web app) has option to subscribe to receive random quotes daily
- The logged in user can manage the quotes, view all    
- The client (mobile app in branch `mobile-ionic-app`) also pulls and displays the quotes

# Keycloak Setup
- Import realm-export.json
- Manually create users with role = 'user'

# How to run Locally?
- Start Server : 
    - Import project into your IDE and run QuoteApplication inside server module
    - OR navigate to server module and run 'mvnw or ./mvnw'. The default goal is spring-boot:run which starts the app automatically
- Start client : Navigate to web module and run  'npm install' for one time to install dependencies and then `npm start` afterwards to run the ap
- Start keycloak docker. Run ``docker run -p 8082:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:11.0.0``

- Open http://localhost:4200

### Server: Spring Boot
- Uses JSoup to parse the quote websites and stores into H2 database at startup
- Quotes can be retrieved by REST apis `HOST/quotes` 
- Deploy to Heroku 
- Did below updates for Heroku. Since its a multi module Maven app: 
    - Added file: Procfile `web: java -jar server/target/server-0.0.1-SNAPSHOT.jar -Dserver.port=$PORT`
    - Added server.port entry on application.yml   ` server: port: ${PORT:8080}`


# Angular Web App
- Start locally:  `npm start`.
- Proxy is configured to handle cors request. Review 'start' scripts at  `web/package.json` 
- Prod build : `ng build --prod`
- Run in production: using express/node : `node server.js`
- Note the following dependencies

```
    "cors": "^2.8.5",
    "express-http-proxy": "^1.6.0",
    "port": "^0.8.1",
```
