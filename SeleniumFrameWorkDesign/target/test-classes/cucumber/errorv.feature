
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Login page
    When I Logged in with <username> and <password>
    Then "Incorrect email or password." error message is displayed

    Examples: 
      |	username												|	password		|
      |	Pankajkumartiwari830@gmail.com	|	Qwerty@123 	|
      |	PK@gmail.com										|	Qwerty@123	|
