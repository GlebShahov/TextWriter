package com.textwriter.TextWriter;


import com.textwriter.TextWriter.POJO.Thing;
import com.textwriter.TextWriter.tasks.Owner;
import com.textwriter.TextWriter.tasks.OwnerTask;
import com.textwriter.TextWriter.tasks.Thief;
import com.textwriter.TextWriter.tasks.ThiefTask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static Random r = new Random();

    public static void sleep(int start, int end) {
        try {
            int sleep = start + r.nextInt(end - start);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        Home home = new Home();
        ExecutorService es = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 4; i++) {
            es.execute(new OwnerTask(new Owner("Владелец_" + i), home));
        }
        for (int i = 0; i < 5; i++) {
            es.execute(new ThiefTask(new Thief("Вор_" + i, (i + 3) * 5), home));
        }
        es.shutdown();
    }

}
