Feature: Validate that the User can Create a Request Token successfully
@MovieAPI
  Scenario: Positive Flow for Valid User request for Session is Successful
    Given User is  "Authorized" to access TMDB
    When User request to get the Token and Status as "200"
    Then Request Token is returned in accordance
    
   Scenario: Negative Flow for Valid User request for Session is UnSuccessful
    Given User is  "UnAuthorized" to access TMDB
    When User request to get the Token and Status as "401"
    Then Request Token is returned in accordance