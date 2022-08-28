package rest.exchangeRates;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;
import rest.weather.WeatherObject;

import java.io.IOException;

public class ExchangeRates {//HomeWork
    public int r030;
    public String txt;
    public double rate;
    public String cc;
    public String exchangedate;

    static HttpResponse response;

    public static String getRates(String url) {

        String stringResponse;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            response = httpClient.execute(new HttpGet(url));
//            System.out.println(response.toString());
            stringResponse = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringResponse.replace("[", "").replace("]", "");
    }

    @Test
    public void TestRateEUR() throws JsonProcessingException {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&json";
        String s = ExchangeRates.getRates(url);
        ExchangeRates myER = new ObjectMapper().readValue(s, ExchangeRates.class);
        System.out.println("Rate EUR: "+myER.rate);
    }
    @Test
    public void TestRateUSD() throws JsonProcessingException {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json";
        String s = ExchangeRates.getRates(url);
        ExchangeRates myER = new ObjectMapper().readValue(s, ExchangeRates.class);
        System.out.println("Rate USD: "+myER.rate);
    }
    @Test
    public void TestRateRUB() throws JsonProcessingException {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=RUB&json";
        String s = ExchangeRates.getRates(url);
        ExchangeRates myER = new ObjectMapper().readValue(s, ExchangeRates.class);
        System.out.println("Rate RUB: "+myER.rate);
    }
}
