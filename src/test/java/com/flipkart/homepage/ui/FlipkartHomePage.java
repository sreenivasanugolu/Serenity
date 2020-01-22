package com.flipkart.homepage.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://flipkart.com")
public class FlipkartHomePage extends PageObject implements Performable{

    @FindBy(xpath = "//button[contains(@class, '_2AkmmA')]")
    static WebElementFacade popUp_closeIcon;

    public static Performable closesThePopUpIfPresent() {
        return Instrumented.instanceOf(FlipkartHomePage.class).withProperties();
    }

    @Override
    @Step("{0} closes the pop up window if it shows up")
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
                Check.whether(popUp_closeIcon.isPresent())
                        .andIfSo(Click.on(popUp_closeIcon))
        );
    }
}
