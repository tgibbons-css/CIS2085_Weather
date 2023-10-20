package weather;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Weather
{
    public static void main(String[] args)
    {
        
    }
    
    public static String retrieveWeatherData()
    {
        String station = "KDLH";
        String url = "https://w1.weather.gov/xml/current_obs/" + station + ".xml";
        String weatherData = "";
        String weatherLine;
        
        try (BufferedReader inFile = new BufferedReader(new InputStreamReader(new URL(url).openStream())))
        {
            // Read in the first line of the weather file.
            weatherLine = inFile.readLine();
            
            // Loop through the entire weather file one line at a time until the end (weatherLine will be null).
            while (weatherLine != null) {
                weatherData += weatherLine + "\n";
                weatherLine = inFile.readLine();
            }
        }
        catch (IOException ioException)
        {
            // If an error occurs, save the error message in the weatherData variable.
            weatherData += ioException;
        }
        
        return weatherData;
    }
}