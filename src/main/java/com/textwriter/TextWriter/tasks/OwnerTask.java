package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.Main;
import com.textwriter.TextWriter.POJO.Thing;

public class OwnerTask implements Runnable {

    private Home home;
    private Owner owner;

    public OwnerTask(Owner owner, Home home) {
        this.home = home;
        this.owner = owner;
    }

    @Override
    public void run() {

            //генерируем 1 вещь, чтобы положить ее в дом
            Thing thing = new Thing(2 + Main.r.nextInt(15), 3 + Main.r.nextInt(20000));
            owner.getThings().add(thing);
            //входим в дом
            home.enterHome(owner);
            //кладем вещи в дом
            home.putThing(owner.getThings());
            System.out.println(owner.getName() + " положил вещь " + thing);
           // Main.sleep(500, 1000);//иначе очень быстро
            // убираем из рюкзака
            owner.getThings().clear();
            //выходим из дома
            home.exitHome(owner);
            //спим до следующего раза
           // Main.sleep(3000, 5000);

    }
}
