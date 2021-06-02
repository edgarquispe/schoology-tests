Feature: Question Bank Resources

  @deleteResources @softAssert
  Scenario: Create Question Bank Resource with questions
    Given I log in as "Instructor01" user
    When I navigate to "Resources"
    And I create a "Question Bank" resource with:
      | Name                     | Test Question Bank   |
      | Description              | Resource Description |
      | Enable Question Tracking | Yes                  |
    And I open the "Test Question Bank" question bank resource
    And I add a "True/False" question with:
      | Title          | Test Question 1 |
      | Correct Answer | False           |
    And I add a "Short-Answer/Essay Question" question with:
      | Title           | What is a subnet mask? |
      | Character Limit | 300                    |
    Then I should see the "Test Question Bank" Question Bank resource with questions:
      | Title                  | Question Type                       |
      | Test Question 1        | resource.question_type.true_false   |
      | What is a subnet mask? | resource.question_type.short_answer |