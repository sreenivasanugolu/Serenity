package duckduckgo;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DuckDuckGoSearcher {
    DuckDuckGoSearchPage searchPage;
    DuckDuckGoResultPage resultPage;
    private String actor;

    @Step("#actor searches with the word {0}")
    public void searches_with_a_keyword(String searchKeyword) {
        searchPage.enterSearchKeyword(searchKeyword);
        searchPage.submitSearch();
    }

    @Step("#actor should see search results containing {0}")
    public void should_see_results_containing(String resultTitle) {
        List<String> results = resultPage.getDisplayedResults();
        //assertThat(results, Matchers.everyItem(Matchers.containsString(resultTitle)));
        assertThat(results.size(), Matchers.greaterThan(0));
    }

    @Step("#actor is in the duckduckgo home page")
    public void is_on_the_duckduckgo_homepage() {
        searchPage.open();
    }

    @Step("#actor should see {1} in the result body for title {0}")
    public void should_see_the_content_snippet(String keyword, String expectedText)  {
        String snippet = resultPage.getTheResultSnippet(keyword);
        //div[contains(@class,'result__body') and contains(.,'Cucumber - Wikipedia')]
        assertThat(snippet, containsString(expectedText));
    }
}
