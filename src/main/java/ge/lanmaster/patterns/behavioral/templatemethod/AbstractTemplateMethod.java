package ge.lanmaster.patterns.behavioral.templatemethod;

public abstract class AbstractTemplateMethod {

	abstract protected String buildHeader();

	abstract protected String buildBody();

	abstract protected String buildFooter();

	/*
	 * The template method.
	 */
	public final String buildMessage() {
		StringBuilder message = new StringBuilder();
		message.append(buildHeader());
		message.append(buildBody());
		message.append(buildFooter());
		return message.toString();
	}

}
