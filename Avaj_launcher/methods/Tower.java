
package methods;
import java.util.ArrayList;
//import java.util.Iterator;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyObj) {
        this.observers.add(flyObj);
    }

    public void unregister(Flyable flyObj) {
        this.observers.remove(flyObj);
    }

    protected void conditionsChange() {
        int i = 0;
        int len = Simulator.unReg.size();
        
        while (i < len){
            unregister(Simulator.unReg.get(i));
            i++;
        }
        for (Flyable dl : this.observers){
            dl.updateConditions();
        }
    }
}