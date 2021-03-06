package com.ffbit.jaxrs.hello.resources;

import com.ffbit.jaxrs.hello.dto.Group;
import com.ffbit.jaxrs.hello.dto.User;
import com.ffbit.jaxrs.hello.ext.http.method.MY_METHOD;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

/**
 * Created by ffbit on 4/11/14.
 */
@Path("groups")
public class GroupsResource {

    @Context
    private Configuration configuration;

    @GET
    @Path("{id}")
    public Group get(@PathParam("id") Integer id) {
        return new Group();
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
