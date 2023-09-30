
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements Runnable {

    ObjectInputStream ois;
    String Name;

    ReaderThread(ObjectInputStream ois, String name){
        this.ois = ois;
        this.Name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {

                Object received = ois.readObject();

                System.out.println(Name + " Got: " + (String) received);

            } catch (ClassNotFoundException | IOException e) {

            }
        }
    }
}