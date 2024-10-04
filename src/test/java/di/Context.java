package di;

import java.util.HashMap;
import java.util.Map;
import factory.BrowserFactory;
import pages.HomePage;
import pages.ToDoListPage;

public class Context extends BrowserFactory {
    private static Map<String, String> todoList;
    private HomePage homePage;
    private ToDoListPage toDoListPage;

    public Context() {
        todoList = new HashMap<>();
    }

    public static Map<String, String> getDataMap() {
        return todoList;
    }

    public void setData(String key, String value) {
        todoList.put(key, value);
    }

    public void updateData(String key, String oldValue, String newValue){
        todoList.replace(key, oldValue, newValue);
    }

    public String getData(String key) {
        return todoList.get(key);
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public ToDoListPage getToDoListPage() {
        if (toDoListPage == null) {
            toDoListPage = new ToDoListPage(driver);
        }

        return toDoListPage;
    }
}
