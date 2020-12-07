package ge.lanmaster.patterns.behavioral.mediator;

import ge.lanmaster.patterns.behavioral.mediator.mediated.DesktopColleague;
import ge.lanmaster.patterns.behavioral.mediator.mediated.MobileColleague;
import ge.lanmaster.patterns.behavioral.mediator.mediator.ApplicationMediator;

public class Main {

	public static void main(String[] args) {

		System.out.println("Mediator Pattern");

		ApplicationMediator mediator = new ApplicationMediator();

		MobileColleague mobile = new MobileColleague(mediator);
		mediator.addColleague(mobile);

		DesktopColleague desktop = new DesktopColleague(mediator);
		mediator.addColleague(desktop);

		mobile.send("Hello from mobile!");

		desktop.send("Hello from desktop!");

	}

}
