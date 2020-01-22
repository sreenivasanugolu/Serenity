package whenplanningatrip;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import todomvc.ui.HomePage;
import whenplanningatrip.ui.TravelHomePage;

public class WhenPlanningATrip {

   @Managed
    WebDriver browser;
    Actor tracey = Actor.named("Tracey");
    private TravelHomePage travelHomePage;


    @Before
    public void setStage(){
        tracey.can(BrowseTheWeb.with(browser));
        tracey.attemptsTo(Open.browserOn().the(travelHomePage),
                TravelHomePage.closeTheCookiesWindowsIfPresent()
        );
    }

    @Test
    public void verify_title(){

    }
}
