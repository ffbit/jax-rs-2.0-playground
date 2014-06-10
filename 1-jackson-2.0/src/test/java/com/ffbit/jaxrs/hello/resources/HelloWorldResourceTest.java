package com.ffbit.jaxrs.hello.resources;

import com.ffbit.jaxrs.hello.dto.Greeting;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig()
                .packages("com.ffbit.jaxrs.hello.resources", "com.ffbit.jaxrs.hello.providers");
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyTestContainerFactory();
    }

    @Test
    public void itShouldReturnTextPlainResponse() throws Exception {
        String response = target()
                .path("hello")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertThat(response, is("Hello World!"));
    }

    @Test
    public void itShouldReturnApplicationJsonResponse() throws Exception {
        Greeting response = target()
                .path("hello")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Greeting.class);

        assertThat(response, is(new Greeting("Hello World!")));
    }

}
