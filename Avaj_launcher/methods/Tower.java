
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
    if (Simulator.unReg != null) {
        unregister(Simulator.unReg);
        Simulator.unReg = null;
    }
    
    for (Flyable dl : this.observers){
        dl.updateConditions();
    }
    /*
    if (this.observers.isEmpty() == true){
        System.out.println("Array is now empty " + this.observers.size());
        System.exit(0);
    }*/
    }
}