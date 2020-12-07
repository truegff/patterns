package ge.lanmaster.patterns.behavioral.nullobject;

public class IgnoreWarning implements WarningRouter {

	public boolean routeWarning(String msg) {
		System.out.println("IgnoreWarning " + msg);
		return true;
	}

}
