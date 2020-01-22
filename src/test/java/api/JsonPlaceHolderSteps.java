package api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.hamcrest.Matchers;
import org.junit.Before;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class JsonPlaceHolderSteps {

    Actor tom;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        //actor = Actor.named("Tommy").whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com"));
        tom = Actor.named("Tommy").whoCan(CallAnApi.at("http://localhost:8080/api"));
    }

    @Given("post data")
    public void post_data() throws URISyntaxException {
        tom = Actor.named("Tommy").whoCan(CallAnApi.at("http://localhost:8080/api"));

        //File jsonFile = new File("src/test/resources/jsondata/client.json");
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("src/test/resources/jsondata/client.json").toURI());

        tom.attemptsTo(
                Post.to("/client")
                    .with(request -> request.header("Content-Type", "application/json")
                            .body(path.toFile())));
                            //body("{\"email\":\"sree@abc.com\",\"firstName\": \"sree\",\"lastName\": \"Smith\"}")));
    }

    @When("success code is 201")
    public void successCode() {
        tom.should(
                seeThatResponse("The user should have been successfully added",
                        response -> response.statusCode(200))
        );

    }

    @Then("assert for name")
    public void id_is_created() {
        tom.should(
                seeThatResponse(response -> response
                        .body("firstName", Matchers.equalTo("sree")))
        );

    }

}





