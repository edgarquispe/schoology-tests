Feature: Resources

  @deleteResource
  Scenario: Delete a folder resource
    Given I log in as "Instructor02" user
    And I add a folder in resources with:
      | Name         | Test Folder |
      | Folder Color | Red         |
    When I delete the "Test Folder" resource
    Then I should see the "Your item has been removed." message in Resources
    And I should not see "Test Folder" resource
