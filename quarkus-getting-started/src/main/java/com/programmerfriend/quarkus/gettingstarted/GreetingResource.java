package com.programmerfriend.quarkus.gettingstarted;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private GreetingService greetingService;

    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        return greetingService.greeting(name);
    }


    @GET
    @Path("async")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> helloAsync(@QueryParam("name") String name) {
        return CompletableFuture.supplyAsync(() -> {
            return greetingService.greeting(name);
        });
    }
}