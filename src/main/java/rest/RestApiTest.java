package rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import rest.weather.WeatherObject;

public class RestApiTest {
    String url="https://goweather.herokuapp.com/weather/";
    String url1="https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&json";
    String city="dnipro";
    @Test
    public void Test(){
        String s=RestApiGet.getWeather(url+city);
        System.out.println("Response code:"+RestApiGet.getResponseCode());
        JSONObject jsonObject=new JSONObject(s);
        System.out.println(jsonObject.get("temperature"));
        JSONArray array=new JSONArray(jsonObject.getJSONArray("forecast"));
        for (int i=0; i<array.length();i++){
            JSONObject microjson= (JSONObject) array.get(i);
            int day=i+1;
            System.out.println("Day "+day);
            System.out.println(microjson.get("wind"));
            System.out.println(microjson.get("temperature"));
        }
    }

    @Test
    public void Test2() throws JsonProcessingException {
        String s=RestApiGet.getWeather(url+"kiev");
        WeatherObject myObject=new ObjectMapper().readValue(s,WeatherObject.class);
        System.out.println(myObject.description);
    }



}
