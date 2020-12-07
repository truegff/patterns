package ge.lanmaster.patterns.behavioral.mediator.mediated;

import ge.lanmaster.patterns.behavioral.mediator.mediator.Mediator;

public abstract class Colleague {
	private Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		mediator.send(message, this);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public abstract void receive(String message);

}
