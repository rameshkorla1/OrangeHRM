@EmployeeSearch
Feature: Employee Search

Scenario: HR manager searches for an employee by name

  Given User is logged as an HR manager
  And User is on the employee search page
  When User enters the name of an employee in the search field
  And click on the Search button
  Then User should see a list of matching employees based on the search criteria

Scenario: HR manager searches for an employee by employee ID

  Given User is logged as an HR manager
  And User is on the employee search page
  When User enters the employee ID in the search field
  And click on the Search button
  Then User should see a list of matching employees based on the search criteria

Scenario: HR manager receives no results for the given search criteria

  Given User is logged as an HR manager
  And User is on the employee search page
  When User enters a search criteria that does not match any employees
  And click on the Search button
  Then User should see an appropriate message indicating that no employees were found
