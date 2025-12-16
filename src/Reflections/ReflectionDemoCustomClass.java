package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ReflectionDemo.java
 *
 * Single-file demo showing common reflection operations on a custom class.
 */
public class ReflectionDemoCustomClass {

    // Custom class used for reflection demos.
    // Not public so it can live in the same file as the demo.
    static class Person {
        private String name;
        private int age;

        // Private constructor to demonstrate reflective creation
        private Person() {
            this.name = "Private Person";
            this.age = -1;
        }

        // Public constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void sayHello() {
            System.out.println("Hello! My name is " + name + " and I'm " + age + " years old.");
        }

        private void incrementAge(int delta) {
            this.age += delta;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        try {
            // 1) Obtain Class objects in three ways
            Class<Person> clsCompile = Person.class; // compile-time
            Person p1 = new Person("Alice", 30);
            Class<? extends Person> clsFromObject = p1.getClass(); // from object
            Class<?> clsForName = Class.forName("Reflections.ReflectionDemoCustomClass$Person"); // by name (note nested class name)

            System.out.println("Class names:");
            System.out.println(" - compile: " + clsCompile.getName());
            System.out.println(" - from object: " + clsFromObject.getName());
            System.out.println(" - forName: " + clsForName.getName());
            System.out.println();

            // 2) List declared fields (including private) and their modifiers
            System.out.println("Declared fields:");
            Field[] fields = clsCompile.getDeclaredFields();
            for (Field f : fields) {
                System.out.printf("  %s %s (modifiers=%s)%n",
                        f.getType().getSimpleName(),
                        f.getName(),
                        Modifier.toString(f.getModifiers()));
            }
            System.out.println();

            // 3) List declared methods
            System.out.println("Declared methods:");
            Method[] methods = clsCompile.getDeclaredMethods();
            for (Method m : methods) {
                System.out.printf("  %s %s(%s) (modifiers=%s)%n",
                        m.getReturnType().getSimpleName(),
                        m.getName(),
                        paramsToString(m.getParameterTypes()),
                        Modifier.toString(m.getModifiers()));
            }
            System.out.println();

            // 4) Access and modify a private field
            Field nameField = clsCompile.getDeclaredField("name");
            nameField.setAccessible(true); // bypass private
            System.out.println("Before change: " + p1);
            nameField.set(p1, "Bob"); // change private field
            System.out.println("After change:  " + p1);
            System.out.println();

            // 5) Invoke a public method reflectively
            Method sayHello = clsCompile.getMethod("sayHello"); // public method
            System.out.println("Invoking public method sayHello():");
            sayHello.invoke(p1); // should print greeting
            System.out.println();

            // 6) Invoke a private method reflectively
            Method increment = clsCompile.getDeclaredMethod("incrementAge", int.class);
            increment.setAccessible(true);
            System.out.println("Invoking private method incrementAge(5) on p1");
            increment.invoke(p1, 5);
            System.out.println("After increment: " + p1);
            System.out.println();

            // 7) Create an object using the private constructor
            Constructor<Person> privateCtor = clsCompile.getDeclaredConstructor(); // private no-arg
            privateCtor.setAccessible(true);
            Person p2 = privateCtor.newInstance();
            System.out.println("Instance created via private ctor: " + p2);
            // Show we can call methods on that reflectively-created instance
            sayHello.invoke(p2);
            System.out.println();

            // 8) Demonstrate constructor with parameters reflectively
            Constructor<Person> paramCtor = clsCompile.getConstructor(String.class, int.class); // public ctor
            Person p3 = paramCtor.newInstance("Charlie", 22);
            System.out.println("Instance created via public paramctor: " + p3);
            sayHello.invoke(p3);
            System.out.println();

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            System.err.println("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println("Method/Constructor not found: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            System.err.println("Reflection operation failed: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    // small helper to format parameter types
    private static String paramsToString(Class<?>[] types) {
        if (types == null || types.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(types[i].getSimpleName());
        }
        return sb.toString();
    }
}

