package planningtrip;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OutboundJourneySummary {
    public static final Target ORIGIN = Target.the("Departure")
            .located(By.xpath("(//div[@class='ChosenTicket']/descendant::span[@class='ChooseInfoDetails'])[1]"));
    public static final Target DESTINATION = Target.the("Departure")
            .located(By.xpath("(//div[@class='ChosenTicket']/descendant::span[@class='ChooseInfoDetails'])[2]"));

    public static Question<String> origin() {
        return actor -> Text.of(ORIGIN).viewedBy(actor).asString();
    }

    public static  Question<String> destination() {
        return actor -> Text.of(DESTINATION).viewedBy(actor).asString();
    }
}