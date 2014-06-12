package com.ffbit.jaxrs.hello.resources;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.ffbit.jaxrs.hello.dto.Greeting;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
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
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return new ResourceConfig()
                .packages("com.ffbit.jaxrs.hello.resources", "com.fasterxml.jackson.jaxrs.json");
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyTestContainerFactory();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        /**
         * There was no need to this in Jersey 2.7,
         * but in Jersey 2.9 something went wrong.
         */
        config.register(JacksonJsonProvider.class);
        super.configureClient(config);
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
