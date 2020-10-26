Feature: Test facebook login
Background:
 Given User is at facebook login page

@Regression
Scenario: Login with invalid password
When User enter valid user name
And User enter invalid password
And User clicks on signin button
Then login should not successful

@Smoke @Regression
Scenario: Login with valid username; pass value from step
When User enter valid user name "tripathi.shikha18july@gmail.com"
And User enter invalid password "shikha@45"
And User clicks on signin button
Then login is unsuccessfull with title "Log in to Facebook" displayed on page

@datadriven
Scenario Outline: Login with different set of values
When User enter valid user name "<username>"
And User enter invalid password "<password>"
And User clicks on signin button
Then login is unsuccessfull with title "<text>" displayed on page
Examples:
     | username | password | text |
     |shikhat@gmail.com   | 123456   | Login in to Facebook |
     |ashutosh@gmail.com  | 345657   | Login in to Facebook |
     
