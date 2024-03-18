
@tag
Feature: Login into ecommerce website
  I want to use this template for my feature file

  @Error
  Scenario Outline: Error validation in login page
    Given I land on the ecommerce website
    When I login using credentials <username> and <password>
    Then "Incorrect email or password." should be dsiplayed

    Examples: 
      | username             | password  |
      | strawberry@gmail.com | Cream95!  |
      | strawberry@gmail.com | Cream950  |
