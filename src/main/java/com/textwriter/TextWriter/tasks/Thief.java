package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.POJO.Knapsack;

public class Thief {

    private Knapsack knapsack;
    private String name;

    public Thief(String name, int maxWeight) {
        this.name = name;
        knapsack = new Knapsack(maxWeight);
    }

    public String getName() {
        return name;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }
}


