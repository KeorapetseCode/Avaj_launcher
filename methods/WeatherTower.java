package methods;
import classes.Coordinates;
//import classes.Tower;
import classes.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }
}