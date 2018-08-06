# Spring boot REST API and Ionic/Angular mobile app - example


## Overview
- A sample app to demonstrate Spring Boot - Ionic mobile app
- The server scraps the websites (uses JSoup) to read Quotes and store into db.
    - see `g.t.quote.scrapper.WebScraper`
- The client (mobile app) will randomly display such quotes. Has an ability to record and display view count.


## Mobile Client - Ionic3 App
- Follow installation steps from https://ionicframework.com/docs/v1/guide/installation.html
- Download android SDK and add ANDROID_HOME. It was C:\Users\gt\AppData\Local\Android\Sdk
- Generate APK file: `ionic cordova build --release android`
- DEV/PROD environment --> currently we need to manually comment/uncomment mobile/src/app/app.constants.ts for SERVER_API_URL
    - Ionic 4 will have default support for environment variables 

# Server: Spring Boot
- Uses JSoup to parse the quote websites and stores into H2 database at startup
- Quotes can be retrieved by REST apis `HOST/quotes` 
- Deploy to Heroku 
- Did below updates for Heroky. Since its a multi module Maven app: 
    - Added file: Procfile `web: java -jar server/target/server-0.0.1-SNAPSHOT.jar -Dserver.port=$PORT`
    - Added server.port entry on application.yml   ` server: port: ${PORT:8080}`
     
# Run Locally
- Start Server : Run g.t.quote.QuoteApplication
- Start client
    - Comment/Uncomment the line to use
        - `localhost:8080` to use local server
        -  `https://gt-quote-app.herokuapp.com/` to use app deployed on heroku
    - cd to mobile directory and run `ionic server` and `ionic open`
- To generate APK
    - Follow https://ionicframework.com/docs/v1/guide/publishing.html
        - Make sure app.constants.ts is pointing to heroku app URL
        - Run  ` ionic cordova build --release android`
        - Grab the debug version of apk  `app-debug.apk` and copy to your android device and install the APK
            - It should be `FOLDER\quote-app\mobile\platforms\android\app\build\outputs\apk\debug\`
            
## Prerequisite 
- Node
- NPM/Yarn
- Ionic cli
- Android SDK
- Maven
- JDK 1.8    