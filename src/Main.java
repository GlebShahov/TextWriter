import javax.imageio.IIOException;
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
            w.write("Hello");
            ((BufferedWriter) w).newLine();
            w.write("My name is Rudik");
            ((BufferedWriter) w).newLine();
            w.write("LuntiK");
            ((BufferedWriter) w).newLine();
            w.write("Putin");
            ((BufferedWriter) w).newLine();
            w.write("Funtik");
            ((BufferedWriter) w).newLine();
            w.write("Would you like");
            ((BufferedWriter) w).newLine();
            w.write("a cup of tea");
            ((BufferedWriter) w).newLine();
            w.write("who i am");
            ((BufferedWriter) w).newLine();
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
