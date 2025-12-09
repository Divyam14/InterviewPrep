package Serialization;

import java.io.*;

public class ParentNotSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Child child = new Child();

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("child.ser"));
        oos.writeObject(child);
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("child.ser"));
        Child c = (Child) ois.readObject();
        ois.close();
    }


}

class Parent {
    Parent() {
        System.out.println("Parent constructor called");
    }
}

class Child extends Parent implements Serializable {
        private static final long serialVersionUID = 1L;
        int value = 10;
    }
