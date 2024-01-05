@WishList
Feature: Wishlist functionality

  Background: login with true credentials
    Given user on homepage
    When user login with username "deneme@deneme.com" and password "deneme"
    Then  login should be succesfull

  Scenario: wishlist TC 1
      Given user search for "imac"
      When user add "iMac" to the wishList
      Then  successs notification with "wish list!" should be visible

