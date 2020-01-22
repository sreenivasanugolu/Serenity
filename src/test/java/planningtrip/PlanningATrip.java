package planningtrip;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
public class PlanningATrip {

    @Managed
    WebDriver browser;


    Actor tracey;


    @Before
    public void setStage(){
        tracey = Actor.named("Tracey");
        tracey.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void  book_A_Ticket(){

        tracey.has(ChosenTo.bookATicket());
        tracey.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );

        tracey.should(
                eventually(
                seeThat("verifies departure station ", OutboundJourneySummary.origin(),
                        Matchers.is("London Paddington"))).waitingForNoLongerThan(15).seconds()
        );

        tracey.should(
                seeThat("verifies destination station", OutboundJourneySummary.destination(),
                Matchers.is("Oxford"))
        );
    }
}
