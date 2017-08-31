import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Server {
    private org.eclipse.jetty.server.Server server;

    public org.eclipse.jetty.server.Server getServer() {
        return server;
    }

    public Server(int port) {
        ResourceConfig config = new ResourceConfig();
        config.packages("models");
        server = new org.eclipse.jetty.server.Server(port);
    }

    public void startServer() {
        ResourceConfig config = new ResourceConfig();
        config.packages("models");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        ServletContextHandler context = new ServletContextHandler(getServer(), "/*");
        context.addServlet(servlet, "/*");
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }
    }

    public void stopServer(){
        server.destroy();
    }
}
