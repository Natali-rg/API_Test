package rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class RestApiGet {//подключиться как клиент отправить запрос и получить респонс
    static HttpResponse response;

    public static String getWeather(String url) {

        String stringResponse;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();//создаём клиента
        try {
            response = httpClient.execute(new HttpGet(url));
//            System.out.println(response.toString());
            stringResponse = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringResponse;
    }

    public static int getResponseCode() {
      return response.getStatusLine().getStatusCode();
    }

    /*@Test
    public void Test() {
        System.out.println(getWeather("https://goweather.herokuapp.com/weather/dnipro"));

    }*/
}
