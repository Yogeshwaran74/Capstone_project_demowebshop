Feature: Home page search
 Background: 
 Given Home page of website
  @Verifymajorsection
  Scenario: Verifying the major sections
    When I verify the Featured Products
    And I verify the search bar

  @Verifysearchfunctionality
  Scenario Outline: Verify search bar functionality
   	When I navigated to search bar
    And I search for "<Book>"
    And I click on the search button
    And I see the search results
   And I click on advanced search
    And I filter the results by category 
    And I filter the results by price
    And I filter the results by ratings
    Then I see the filtered product displayed
    
    Examples: 
      | Book    |
      | Book   |