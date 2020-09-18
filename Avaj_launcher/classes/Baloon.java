package classes;
import methods.Flyable;
import methods.LogOutput;
import methods.WeatherTower;
import java.lang.Long;

import methods.Simulator;

public class Baloon extends Aircrafts implements Flyable {
    
    private WeatherTower weatherObj;

    public Baloon(String name, Coordinates coordinates){
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
            tempHeight -= 5;
            if (tempHeight < 1){
                tempHeight = 0;
                String temp = "(" + Long.toString(this.id) + ")";
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "This Baloon has to land it is not safe" + "\n" + LogOutput.msgUnReg("Baloon"+this.name, temp));
                Simulator.unReg = this;
            }
            else{
                this.coordinates.coordinates(tempLong, tempLat, tempHeight);
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "Baloon engine is getting wet" + "\n");
            }
        }
        else if (weather.equals("FOG")){
            tempHeight -= 3;
            if (tempHeight < 1){
                tempHeight = 0;
                String temp = "(" + Long.toString(this.id) + ")";
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "This Baloon has to land we can't see" + "\n" + LogOutput.msgUnReg("Baloon"+this.name, temp));
                Simulator.unReg = this;
            }
            else{
                this.coordinates.coordinates(tempLong, tempLat, tempHeight);
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "Baloon is fogged out!" + "\n");
            }
        }
        else if (weather.equals("SUN")) {
            tempLong += 2;
            tempHeight += 4;
            if (tempHeight > 100){
                tempHeight = 100;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "Baloon is Sky high in the clear Sky" + "\n");
        }
        else if (weather.equals("SNOW")) {
            tempHeight -= 15;
            if (tempHeight < 1){
                tempHeight = 0;
                String temp = "(" + Long.toString(this.id) + ")";
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "Baloon engine froze!!" + "\n" + LogOutput.msgUnReg("Baloon"+this.name, temp));
                Simulator.unReg = this;
            }
            else{
                this.coordinates.coordinates(tempLong, tempLat, tempHeight);
                LogOutput.logMesg.add("Baloon" + this.name + "(" + this.id + ")" + "The Snow is too heavy for the baloon" + "\n");
            }
        }
    }

    public void registerTower(WeatherTower weatherObj) {
        this.weatherObj = weatherObj;
    }

}