package com.flipkart.homepage.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;


public class Search extends PageObject {
    public static final Target SEARCH_INPUT = Target.the("search input field")
            .located(By.xpath("//input[@name='q']"));

    public static final Target CATEGORIES = Target.the("search input field")
            .located(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));

    public static final Target ELECTRONICS = Target.the("search input field")
            .located(By.xpath("(//span[@class='_1QZ6fC _3Lgyp8'])[1]"));




    public static Question<String> getSearchDefaultText() {
       return TheTarget.attributeNamed("placeholder").forTarget(SEARCH_INPUT);
    }

    public static Question<List<String>> getCategories() {
       return TheTarget.textValuesOf(CATEGORIES);
    }

    public static Performable mouseOver(String electronics) {
        return Task.where("hovers mouse on menu item",
                MoveMouse.to(ELECTRONICS)
        );
    }
}
