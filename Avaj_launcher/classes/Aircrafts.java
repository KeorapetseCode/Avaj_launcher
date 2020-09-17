//import Flyable.java;
package classes;
//import classes.Coordinates;

public class Aircrafts {
    
    private long nextId(){
        return idCounta++;
    }

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounta = nextId();

    protected void aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.idCounta = nextId();
    }

    
}


/*
public class JetPlane extends Aircrafts {
    
}

public class Baloon extends Aircrafts {

}
*/