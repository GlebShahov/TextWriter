package com.textwriter.TextWriter.POJO;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Thing> bestThings;
    private int maxWeight;
    private int bestPrice;


    public List<Thing> getBestThings() {
        return bestThings;
    }

    public int getMaxWeight() {
        return maxWeight;
    }



    public Knapsack(int maxWeight){
        this.maxWeight = maxWeight;
        this.bestThings = new ArrayList<Thing>();
    }

    private int sumWeight(List<Thing> things) {
        int sumWeight = 0;

        for(Thing thing: things) {
            sumWeight += thing.getWeight();
        }

        return sumWeight;
    }
    //вычисляет общую стоимость набора предметов
    private int sumCoast(List<Thing> things) {
        int sumCoast = 0;

        for(Thing thing: things) {
            sumCoast += thing.getCost();
        }

        return sumCoast;
    }
    //проверка, является ли данный набор лучшим решением задачи
    private void checkSet(List<Thing> things) {
        if (bestThings == null) {
            if (sumWeight(things) <= maxWeight) {
                bestThings = things;
                bestPrice = sumCoast(things);
            }
        }
        else {
            if(sumWeight(things) <= maxWeight && sumCoast(things) > bestPrice) {
                bestThings = things;
                bestPrice = sumCoast(things);
            }
        }
    }
    //создание всех наборов перестановок значений
    public void makeAllSets(List<Thing> things) {
        if (things.size() > 0)
            checkSet(things);

        for (int i = 0; i < things.size(); i++) {
            List<Thing> newSet = new ArrayList<Thing>(things);

            newSet.remove(i);

            makeAllSets(newSet);
        }
    }
}




