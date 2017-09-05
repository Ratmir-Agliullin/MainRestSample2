import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

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
        String answer = new Scanner(response).nextLine();
        JSONParser jsonParser = new JSONParser();
        Object obj=null;
        try {
           obj = jsonParser.parse(answer);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        Assert.assertTrue(Integer.parseInt((String) jsonObject.get("value"))<10);
    }
}
