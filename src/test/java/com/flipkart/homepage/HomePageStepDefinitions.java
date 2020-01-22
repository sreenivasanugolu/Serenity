package com.flipkart.homepage;

import com.flipkart.homepage.ui.FlipkartHomePage;
import com.flipkart.homepage.ui.NavigateTo;
import com.flipkart.homepage.ui.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import static com.flipkart.homepage.ui.FlipkartHomePage.closesThePopUpIfPresent;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class HomePageStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    FlipkartHomePage flipkartHomePage;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the flipkart home page$")
    public void the_user_is_on_the_home_page(String user) {
        theActorCalled(user).attemptsTo(navigateTo.flipkartHomePage(), closesThePopUpIfPresent());
    }

    @Then("^The default text on the search field should be (.*)$")
    public void default_text_on_the_search_field_is(String defaultText) {
        theActorInTheSpotlight().should(seeThat("verifies default text",
                Search.getSearchDefaultText(), Matchers.equalTo(defaultText)
        ));
        theActorInTheSpotlight().should(seeThat(
                Search.getCategories(),
                hasItems("Electronics", "TVs & Appliances", "Men", "Women", "Baby & Kids", "Home & Furniture", "Sports, Books & More")
                ));
        theActorInTheSpotlight().should(seeThat(
                Search.getCategories(), hasSize(7)
        ));
        theActorInTheSpotlight().attemptsTo(
                Search.mouseOver("Electronics")
        );

    }
}
