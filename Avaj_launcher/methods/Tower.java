
package methods;
//import methods.Flyable;
import java.util.ArrayList;
//import java.util.Iterator;

//import classes.Aircrafts;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyObj) {
        this.observers.add(flyObj);
    }

    public void unregister(Flyable flyObj) {
        this.observers.remove(flyObj);
    }

    protected void conditionsChange() {
    System.out.println("Pinting each");
    if (Simulator.unReg != null) {
        unregister(Simulator.unReg);
    }
    for (Flyable dl : this.observers){
        dl.updateConditions();
    }
    }
}