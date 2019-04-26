package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.Main;
import com.textwriter.TextWriter.POJO.Thing;

import java.util.ArrayList;
import java.util.List;

public class ThiefTask implements Runnable {
    Home home;
    Thief thief;

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
            List<Thing> backpackThings = thief.getBackPack().getThings();
            // Смешиваем вещи в кучу в доме и чистим рюкзак
            home.putThing(backpackThings);
            thief.getBackPack().getThings().clear();
            // получаем список всех вещей
            List<Thing> homeThings = home.getThings();
            // смотрим какие вещи нужны
            List<Thing> neededThings = solveTask(homeThings);
       //     Main.sleep(500, 1000);//имитация работы, иначе очень быстро
            // забираем их в рюкзак
            System.out.println(thief.getName() + " забрал вещи " + neededThings);
            thief.getBackPack().getThings().addAll(neededThings);
            home.removeThings(neededThings);
            //выходим из дома
            home.exitHome(thief);
            //спим до следующего захода в дом
         //   Main.sleep(2000, 5000);

    }
    // на вход вещи из которых нужно выбрать, на выход вещи которые засунуться в рюкзак
    private List<Thing> solveTask(List<Thing> things) {
        
        return new ArrayList<Thing>(things);
    }
}
