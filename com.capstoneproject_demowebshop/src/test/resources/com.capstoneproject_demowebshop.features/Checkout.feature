Feature: adding the product and completing the purchase

@orderPlacement
 Scenario Outline: adding items and purchasing
 Given I search "<product>" for adding to cart
 When I add the product to cart
 And I click on shopping cart link
 And I click on checkout
 And I login and proceed to checkout
 And I enter billing address
 And I continue with shipping address
 And I continue with shipping method
 And I continue with payment methods
 And I confirm order
 Then I validate the successfully processed order
 
 Examples: 
|product      |
|book  |