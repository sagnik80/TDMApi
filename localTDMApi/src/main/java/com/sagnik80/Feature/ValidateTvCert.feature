Feature: Validate that the User queries on Movie Certificates are returned successfully
@MovieAPI
  Scenario: Positive flow for Valid User Query on Movie Certificate is Successful
    Given "Authorized" User logs in to TMDB
    When User request to get the TV Certificate and Status as "200"
    Then TV Certificate Details is returned in accordance
    
  Scenario: Negative flow for Invalid User Query on Movie Certificate is UnSuccessful
    Given "UnAuthorized" User logs in to TMDB
    When User request to get the TV Certificate and Status as "401"
    Then TV Certificate Details is returned in accordance