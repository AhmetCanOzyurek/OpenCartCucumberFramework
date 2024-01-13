@WishList
Feature: Wishlist functionality

  Background: login with true credentials
    Given user on homepage
    When user login with username "deneme@deneme.com" and password "deneme"
    Then  login should be successfull

  Scenario: wishlist TC 1
      Given user search for "imac"
      When user add "iMac" to the wishList
      Then  successs notification with "wish list!" should be visible

  Scenario: wishlist TC 2
      Given user search for "imac"
      When user add "iMac" to the wishList
      Then  successs notification with "wish list!" should be visible

