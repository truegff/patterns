package ge.lanmaster.patterns.behavioral.mediator.mediated;

import ge.lanmaster.patterns.behavioral.mediator.mediator.Mediator;

public class DesktopColleague extends Colleague {

	public DesktopColleague(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void receive(String message) {
		System.out.println("Desktop received: " + message);
	}
}
