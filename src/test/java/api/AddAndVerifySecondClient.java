package api;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


public class AddAndVerifySecondClient {

    @Before
    public void setBaseURL(){
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @Test
    public void test_using_jsonFile(){
        File jsonFile = new File("src/test/resources/jsondata/client.json");
        SerenityRest.given().contentType("application/json").body(jsonFile).post("/client");
        String clientId = SerenityRest.lastResponse().jsonPath().getString("id");
        ClientDetails clientDetails = SerenityRest.get("/client/{clientId}", clientId).as(ClientDetails.class);
        assertThat(clientDetails.getFirstName()).isEqualTo("sree");

    }
    @Test
    public void test2(){
        File jsonFile = new File("src/test/resources/templates/client.json");
        SerenityRest.given()
                .contentType("application/json")
                .body(jsonFile)
                .post("/client")
                .then().statusCode(200);
        String clientId = SerenityRest.lastResponse().jsonPath().getString("id");


    }

}
