package com.flipkart.homepage.ui;


import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class NavigateTo {

    @Step("{0} opens the flipkart retail website")
    public static Performable flipkartHomePage() {
        return Open.browserOn().the(FlipkartHomePage.class);
    }
}
