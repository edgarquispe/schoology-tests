Feature: Profile

  Scenario: Edit profile
    Given I log in as "Instructor03" user
    And I update the profile "Instructor03" with:
      | Bio         | Tes3 |
    When I save changes
    And I should see the "Your profile has been updated." message in User Profile
