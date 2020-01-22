package planningtrip;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChosenTo implements Task {
    public static Performable bookATicket() {
        return instrumented(ChosenTo.class);
    }

    @Override
    @Step("{0} goes to the tickets website")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Mainmenu.BuyTickets.getUrl())
        );
    }
}
