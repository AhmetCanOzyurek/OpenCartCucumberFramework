@login2
Feature: login functionality

  Scenario Outline:  login2
    Given user on homepage
    When user clicks the following links with text
      | My Account |
      | Login      |


    When  user fill the login form with the following datas
      | username | <username> |
      | password | <password> |

    And user clicks login button
    Then login should be "<success>"

    Examples:
      | username           | password | success |
      | deneme@deneme.com  | deneme   | true    |
      |                    |          | false   |
      | deneme@deneme.com  |          | false   |
      |                    | deneme5  | false   |
      | deneme3@deneme.com | deneme4  | false   |
      | deneme4@deneme.com | deneme3  | false   |
      | deneme5@deneme.com | deneme2  | false   |
      | deneme6@deneme.com | deneme1  | false   |
      | a                  | a        | false   |
