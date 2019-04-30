package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.Main;
import com.textwriter.TextWriter.POJO.Thing;

import java.util.List;

public class ThiefTask implements Runnable {
    private Home home;
    private Thief thief;

    public ThiefTask( Thief thief, Home home) {
        this.home = home;
        this.thief = thief;
    }

    @Override
    public void run() {

            //входим в дом
            home.enterHome(thief);
            //получаем вещи в доме
            // получаем вещи в рюкзаке
            List<Thing> backpackThings = thief.getKnapsack().getBestThings();
            // Смешиваем вещи в кучу в доме и чистим рюкзак
            home.putThing(backpackThings);
            thief.getKnapsack().getBestThings().clear();
            // получаем список всех вещей
            List<Thing> homeThings = home.getThings();
            // смотрим какие вещи нужны
            thief.getKnapsack().makeAllSets(homeThings);
            System.out.println("Че там по рюкзаку в кгешечках " + thief.getKnapsack().getMaxWeight());
            List<Thing> solve = thief.getKnapsack().getBestThings();
            //     List<Thing> neededThings = solveTask(homeThings);
            Main.sleep(500, 1000);//имитация работы, иначе очень быстро
            // забираем их в рюкзак
            System.out.println(thief.getName() + " забрал вещи " + solve);
            thief.getKnapsack().getBestThings().addAll(solve);
            home.removeThings(solve);
            //выходим из дома
            home.exitHome(thief);
            //спим до следующего залезания в дом раза
            Main.sleep(2000, 5000);


    }

}

