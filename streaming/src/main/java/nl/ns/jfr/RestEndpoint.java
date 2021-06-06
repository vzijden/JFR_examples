package nl.ns.jfr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hiRick")
public class RestEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {

        return "hiVincent";
    }
}
