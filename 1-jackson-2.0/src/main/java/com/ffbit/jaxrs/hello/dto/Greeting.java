package com.ffbit.jaxrs.hello.dto;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Greeting {
    private String message;

    public Greeting(String body) {
        this();
        this.message = body;
    }

    public Greeting() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greeting greating = (Greeting) o;

        if (message != null ? !message.equals(greating.message) : greating.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message +
                '}';
    }

}
