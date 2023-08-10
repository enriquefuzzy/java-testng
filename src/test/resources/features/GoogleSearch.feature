Feature: Search for terms on Google

  Scenario: Verify user can search for Dogs
    Given I am on the Google search page
    When I search Google for "Dogs"
    Then I should see search results for "Dogs"