package ge.lanmaster.patterns.behavioral.mediator.mediator;

import ge.lanmaster.patterns.behavioral.mediator.mediated.Colleague;

import java.util.LinkedList;
import java.util.List;

public class ApplicationMediator implements Mediator {
	private List<Colleague> colleagues;

	public ApplicationMediator() {
		colleagues = new LinkedList<>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	@Override
	public void send(String message, Colleague originator) {
		for (Colleague colleague : colleagues) {
			if (colleague != originator) {
				colleague.receive(message);
			}
		}
	}

}
