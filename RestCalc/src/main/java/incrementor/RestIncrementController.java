package incrementor;

import incrementor.Incrementor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("inc")
public class RestIncrementController {

    @GET
    @Path("start/{arg1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInc(@PathParam("arg1") int arg){
        int res = Incrementor.Increment(arg);
        return String.valueOf(res);
    }

}
