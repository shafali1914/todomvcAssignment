Feature: Negative Scenarios for TodoMVC

Scenario: Enter empty todo task
Given I am on the TodoMVC homepage
When I enter an empty todo
And I press Enter button
Then Verify that no task should be created

Scenario: Try to click Clear completed when no task is complete
Given I have a todo "Rent transfer" in the list
When I click the Clear completed button
Then Verify that no action should be taken

Scenario: Adding duplicate Todo Item
Given I have a todo "Drink water" in the list
And I enter "Drink water" in the input field
And I press Enter button
Then Verify that the application should not create duplicate tasks

Scenario: Edit existing task to empty task name
Given I have a todo "Drink water" in the list
When I double-click on the todo task
And I enter new todo task name "" in edit field
And I press Enter button
Then Verify that task should not be updated