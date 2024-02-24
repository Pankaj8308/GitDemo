
@tag
Feature: Purchase order from Ecomm site
  I want to use this template for my feature file

Background:
Given I landed on Login page

  @Purchase
  Scenario Outline: Positive test of Purchasing the order
    Given I Logged in with <username> and <password>
    When I add the <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      |	username												|	password		|	productName					|
      |	Pankajkumartiwari8308@gmail.com	|	Qwerty@123 	|	ADIDAS ORIGINAL			|
      |	PKT@gmail.com										|	Qwerty@123	|	ZARA COAT 3					|
