package com.ffbit.jaxrs.hello.app;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(org.glassfish.jersey.linking.DeclarativeLinkingFeature.class);
    }

}
