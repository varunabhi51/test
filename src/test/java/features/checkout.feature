
Feature: Validate checkout functionality

@Reg
Scenario: validate checkout with valid details

Given user enter "standard_user" and "secret_sauce"
And user click on login button
And user add product into the basket from PLP page
And user navigate to cart page
And user enter information "Abhishek" "Varun" "273157"
And user place order with cash on delivery mode
Then validate order confirmation


Scenario: validate checkout with blank value

Given user enter "standard_user" and "secret_sauce"
And user click on login button
And user add product into the basket from PLP page
And user navigate to cart page
And user enter information " " "" ""
Then validate error masssage