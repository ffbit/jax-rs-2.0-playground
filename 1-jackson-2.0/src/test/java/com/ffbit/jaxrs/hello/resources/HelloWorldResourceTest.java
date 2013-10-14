package com.ffbit.jaxrs.hello.resources;

import com.ffbit.jaxrs.hello.dto.Greeting;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.client.ClientFactory;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldResourceTest extends JerseyTest {

    public HelloWorldResourceTest() throws TestContainerException {
        super("com.ffbit.jaxrs.hello.resources", "com.ffbit.jaxrs.hello.providers");

    }

    @Test
    public void itShouldReturnTextPlainResponse() throws Exception {
        String response = resource()
                .path("hello")
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertThat(response, is("Hello World!"));
    }

    @Test
    public void itShouldReturnApplicationJsonResponse() throws Exception {
        Greeting response = resource()
                .path("hello")
                .accept(MediaType.APPLICATION_JSON)
                .get(Greeting.class);

        assertThat(response, is(new Greeting("Hello World!")));
    }

}
