package com.textwriter.TextWriter.POJO;

import java.util.Random;

public class Thing {
    private int weight;
    private int cost;

    public Thing(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return weight + " кг / " + cost + " руб.";
    }
}
