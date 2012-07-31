package ge.lanmaster.pattern;

public class Fan implements Switch{

    public void switchOn() {
        System.out.println("FAN Switched ON");
    }

    public void switchOff() {
        System.out.println("FAN Switched OFF");
    }
}
