package ge.lanmaster.patterns.structural.Adapter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
	public static void main(String[] args) {
		System.out.println("Adapter Pattern");

		Button ok = new Button("OK");
		ok.addActionListener(
				//Example.
				//ActionListener is an interface. We implement it in a unnamed
				//inner class. Each time in a manner appropriate for the case.
				new ActionListener() {
					public void actionPerformed(ActionEvent actionEvent) {
						System.out.println("Adapter Pattern example works.");
					}
				}
				//End of example.
		);
	}
}
