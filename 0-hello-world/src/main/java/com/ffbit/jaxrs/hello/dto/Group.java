package com.ffbit.jaxrs.hello.dto;

/**
 * Created by ffbit on 4/15/14.
 */
public class Group {
    private int id;
    private String name;

    public Group() {
        id = 5;
        name = "";
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

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
