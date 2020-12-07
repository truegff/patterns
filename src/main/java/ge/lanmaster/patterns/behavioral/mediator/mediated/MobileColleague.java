package ge.lanmaster.patterns.behavioral.mediator.mediated;

import ge.lanmaster.patterns.behavioral.mediator.mediator.Mediator;

public class MobileColleague extends Colleague {

	public MobileColleague(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void receive(String message) {
		System.out.println("Mobile received: " + message);
	}

}
