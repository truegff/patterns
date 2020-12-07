package ge.lanmaster.patterns.behavioral.mediator.mediator;

import ge.lanmaster.patterns.behavioral.mediator.mediated.Colleague;

public interface Mediator {

	void send(String message, Colleague colleague);

}
