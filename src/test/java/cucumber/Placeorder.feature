#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Place order in ecommerce website
  I want to use this template for my feature file

Background:
    Given I land on the ecommerce website

  @Regressions
 Scenario Outline: Positive Scenario of placing an order
    Given I login using credentials <username> and <password>
    When I add product to the cart
    And checkout the product
    Then I should be navigated to Order Confirmation page

    Examples: 
      | username                     | password     |
      | strawberry@gmail.com         | Cream90!     |
      
