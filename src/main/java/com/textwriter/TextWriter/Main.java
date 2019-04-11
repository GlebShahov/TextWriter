package com.textwriter.TextWriter;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        writing();
    }

    public static void writing(){
        try{
            File textFile = new File ("C:/Doc/something.txt");
            FileOutputStream is = new FileOutputStream(textFile);
            OutputStreamWriter streamWriter = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(streamWriter);


            w.write("F");
            w.close();
        }
        catch (IOException e){
            System.out.println("Something going bad");
        }
        finally {
            System.out.println("You DO IT! or not)");
        }
    }

}
