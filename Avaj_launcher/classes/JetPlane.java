package classes;
import methods.Flyable;
import methods.LogOutput;
import methods.WeatherTower;
import java.lang.Long;
import methods.Simulator;

public class JetPlane extends Aircrafts implements Flyable {
    
    private WeatherTower weatherObj;

    public JetPlane(String name, Coordinates coordinates){
        String[] temp = null;

        temp = name.split(" ", 2);
        this.name = temp[0];
        this.id = Long.parseLong(temp[1]);
        this.coordinates = coordinates;
    }

    public void updateConditions(){
        String weather = weatherObj.getWeather(this.coordinates);
        int tempLong = this.coordinates.getLongitude();
        int tempLat = this.coordinates.getLatitude();
        int tempHeight = this.coordinates.getHeight();

        if (weather.equals("RAIN")){
            tempLat += 5;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("JetPlane" + this.name + "(" + this.id + ")" + "Jet Is experencing RAIN" + "\n");
        }
        else if (weather.equals("FOG")){
            tempLong += 1;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("JetPlane" + this.name + "(" + this.id + ")" + "Jet Is experiencing FOG" + "\n");
        }
        else if (weather.equals("SUN")) {
            tempLat += 10;
            tempHeight += 2;
            if (tempHeight > 100){
                tempHeight = 100;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("JetPlane" + this.name + "(" + this.id + ")" + "Jet Is expereincing SUNshine" + "\n");
        }
        else if (weather.equals("SNOW")) {  
            tempHeight -= 7;
            if (tempHeight < 1){
                tempHeight = 0;
                String temp = "(" + Long.toString(this.id) + ")";
                //LogOutput.msgUnReg("JetPlane"+this.name, temp);
                LogOutput.logMesg.add("JetPlane" + this.name + "("+ this.id + ")" + "The JetPlane is landing..." + "\n" + LogOutput.msgUnReg("JetPlane"+this.name, temp));
                Simulator.unReg = this;
            }
            else{
                this.coordinates.coordinates(tempLong, tempLat, tempHeight);
                LogOutput.logMesg.add("JetPlane" + this.name + "(" + this.id + ")" + "Jet is experiencing cold Snowy conditions" + "\n");
            }
        }
    }

    public void registerTower(WeatherTower weatherObj) {
        this.weatherObj = weatherObj;
    }
}
