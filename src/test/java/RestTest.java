import models.Calculator;
import models.Handler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RestTest {

    @Mock
    Handler handler;

    @Test
    public void CalcTest(){
        Assert.assertTrue((Calculator.getNewCalc(0,10)>0)&&(Calculator.getNewCalc(0,10)<1));
    }
}
