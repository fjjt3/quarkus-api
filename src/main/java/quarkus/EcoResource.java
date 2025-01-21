package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.Optional;

@Path("/greeting")
public class EcoResource {

    @GET
    public String getGreeting(@QueryParam("message")String message) {
       return Optional.ofNullable(message).orElse("Ich weiss nicht was sagen");

    }

    @GET
    @Path("/{name}")
    public String greeting(@PathParam("name")String name) {
        return "Hallo " + name + "!";
    }

    /*@GET
    @Path("/morgen")
    public String getMorgen() {
        return "Guten Morgen";
    }*/
}
