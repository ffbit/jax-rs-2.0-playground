package com.ffbit.jaxrs.hello.dto;

import com.ffbit.jaxrs.hello.resources.GroupsResource;
import com.ffbit.jaxrs.hello.resources.UsersResource;
import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ffbit on 4/11/14.
 */
public class User {
    private int id;
    private String name;
    private Group group;

    @InjectLinks({
            @InjectLink(resource = UsersResource.class, style = Style.ABSOLUTE,
                    rel = "self", method = "get", type = MediaType.APPLICATION_JSON),
            @InjectLink(resource = GroupsResource.class, style = Style.ABSOLUTE,
                    rel = "groups", method = "get", type = MediaType.APPLICATION_JSON,
                    bindings = {@Binding(name = "id", value = "${instance.group.id}")})
    })
    private List<Link> links;

    private User() {
        group = new Group();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


}
