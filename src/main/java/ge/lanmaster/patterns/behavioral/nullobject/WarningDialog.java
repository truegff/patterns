package ge.lanmaster.patterns.behavioral.nullobject;

import javax.swing.*;

public class WarningDialog implements WarningRouter {

	public boolean routeWarning(String warning) {
		int r = 0;
		r = JOptionPane.showConfirmDialog(null,
				warning,
				"Warning",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		System.out.println("WarningDialog " + warning);
		return r == 0;
	}

}
