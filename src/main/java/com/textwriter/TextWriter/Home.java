package com.textwriter.TextWriter;


import com.textwriter.TextWriter.POJO.Thing;
import com.textwriter.TextWriter.tasks.Owner;
import com.textwriter.TextWriter.tasks.Thief;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Home {
    private List<Thing> things = Collections.synchronizedList(new ArrayList<Thing>());
    private final Object syncObj = new Object();
    private int ownerCount = 0;
    private boolean thiefInHome = false;

    public List<Thing> getThings() {
        return things;
    }

    public void putThing(List<Thing> things){
        this.things.addAll(things); //без синхронизации, так как коллекция синхронизированная
    }

    public void removeThings(List<Thing> things){
        this.things.removeAll(things); // вор крадет вещь
    }

    public void enterHome(Owner owner){
        synchronized (syncObj){
            while (true){
                if(thiefInHome) {
                    System.out.println(owner.getName() + " не может зайти, вор в доме. Ждем пока выйдет");
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(owner.getName() + " вхожу в дом. В доме " + (ownerCount + 1) + " владельцев");
                    ownerCount++;
                    return;
                }
            }
        }
    }

    public void exitHome(Owner owner){
        synchronized (syncObj){
            System.out.println(owner.getName() + " выхожу из дома");
            System.out.println("Количество владельцев в доме " + ownerCount + " -> " + (ownerCount - 1));
            ownerCount--;
            if (ownerCount == 0) {
                System.out.println("В доме не осталось владельцев");
                syncObj.notifyAll();
            }
        }
    }

    public void enterHome(Thief thief){
        synchronized (syncObj){
            while (true){
                if(thiefInHome){
                    System.out.println(thief.getName() + " не может зайти, вор в доме. Ждем пока выйдет");
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                    }
                }
                else if (ownerCount != 0){
                    System.out.println(thief.getName() + " не может зайти, хозяева в доме. Ждем пока выйдут");
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    System.out.println(thief.getName() + " вхожу в дом");
                    thiefInHome = true;
                    return;
                }
            }
        }
    }

    public void exitHome(Thief thief){
        synchronized (syncObj){
            System.out.println(thief.getName() + " выхожу из дома");
            thiefInHome = false;
            syncObj.notifyAll();
        }
    }

}











