package com.textwriter.TextWriter.POJO;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
    private List<Thing> things;
    private int maxWeight;




    public BackPack(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public List<Thing> getThings() {
        return things;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int knapsack(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (things.get(i).getWeight() > W) {
            return knapsack(i-1, W);
        } else {
            return Math.max(knapsack(i-1, W), knapsack(i-1, W - things.get(i).getWeight()) + things.get(i).getCost());
        }
    }

}
