# Java Design Patterns – Interview Notes

---

## 1. What are Design Patterns?

**Design patterns** are proven, reusable solutions to common software design problems. They are **not** code you copy-paste, but **templates** for solving recurring problems.

### Why are they important in interviews?

* Show that you can write **maintainable, extensible, testable** code
* Show that you understand **object-oriented design** beyond syntax
* Many frameworks (Spring, Hibernate, etc.) are built using these patterns

---

## 2. Main Categories of Design Patterns (GoF)

1. **Creational Patterns** – Object creation
2. **Structural Patterns** – Object composition (how classes/objects are structured)
3. **Behavioral Patterns** – Object interaction & responsibility

---

## 3. Creational Patterns

Creational patterns deal with **how objects are created** while hiding creation logic from the client.

### 3.1 Singleton

**Intent:** Ensure a class has **only one instance** and provide a global access point to it.

**Use When:**

* You need a single, shared resource (e.g., configuration, logger, cache)

**Key Points:**

* Private constructor
* Static instance
* Global `getInstance()` method
* Thread safety & lazy initialization are common interview follow-ups

```java
public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

**Interview topics:**

* How can Singleton be broken? (Reflection, Serialization, Cloning)
* How to fix it? (Enum Singleton, defensive code)

---

### 3.2 Factory Method

**Intent:** Define an interface for creating an object, but let subclasses decide which class to instantiate.

**Use When:**

* You want to delegate the responsibility of object creation
* You don’t want client code to depend on concrete classes

```java
interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() { /* ... */ }
}

class SmsNotification implements Notification {
    public void notifyUser() { /* ... */ }
}

class NotificationFactory {
    public static Notification getNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
```

**Benefits:**

* Loose coupling between client and concrete classes

---

### 3.3 Abstract Factory

**Intent:** Provide an interface for creating **families of related objects** without specifying their concrete classes.

**Use When:**

* You need to create related objects that must be used together
* Example: GUI toolkit that creates WindowsButton, WindowsTextbox vs LinuxButton, LinuxTextbox

**Difference from Factory Method:**

* Factory Method → creates **one** type of product
* Abstract Factory → creates **families** of products

---

### 3.4 Builder

**Intent:** Separate the construction of a complex object from its representation.

**Use When:**

* Object has many optional parameters
* Telescoping constructor problem

```java
class User {
    private final String username;
    private final String email;
    private final int age;

    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.age = builder.age;
    }

    public static class Builder {
        private String username;
        private String email;
        private int age;

        public Builder username(String username) { this.username = username; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder age(int age) { this.age = age; return this; }

        public User build() { return new User(this); }
    }
}
```

**Benefits:**

* Readable, flexible object creation
* Immutable objects

---

### 3.5 Prototype

**Intent:** Create new objects by **cloning existing objects** (prototypes).

**Use When:**

* Object creation is expensive or complex
* You want to avoid subclass explosion

**Java Support:**

* `Cloneable` interface and `clone()` method

---

## 4. Structural Patterns

Structural patterns deal with **how classes and objects are composed** to form larger structures.

### 4.1 Adapter

**Intent:** Convert the interface of a class into another interface clients expect.

> Also known as **Wrapper**.

**Use When:**

* You want to integrate a legacy or third-party class with a different interface

```java
interface MediaPlayer {
    void play(String fileName);
}

class AdvancedPlayer {
    void playMp4(String fileName) { /*...*/ }
}

class MediaAdapter implements MediaPlayer {
    private AdvancedPlayer advancedPlayer = new AdvancedPlayer();

