package Serialization;

import java.io.*;

public class CustomSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Account acc = new Account("divyam", "mypwd");
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("acc.ser"));
        oos.writeObject(acc);
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("acc.ser"));
        Account a = (Account) ois.readObject();
        ois.close();

        System.out.println(a.username);
        System.out.println(a.password);


    }
}

class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    String username;
    transient String password;

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF("Encrypted-"+password);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        String encryptedPass = ois.readUTF();
        this.password = encryptedPass.replace("Encrypted-", "");
    }
}
