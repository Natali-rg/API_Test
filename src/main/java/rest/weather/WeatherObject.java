package rest.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class WeatherObject {
    @JsonProperty("temperature")
    public String temp;
    public String wind;
    public String description;
    public ArrayList<Forecast> forecast;
}


