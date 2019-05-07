package com.textwriter.TextWriter;

import java.util.Random;

public class RandomGenerate {
    static Random random = new Random();

    public static int generateKnapsackWeight(){
        return random.nextInt(20)+1;
    }

    public static void sleep(int start, int end) {
        try {
            int sleep = start + random.nextInt(end - start);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static int generateThingWeight(){
        return random.nextInt(15)+1;
    }

    public static int generateThingCoast(){
        return random.nextInt(15000)+500;
    }

    public static int generateRandomThings(){
        return random.nextInt(8)+1;
    }
}
