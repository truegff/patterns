package ge.lanmaster.patterns.structural.Bridge.pattern.switchcontrol;

public class Bulb implements SwitchControl {
	public void switchOn() {
		System.out.println("BULB Switched ON");
	}

	public void switchOff() {
		System.out.println("BULB Switched OFF");
	}
}
