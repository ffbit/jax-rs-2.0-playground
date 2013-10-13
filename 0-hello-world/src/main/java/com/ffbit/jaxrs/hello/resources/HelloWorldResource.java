package com.ffbit.jaxrs.hello.resources;

import com.ffbit.jaxrs.hello.dto.Greeting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloText() {
        return "Hello World!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting helloJson() {
        return new Greeting("Hello World!");
    }

}
