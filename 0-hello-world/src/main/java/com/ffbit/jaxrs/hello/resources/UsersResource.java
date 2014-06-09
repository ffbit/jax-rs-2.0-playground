package com.ffbit.jaxrs.hello.resources;

import com.ffbit.jaxrs.hello.dto.User;
import com.ffbit.jaxrs.hello.ext.http.method.MY_METHOD;
import org.glassfish.jersey.client.filter.EncodingFeature;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.message.internal.JerseyLink;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.WadlFeature;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by ffbit on 4/11/14.
 */
@Path("users")
public class UsersResource {

    @Context
    private Configuration configuration;

    @GET
    @Path("{id}")
    public User get(@PathParam("id") Integer id) {
        return new User(id, "John Doe");
    }

    @GET
    public List<User> list() {
        return Collections.emptyList();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(User user) {
//        dao.save(user);
        return Response.ok(user).build();
    }

    //.links(userLinks(user)).

    private Link[] userLinks(User user) {
//        Link.Builder b = new Link.Builder().
//        UriBuilder builder = UriBuilder.fromPath("/customers/{id}"); builder.scheme("http")
//                .host("{hostname}") .queryParam("param={param}");
//        builder.
//
//
//        return new Link[]{builder.build()};
        return null;
    }

    @MY_METHOD
    public String myMethod() {
        return "Hello with MY_METHOD";
    }

}
