package com.textwriter.TextWriter.POJO;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
    private List<Thing> things;
    private int maxWeight;
    private int bestCoast;


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

    private double sumWeigth(List<Thing> things) {
        double sumW = 0;

        for(Thing thing: things) {
            sumW += thing.getWeight();
        }

        return sumW;
    }

//вычисляет общую стоимость набора предметов
    private double sumCost(List<Thing> things) {
        double sumC = 0;

        for(Thing thing: things) {
            sumC += thing.getCost();
        }

        return sumC;
    }


//проверка, является ли данный набор лучшим решением задачи
    private void сheckSet(List<Thing> things) {
        if (this.things == null){
            if (sumWeigth(things) <= maxWeight){
                this.things = things;
                bestCoast = (int) sumCost(things);
            }
        }
        else {
            if(sumWeigth(things) <= maxWeight && sumCost(things) > bestCoast) {
                this.things = things;
                bestCoast = (int) sumCost(things);
            }
        }
    }

//создание всех наборов перестановок значений
    public void makeAllSets(List<Thing> things){
        if (things.size() > 0)
            сheckSet(things);

        for (int i = 0; i < things.size(); i++) {
            List<Thing> newSet = new ArrayList<Thing>(things);

            newSet.remove(i);

            makeAllSets(newSet);
        }

    }





}
