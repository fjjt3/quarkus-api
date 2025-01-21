package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("/temperaturas")
public class TemperaturasResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list() {
        return Arrays.asList(
                new Temperatura("Estepona", 8 ,18),
                new Temperatura("Córdoba", 9 ,25),
                new Temperatura("Sevilla", 7 ,26)
        );
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/one")
    public Temperatura medicion(){
        return new Temperatura("Estepona", 8 ,18);
    }
}
