import incrementor.RestIncrementController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class IncIntegrationJerseyTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(RestIncrementController.class);
    }

    @Test
    public void CalcIntegrationTest(){
        int min=1;
        String resp = target("rand/new/10").request().get(String.class);
        Assert.assertTrue((Calculator.getNewCalc(0,10)>0)&&(Calculator.getNewCalc(0,10)<10));
    }

}
