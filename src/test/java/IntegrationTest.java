import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class IntegrationTest {

    @Test
    public void getTest() throws IOException {
        URL urlObj = new URL("http://localhost:2000/rand/new/10");
        HttpURLConnection connection = (HttpURLConnection)urlObj.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        }
        InputStream response = connection.getInputStream();
        String answer = new java.util.Scanner(response).nextLine();
        Assert.assertTrue(Integer.parseInt(answer)<10);
    }
}
