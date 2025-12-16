package Serialization;

import java.io.*;

public class SingletonBreakDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Singleton singleObj =  Singleton.INSTANCE;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(singleObj);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        Singleton s = (Singleton) ois.readObject();

        System.out.println("Are singleton objects equal? : " + (s == singleObj));

    }
}

class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Singleton INSTANCE = new Singleton();

    private Singleton(){

    }

    //fix singleton break
    // Comment this to see singleton break
    @Serial
    private Object readResolve(){
        return INSTANCE;
    }
}
