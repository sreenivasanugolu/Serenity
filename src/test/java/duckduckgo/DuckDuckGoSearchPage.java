package duckduckgo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://duckduckgo.com")
public class DuckDuckGoSearchPage extends PageObject {

    @FindBy( id = "search_form_input_homepage")
    WebElementFacade searchField;

   @FindBy( id = "search_button_homepage")
    WebElementFacade searchButton;

    public void enterSearchKeyword(String searchKeyword) {
        find(By.id("search_form_input_homepage")).type(searchKeyword);
        searchField.type(searchKeyword);
    }

    public void submitSearch() {
        searchButton.click();
    }
}
