Feature: Product details page

@verifyingproductdetails
  Scenario: verifying the product details
    Given Searching for "<product>"
    When I click on the product
    Then I see the product title
    And I see the product description
    And I see the product price
    And I see the product images
    And I see the product availabity
 And I click on add to wishlist
  And I click on add to cart
  Then product is added
  
   Examples:
   |product|
   |Health Book| 