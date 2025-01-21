package quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Path("/temperaturas")
public class TemperaturasResource {

    private TemperaturaService temperaturas;

    @Inject
    public TemperaturasResource(TemperaturaService temperaturas) {
        this.temperaturas = temperaturas;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura nueva(Temperatura temp) {
        temperaturas.addTemperatura(temp);
        return temp;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list() {
        return temperaturas.getTemperaturas();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/one")
    public Temperatura medicion(){
        return new Temperatura("Estepona", 8 ,18);
    }

    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima(){
       if(temperaturas.isEmpty()){
           return Response.status(404).entity("No hay temperaturas").build();
       }else {
           int temperaturaMaxima = temperaturas.maximaTemperatura();
           return Response.ok(Integer.toString(temperaturaMaxima)).build();
       }
    }
}
