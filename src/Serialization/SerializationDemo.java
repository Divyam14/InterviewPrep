package Serialization;

import java.io.*;

public class SerializationDemo {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("divyam",28,"123456");

        FileOutputStream fos = new FileOutputStream("user.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);

        FileInputStream fis = new FileInputStream("user.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User deserialUser = (User) ois.readObject();

        System.out.println(deserialUser);
    }

}
