@api
Feature: Automate sample API requests using https://reqres.in/

  Background: User generates token for Authorisation

  @users @WIP
  Scenario: Verify authorized user can get a list of users
    Given A list of books are available
    When I add a book to my reading list
    Then the book is added
    When I remove a book from my reading list
    Then the book is removed