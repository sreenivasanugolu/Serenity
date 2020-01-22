package todomvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import todomvc.ui.ToDoListUser;

import java.util.List;

public class AddNewTaskStepDefinitions {

    @Steps
    ToDoListUser todoUser;

    @Given("^that (?:.*) has an empty todo list$")
    public void that_James_has_an_empty_todo_list() {
        todoUser.startsWithAnEmptyToDoList();
    }

    @Given("^that Jane has a list containing Walk the dog$")
    public void has_a_list_containing() {
        todoUser.startsWithAnEmptyToDoList();
        /*todoUser.startsWithAnEmptyToDoList();
        tasks.forEach(
                task -> todoUser.adds_a_task(task)
        );*/
    }

    @When("^s?he adds (.*) to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) {
        todoUser.adds_a_task(taskName);
    }

    @Then("^(.*) should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName) {
        todoUser.should_see_task(taskName);
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks) {
        todoUser.should_see_tasks(tasks);
    }
}
