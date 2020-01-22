package whenplanningatrip.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://tfl.gov.uk")
public class TravelHomePage extends PageObject implements Performable {
    public static final Target ACCEPT_COOKIES = Target.the("Accept Cookies")
            .located(By.linkText("Accept all cookies"));
    public static final Target DONE = Target.the("Done button")
            .located(By.linkText("Done"));
    public static final Target SEARCH = Target.the("Search field").located(By.id("q"));

    @FindBy(xpath = "//strong[text()='Accept all cookies']")
    public  static WebElementFacade COOKIE_WINDOW ;

    public static Performable closeTheCookiesWindowsIfPresent() {
        return Instrumented.instanceOf(TravelHomePage.class).withProperties();
    }

    @Step("#actor closes the pop up window if present")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(COOKIE_WINDOW.isDisplayed()).andIfSo(Click.on(COOKIE_WINDOW)),
                Click.on(DONE)
        );

    }
}
