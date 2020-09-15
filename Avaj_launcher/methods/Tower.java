
package methods;
import methods.Flyable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyObj) {
        this.observers.add(flyObj);
    }

    public void unregister(Flyable flyObj) {
        //unregister message
        this.observers.remove(flyObj);
    }

    protected void conditionsChange() {
    
}
}