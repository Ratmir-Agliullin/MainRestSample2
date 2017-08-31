package models;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("rand")
public class RestController {

    @GET
    @Path("new/{arg1}")
    @Produces(MediaType.APPLICATION_JSON)
    public String calc(@PathParam(value = "arg1") int a){
  RandomNumber randomNumber = new RandomNumber();
       return randomNumber.newNumber(a);

    }

}
