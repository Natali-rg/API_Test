package HomeWork.exchangeRates;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ReteApiGet {
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
}
