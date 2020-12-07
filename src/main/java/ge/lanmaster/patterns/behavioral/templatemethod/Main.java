package ge.lanmaster.patterns.behavioral.templatemethod;

public class Main {
	public static void main(String[] args) {
		System.out.println("TemplateMethod Pattern");

		System.out.println();
		System.out.println("HtmlMessageBuilder.buildMessage()");
		AbstractTemplateMethod html = new HtmlMessageBuilder();
		System.out.println(html.buildMessage());

		System.out.println();
		System.out.println("SoapMessageBuilder.buildMessage()");
		AbstractTemplateMethod soap = new SoapMessageBuilder();
		System.out.println(soap.buildMessage());
	}
}
