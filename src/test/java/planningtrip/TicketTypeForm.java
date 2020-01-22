package planningtrip;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TicketTypeForm {
    public static final Target FROM = Target.the("Departure station")
            .located(By.xpath("(//input[contains(@class,'LocationFromTo')])[1]"));
    public static final Target TO = Target.the("Destination station")
            .located(By.xpath("(//input[contains(@class,'LocationFromTo')])[2]"));
    public static final Target SEARCH = Target.the("Destination station")
            .located(By.xpath(" //span[@class='TravelSearch Button']/descendant::span[text()='Search']"));
}
