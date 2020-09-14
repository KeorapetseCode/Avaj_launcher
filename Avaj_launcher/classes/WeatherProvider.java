package classes;
import java.util.Random;
import classes.Coordinates;

public class WeatherProvider {
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static WeatherProvider weatherProvider = null; 
    
    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        String errMsg = "Cannot generate weather because of height";
        if (coordinates.getHeight() <= 0) {
            return errMsg;
        }
        else if (coordinates.getHeight() > 0) {
            Random random = new Random();
            return weather[random.nextInt(4)];
        }
        return errMsg;
    }
}
