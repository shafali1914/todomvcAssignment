Feature: Add, Edit, Delete and Complete Todo items

  Scenario: Add a new todo item
    Given I am on the TodoMVC homepage
    When I enter "Buy groceries" in the input field
    And I press Enter button
    Then Verify the todo task should be displayed in the list

  Scenario: Mark a todo as completed
    Given I have a todo "Rent transfer" in the list
    When I click the checkbox next to the todo task
    Then Verify that the todo task should be marked as completed

  Scenario: Delete a todo
    Given I have a todo "Important call" in the list
    When I click the delete button next to the todo task
    Then Verify that the todo task should be removed from the list

  Scenario: Mark all Complete
    Given I have a todo "Meditation" in the list
    And I have a todo "Journaling" in the list
    When I click on Complete All arrow
    Then Verify that all tasks should be marked Complete

  Scenario: User double-clicks on an existing todo task and edit the task name
    Given I have a todo "Go to Supermarket" in the list
    When I double-click on the todo task
    And I enter new todo task name "Buy veggies & fruits" in edit field
    And I press Enter button
    Then Verify that the task should name be updated