    public void play(String fileName) {
        advancedPlayer.playMp4(fileName);
    }
}
```

---

### 4.2 Decorator

**Intent:** Add responsibilities to objects **dynamically** without modifying their code.

**Use When:**

* You want to add features at runtime
* You want to avoid subclass explosion

```java
interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {
    public double cost() { return 50; }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }
    public double cost() { return coffee.cost() + 10; }
}
```

**Real Examples:**

* `java.io` stream classes (e.g., `BufferedInputStream`, `DataInputStream`)

---

### 4.3 Facade

**Intent:** Provide a **simple interface** to a complex subsystem.

**Use When:**

* You want to hide complexity
* You want to provide a unified entry point

**Real Example:**

* A service class calling multiple DAOs and utilities

---

### 4.4 Proxy

**Intent:** Provide a **surrogate** or placeholder for another object to control access to it.

**Types of Proxies:**

* Virtual Proxy (lazy loading)
* Protection Proxy (access control)
* Remote Proxy (remote object representation)

**Real Examples:**

* Java dynamic proxies (`java.lang.reflect.Proxy`)
* Spring AOP proxies

---

### 4.5 Composite

**Intent:** Treat individual objects and compositions of objects **uniformly**.

**Use When:**

* You represent part-whole hierarchies (tree structures)

**Real Example:**

* Directory–File structure in OS

---

## 5. Behavioral Patterns

Behavioral patterns deal with **how objects interact** and how responsibilities are distributed.

### 5.1 Strategy

**Intent:** Define a family of algorithms, encapsulate each one, and make them interchangeable.

**Use When:**

* You have multiple ways of doing something (algorithms)
* You want to switch algorithms at runtime

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) { /* ... */ }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) { /* ... */ }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
}
```

**Benefits:**

* Avoids `if-else`/`switch` hell
* Follows **Open/Closed Principle**

---

### 5.2 Observer

**Intent:** Define a one-to-many dependency so that when one object’s state changes, all dependents are notified.

**Use When:**

* Event handling, pub-sub, notification systems

**Real Examples:**

* GUI listeners (`ActionListener`)
* Spring Application Events

---

### 5.3 Template Method

**Intent:** Define the skeleton of an algorithm in a method, deferring some steps to subclasses.

**Use When:**

* You have an algorithm with invariant structure but variable steps

**Real Examples:**

* `HttpServlet` (`doGet`, `doPost`)

---

### 5.4 Command

**Intent:** Encapsulate a request as an object.

**Use When:**

* You want to queue, log, undo/redo operations

**Real Examples:**

* GUI buttons mapped to command objects

---

### 5.5 Chain of Responsibility

**Intent:** Pass a request along a chain of handlers until one handles it.

**Use When:**

* You want to decouple sender and receiver
* Many possible handlers

**Real Examples:**

* Servlet filters
* Spring Security filter chain

---

### 5.6 State

**Intent:** Allow an object to change its behavior when its internal state changes.

**Use When:**

* Object’s behavior depends on its state (e.g., traffic light, order lifecycle)

---

### 5.7 Iterator

**Intent:** Provide a way to access elements of a collection sequentially without exposing its underlying representation.

**Java Example:**

* `Iterator<E>` interface

---

### 5.8 Mediator

**Intent:** Define an object that encapsulates how a set of objects interact.

**Use When:**

* You want to reduce complex many-to-many communication

---

### 5.9 Visitor

**Intent:** Separate an algorithm from the object structure on which it operates.

**Use When:**

* You need to perform operations on a complex object structure without modifying the classes

---

## 6. Summary Table

| Category   | Patterns (Common in Interviews)                                                                           |
| ---------- | --------------------------------------------------------------------------------------------------------- |
| Creational | Singleton, Factory Method, Abstract Factory, Builder, Prototype                                           |
| Structural | Adapter, Decorator, Facade, Proxy, Composite, Flyweight                                                   |
| Behavioral | Strategy, Observer, Command, Template Method, Chain of Responsibility, State, Iterator, Mediator, Visitor |

---

## 7. Common Interview Questions

1. Difference between **Factory Method** and **Abstract Factory**?
2. How to implement **thread-safe Singleton** in Java?
3. Real-world example of **Strategy** pattern.
4. How does **Decorator** differ from **Inheritance**?
5. Explain a design pattern used in **Spring Framework**:

    * Singleton (Spring beans default scope)
    * Proxy (AOP)
    * Template Method (JdbcTemplate)
    * Factory (BeanFactory, ApplicationContext)

---

✅ These notes cover definitions, use-cases, and Java-centric hints tailored for interviews. You can ask for **deep dives or code demos** for any specific pattern next (e.g., "Strategy + Observer full example").
