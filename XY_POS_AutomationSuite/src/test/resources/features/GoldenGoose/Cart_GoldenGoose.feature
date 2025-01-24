@GoldenGoose @Cart @GoldenGoose_Cart
Feature: XYPOS - Cart_Damiani

  Background:
    Given I access the XY login page
    When I enter the Username for "goldengoose"
    And I click on Continue button
    And I enter the Password
    And I click on Continue button

  @New_bag @NewBag_GoldenGoose @Cash_Payment
  Scenario: Validate New bag scenario for sales cart
    When I click on New Bag
    And I click on Sales Order button
    When I click on Products
    Then verify i am in Products page
    Then I click on verification badge
    And I click on first Product
    Then verify i am in Product Display Page
    And I click on Add to cart button
    When I click on the cart button
    And I update price of item and verify
    Then I click on the Checkout button
    Then verify all required alert texts are displayed
      | Customer Missing         |
      | Client Engagement Reason |
    And I add a customer to the order and verify
    Then I click on the Checkout button
    Then verify all required alert texts are displayed
      | Client Engagement Reason |
    And I select a Client Engagement Reason
    Then I click on the Checkout button
    And I select the Cash payment method
    Then I click on the Apply Payment button