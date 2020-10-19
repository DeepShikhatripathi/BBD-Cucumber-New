Feature: Test facebook login
Background:
 Given User is at facebook login page

Scenario: Login with invalid password
When User enter valid user name
And User enter invalid password
And User clicks on signin button
Then login should not successful


Scenario: Login with valid username; pass value from step
When User enter valid user name "tripathi.shikha19july@gmail.com"
And User enter invalid password "shikha@45"
And User clicks on signin button
Then login is unsuccessfull with title "Log in to Facebook" displayed on page