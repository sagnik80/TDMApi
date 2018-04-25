Feature: Validate that the User queries on Movie Certificates are returned successfully
@MovieAPI
  Scenario: Positive Flow for Valid User Query on Movie Certificate is Successful
    Given "Authorized" user is logging in TMDB
    When User request to get the Movie Certificate and Status as "200"
    Then Movie Certificate Details is returned successfully
    
  Scenario: Negative Flow for InValid User Query on Movie Certificate is UnSuccessful
    Given "UnAuthorized" user is logging in TMDB
    When User request to get the Movie Certificate and Status as "401"
    Then Movie Certificate Details is returned successfully