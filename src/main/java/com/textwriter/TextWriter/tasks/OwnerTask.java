package com.textwriter.TextWriter.tasks;

import com.textwriter.TextWriter.Home;
import com.textwriter.TextWriter.Main;
import com.textwriter.TextWriter.POJO.Thing;
import com.textwriter.TextWriter.RandomGenerate;

public class OwnerTask implements Runnable {

    private Home home;
    private Owner owner;

    public OwnerTask(Owner owner, Home home) {
        this.home = home;
        this.owner = owner;
    }

    @Override
    public void run() {
            while (true) {
                //генерируем 1 вещь, чтобы положить ее в дом
               for (int i = 0; i < RandomGenerate.generateRandomThings(); i++) {
                    Thing thing = new Thing(RandomGenerate.generateThingWeight(), RandomGenerate.generateThingCoast());
                    owner.getThings().add(thing);
                }
                //входим в дом
                home.enterHome(owner);
                //кладем вещи в дом
                home.putThing(owner.getThings());
                System.out.println(owner.getName() + " положил вещь " + owner.getThings());
                System.out.println("Дома уже вещей " + home.getThings());
                RandomGenerate.sleep(500, 1000);//иначе очень быстро
                // убираем из рюкзака
                owner.getThings().clear();
                //выходим из дома
                home.exitHome(owner);
                //спим до следующего раза
                //
                RandomGenerate.sleep(3000, 5000);

            }
    }
}
