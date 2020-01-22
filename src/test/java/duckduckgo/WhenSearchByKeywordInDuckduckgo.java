package duckduckgo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenSearchByKeywordInDuckduckgo {

    @Managed(uniqueSession = true)
    WebDriver driver;

   @Steps
   DuckDuckGoSearcher sam;

   @Before
   public void setStage(){
       sam.is_on_the_duckduckgo_homepage();
   }

    @Test
    public void should_see_relevant_search_results(){

        sam.searches_with_a_keyword("Cucumber recipes");
        sam.should_see_results_containing("ecipe");
    }
    @Test
    public void should_see_content_snippet()  {
        sam.searches_with_a_keyword("Cucumber");
        sam.should_see_the_content_snippet("Cucumber - Wikipedia",
                "The cucumber is a creeping vine that roots in the ground and grows up trellises");
    }


}
