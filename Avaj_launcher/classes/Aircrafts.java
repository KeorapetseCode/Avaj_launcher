//import Flyable.java;
package classes;
//import classes.Coordinates;

public class Aircrafts {
        protected long id;
        protected String name;
        protected Coordinates coordinates;
        private long idCounta;

    protected void aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.idCounta = nextId();
    }

    private long nextId(){
        return idCounta += 1;
    }

    public long gettaL() {
        return idCounta;
    }
}


/*
public class JetPlane extends Aircrafts {
    
}

public class Baloon extends Aircrafts {

}
*/