@login1
Feature: Login functionality

  Scenario: login with true credentials
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks login link
    Then  Login page should be visible

    When  user fill the login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |
    And   user clicks login button
    Then  login should be succesfull






