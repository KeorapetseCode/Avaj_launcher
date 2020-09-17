package classes;
import methods.Flyable;
import methods.LogOutput;
import methods.WeatherTower;
import java.lang.Long;
import methods.Simulator;

public class Helicopter extends Aircrafts implements Flyable{

    private WeatherTower weatherObj;

    public Helicopter(String name, Coordinates coordinates) {
        String[] temp = null;
        
        temp = name.split(" ", 2);
        this.name = temp[0];
        //temp[1] = temp[1].replace("H", "");
        this.id = Long.parseLong(temp[1]);
        //System.out.println("Name is " + name);
        this.coordinates = coordinates;
        
    }

//    @Override
    public void updateConditions() {
        //System.out.println("dsdfdsfsdf");
        String weather = weatherObj.getWeather(this.coordinates);
        int tempLong = this.coordinates.getLongitude();
        int tempLat = this.coordinates.getLatitude();
        int tempHeight = this.coordinates.getHeight();

        if (weather.equals("RAIN")) {
            tempLong += 5;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("Helicopter" + this.name + "("+ this.id + ")" + " It is RAINING for the Heli " + "\n");
        }
        else if (weather.equals("FOG")) {
            tempLong += 1;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("Helicopter" + this.name + "("+ this.id + ")" + " It is FOGY for the Heli " + "\n");
        }
        else if (weather.equals("SUN")) {
            tempLong += 10;
            tempHeight += 2;
            if (tempHeight > 100) {
                tempHeight = 100;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("Helicopter" + this.name + "("+ this.id + ")" + " It is SUNNY for the Heli " + "\n");
        }
        else if (weather.equals("SNOW")) {
            tempHeight -= 12;
            if (tempHeight < 1){
                tempHeight = 0;
                String temp = "(" + Long.toString(this.id) + ")";
                LogOutput.msgUnReg("Helicopter"+this.name, temp);
                LogOutput.logMesg.add("Helicopter" + this.name + "("+ this.id + ")" + " This Heli is landing " + "\n" + LogOutput.msgUnReg("Helicopter"+this.name, temp));

                Simulator.unReg = this;
            }
            else{
                this.coordinates.coordinates(tempLong, tempLat, tempHeight);
                LogOutput.logMesg.add("Helicopter" + this.name + "("+ this.id + ")" + " It is SNOWING for the Heli " + "\n");
            }
        }
    }

    public void registerTower(WeatherTower weatherObj) {
        this.weatherObj = weatherObj;
    }
}