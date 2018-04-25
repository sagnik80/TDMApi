# TMDBApi Automation
The APIs are all REST and return JSON data. Visit https://developers.themoviedb.org/3/gettingstarted
for detailed documentation regarding the API. 

This is a maven based Java Project which uses rest assured plugin and Cucumber which supports Acceptance Test Driven Development (ATDD). 

In this framework Cucumber Feature Files contains all the test cases for a given functionality.The other related components are Step Definitions and TestRunner Files

This automation Framework contains 3 Feature Files for 3 TMDB APIs that have been automated under this framework -
1. GET Create Request Token
2. GET Get Movie Certifications
3. GET Get Movie Certifications

Logging
All the steps are logged under logs folder

Reporting
For test results Reporting I have used extent report plug-in with cucumber reports.
HTML Reports can be found under target cucumber reports

Before run
Please update your Key in Global.properties file under src/main/java/com/sagnik80/Global else the Build will fail

To run
Just clone the project and Run As mvn -test 
