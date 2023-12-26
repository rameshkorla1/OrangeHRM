@UserLogin
Feature: User Login

Scenario: User login with valid credentials

  Given User is on the OrangeHRM login page
  When User enter valid credentials
  And click on the Login button
  Then User should be redirected to the dashboard

Scenario: User login with invalid credentials

  Given User is on the OrangeHRM login page
  When User enter invalid credentials
  And click on the Login button
  Then User should see an error message

Scenario: User login without providing credentials

  Given User is on the OrangeHRM login page
  When User click on the Login button without providing credentials
  Then User should see an error message

Scenario: User login with missing username

  Given User is on the OrangeHRM login page
  When User enter the password without providing a username
  And click on the Login button
  Then User should see an error message

Scenario: User login with missing password

  Given User is on the OrangeHRM login page
  When User enter the username without providing a password
  And click on the Login button
  Then User should see an error message
