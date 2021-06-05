Feature: Groups

  @deleteGroup
  Scenario: Edit a group
    Given I log in as "Instructor02" user
    And I create a group with:
      | Name        | Selenium Group |
      | Description | Description    |
      | Privacy     | School         |
      | Access      | Invite Only    |
      | Category    | Musical Groups |
    When I navigate to "Groups"
    And I edit the "Selenium Group" group with:
      | Name | Selenium Group updated |
    Then I should see the "Selenium Group updated has been saved." message
    And I should see a group with "Selenium Group updated" as a name
