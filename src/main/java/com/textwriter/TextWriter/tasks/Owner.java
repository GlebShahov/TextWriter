package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.POJO.Thing;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    List<Thing> things;
    private String name;

    public Owner(String name) {
        this.name = name;
        things = new ArrayList<Thing>();
    }

    public String getName() {
        return name;
    }

    public List<Thing> getThings() {
        return things;
    }
}