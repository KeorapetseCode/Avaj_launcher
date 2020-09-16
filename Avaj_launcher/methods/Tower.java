
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
        //unregister message
        this.observers.remove(flyObj);
    }

    protected void conditionsChange() {
    //System.out.println("output IS ");
    
    for (Flyable dl : this.observers){
        dl.updateConditions();
    }
    /*Iterator<Flyable> iterVar = observers.iterator();
    while (iterVar.hasNext()){
        System.out.println("output IS " + i);
        i++;
    }*/
    }
}