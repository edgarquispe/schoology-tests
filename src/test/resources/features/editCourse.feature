Feature: Courses

  @deleteCourse @softAssert
  Scenario: Edit a course
    Given I log in as "Instructor01" user
    And I create a course with:
      | Course Name  | Selenium WebDriver Course |
      | Section Name | New Section               |
      | Subject Area | Mathematics               |
      | Level        | Undergraduate             |
    When I navigate to "Courses"
    And I edit the "Selenium WebDriver Course" course with:
      | Course Name  | New Selenium WebDriver Course |
      | Section Name | Section Test                  |
      | Subject Area | Science                       |
    Then I should see the "The section has been updated." message
    And I should see the "Section Test" section on "New Selenium WebDriver Course" course item
    And I assert all
