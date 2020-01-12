package com.programmerfriend.quarkus.gettingstarted;

import com.programmerfriend.quarkus.gettingstarted.rest.Fruit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/fruit")
public class FruitResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit hello(@QueryParam("name") String name) {
        return new Fruit("Banana", "a yellow fruit");
    }
}