import models.Handler;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(2000);
        server.startServer();

    }
}
