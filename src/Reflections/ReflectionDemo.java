package Reflections;

import java.lang.reflect.Field;

public class ReflectionDemo {


    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz = Class.forName("java.lang.String");

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackage());

        //getFields() → only public fields (including inherited)
        //getDeclaredFields() → all fields (private included)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()+" "+field.getType());
        }
    }
}
