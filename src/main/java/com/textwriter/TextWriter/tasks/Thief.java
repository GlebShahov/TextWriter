package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.POJO.BackPack;
import com.textwriter.TextWriter.POJO.Thing;

import java.util.Random;

public class Thief {

    private BackPack backPack;
    private String name;

    public Thief(String name, int maxWeight) {
        this.name = name;
        backPack = new BackPack(maxWeight);
    }

    public String getName() {
        return name;
    }

    public BackPack getBackPack() {
        return backPack;
    }
}


