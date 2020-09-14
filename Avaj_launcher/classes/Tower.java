
package classes;
import methods.Flyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyObj) {
        this.observers.add(flyObj);
    }

    public void unregister(Flyable flyObj) {
        this.observers.remove(flyObj);
    }

    protected void conditionsChange() {
        
    }
}