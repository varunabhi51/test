Feature: Validate LOgin Functionality

@Reg
Scenario: Verify Sucessfull login with Valid details

Given user enter "standard_user" and "secret_sauce"
And user click on login button
Then Validate user logged in successfully