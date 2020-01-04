Feature: Login into Application

Scenario Outline: Positive test validating login screen

Given User is on application landing page
Then  Click on Sign In link in landing page
When  User enters <username> and <password> and logs in
Then  User should be succesfully logged in

Examples:
|username			        |password  |
|sudhir01pandit@gmail.com	|burger01  |



