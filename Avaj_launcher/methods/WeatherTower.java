package methods;
import classes.Coordinates;
//import methods.Tower;
import classes.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }
}