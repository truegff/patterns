package ge.lanmaster.pattern.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author alexander
 */
public class SecurityNotifier {
    private ArrayList observers = new ArrayList();

    public void AddObserver(SecurityObserver observer) {
        observers.add(observer);
    } // addObserver(SecurityObserver)

    public void removeObserver(SecurityObserver observer) {
        observers.remove(observer);
    } // removeObserver(SecurityObserver)

    // is private in common, but is set public here
    // for demonstration purposes
    public void notify(int device, int event) {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            SecurityObserver next = (SecurityObserver)iterator.next();
            next.notify(device, event);
        }
    }

}
