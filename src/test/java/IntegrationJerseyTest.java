import models.Calculator;
import models.RandomNumber;
import models.RestController;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class IntegrationJerseyTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(RestController.class);
    }

    @Test
    public void CalcIntegrationTest(){
        int min=1;
        String resp = target("rand/new/10").request().get(String.class);
        Assert.assertTrue((Calculator.getNewCalc(0,10)>0)&&(Calculator.getNewCalc(0,10)<10));
    }

}
