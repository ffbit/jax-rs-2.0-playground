package com.ffbit.jaxrs.hello.providers;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ext.Provider;

@Provider
public class JsonProvider extends JacksonJsonProvider {
}
