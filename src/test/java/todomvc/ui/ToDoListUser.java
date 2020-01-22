package todomvc.ui;

import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ToDoListUser {

    HomePage todomvcHomePage;
    ToDoList toDoList;

    @Step
    public void startsWithAnEmptyToDoList() {
        todomvcHomePage.open();
    }

    @Step
    public void adds_a_task(String taskName) {
        toDoList.addToDo(taskName);

    }

    @Step
    public void should_see_task(String taskName) {
        assertThat(toDoList.getTodos(), contains(taskName));
    }

    public void should_see_tasks(List<String> tasks) {
        assertThat(toDoList.getTodos(), hasItems(tasks.toString()));
    }
}
