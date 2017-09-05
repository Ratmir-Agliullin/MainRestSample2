package incrementor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class IncHandler {
    public static int getRandomNumber(Integer in) throws IOException {
        URL urlObj = new URL("http://localhost:2000/rand/new/"+in.toString());
        HttpURLConnection connection = (HttpURLConnection)urlObj.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        }
           InputStream response = connection.getInputStream();
        String answer = new java.util.Scanner(response).nextLine();
        JSONParser jsonParser = new JSONParser();
        Object obj=null;
        try {
            obj = jsonParser.parse(answer);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        return Integer.parseInt((String) jsonObject.get("value"));
    }

    public static void main(String[] args) {
        try {
            System.out.println(getRandomNumber(3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
