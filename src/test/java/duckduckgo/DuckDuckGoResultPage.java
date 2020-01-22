package duckduckgo;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class DuckDuckGoResultPage extends PageObject {
    public static final String RESULT_TITLE = ".result__title";

    public List<String> getDisplayedResults() {
       /* return findAll(RESULT_TITLE)
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());*/
        return findAll(RESULT_TITLE)
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

   @Step("#actor")
    public String getTheResultSnippet(String keyword) {

        return findBy("//div[contains(@class,'result__body') and contains(.,'{0}')]", keyword)
                .then().findBy(".result__snippet")
                .then().getText();
    }
}
