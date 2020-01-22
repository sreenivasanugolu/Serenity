package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@RunWith(SerenityRunner.class)
public class ApiTest {

    Actor sam;

    @Before
    public void setStage(){
        sam = Actor.named("Sam the api tester").whoCan(CallAnApi.at("http://localhost:8080/api"));
    }

    @Test
    public void postdata(){
        File jsonFile = new File("src/test/resources/jsondata/client.json");
        sam.attemptsTo(
                Post.to("/client")
                .with(request -> request.header("Content-Type", "application/json")
                .body(jsonFile))
        );
        sam.should(
                seeThatResponse("The user should have been successfully added",
                        response -> response.statusCode(200))
        );
        sam.should(
                seeThatResponse(response -> response
                        .body("firstName", Matchers.equalTo("sree")))
        );
    }
}
