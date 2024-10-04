Website in focus of this testing - https://todomvc.com/examples/react/dist/

**Project Overview**
This project is a comprehensive test automation framework built using:
    Java: The programming language for writing test scripts.
    Selenium WebDriver: For automating web browser interactions.
    TestNG: For test case management and execution.
    Cucumber: For BDD (Behavior-Driven Development) and writing human-readable test scenarios.
    Maven: For project build, dependency management, and lifecycle management.
    Page Object Model (POM): For organizing test code and maintaining reusability.
    Cucumber Reports: For generating detailed HTML reports of test execution.
    Extent Reports: For creating customizable and visually appealing test reports.


**POSITIVE SCENARIOS:-**
1. Add a new todo item - user enter todo task name and press Enter. Then new todo task should be created in the list
2. Mark a todo as completed - user clicks on checkbox against a particular todo task. Then todo task should be marked as complete.
3. Delete a todo - user clicks on X against a particular todo task. Then todo task should be deleted and not get displayed in the list anymore.
4. Mark all Complete - user click on arrow before the input field to mark all tasks as complete. Then all the active tasks should be marked as complete.
5. Edit the todo task - user double clicks on the todo task name, enter a new task name and press Enter. Then the task in the list should be updated

**NEGATIVE SCENARIOS:-**
1. Enter empty todo task - user tries to create a todo task with empty name. Then no new task should get created
2. Try to click Clear completed when no task is complete - user clicks on Clear Completed when there are no complete task in the list. Then there should be no change.
3. Adding duplicate Todo Item - user adds a todo task with the same name that already exists in the list.
   This is not working as expected in the application (it allows duplicate todo task creation) Therefore this test scenario would always FAIL which is valid since it is a bug.
5. Edit existing task to empty task name - user double clicks on an existing task and try to save the task with empty name. Then no change should be made to the existing task
