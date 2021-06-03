Feature: Sections

  @deleteCourse @softAssert
  Scenario: Add a section
    Given I log in as "Instructor01" user
    And I create a course with:
      | Course Name  | Course for Section |
      | Section Name | Default Section    |
      | Subject Area | Mathematics        |
      | Level        | Undergraduate      |
    When I navigate to "Courses"
    And I add a Section into "Course for Section" course with:
      | Course Name  | Course for Section |
      | Section Name | Technology Section |
      | Subject Area | Technology         |
      | Level        | Undergraduate      |
    Then I should see the "Successfully created" message for "Technology Section" section on "Course for Section" course item
    And I should see the "Technology Section" section on "Course for Section" course item
    And I assert all
