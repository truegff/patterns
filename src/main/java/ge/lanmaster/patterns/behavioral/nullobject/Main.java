package ge.lanmaster.patterns.behavioral.nullobject;

public class Main {

	public static void main(String[] args) {

		System.out.println("NullObject Pattern");

		warningDialogRouter().routeWarning("asdf");

		ignoreRouter().routeWarning("asdf");

	}

	private static WarningRouter ignoreRouter() {
		return new IgnoreWarning();
	}

	private static WarningRouter warningDialogRouter() {
		return new WarningDialog();
	}

}
