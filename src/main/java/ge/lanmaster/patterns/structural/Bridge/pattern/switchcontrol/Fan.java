package ge.lanmaster.patterns.structural.Bridge.pattern.switchcontrol;

public class Fan implements SwitchControl {

    public void switchOn() {
        System.out.println("FAN Switched ON");
    }

    public void switchOff() {
        System.out.println("FAN Switched OFF");
    }

}
