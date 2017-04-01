package integration;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class GameCentreIT {

    @Test
    public void testCalculate24() throws Exception {
        final String url = "http://127.0.0.1:8080/calculate24?a=3&b=3&c=8&d=8";
        final HttpUriRequest request = new HttpGet(url);
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);
        final String result = EntityUtils.toString(response.getEntity());
        assertEquals("(8.0/(3.0-(8.0/3.0)))\n", result);
        assertEquals(HttpStatus.OK.value(), response.getStatusLine().getStatusCode());
    }

}