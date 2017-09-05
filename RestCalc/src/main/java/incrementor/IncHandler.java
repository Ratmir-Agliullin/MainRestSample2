package incrementor;

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
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        try {
            System.out.println(getRandomNumber(3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
