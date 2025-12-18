# Factory vs Factory Method – Ultimate Interview Notes (Java)

## 0. What Is GoF?
**GoF** stands for **Gang of Four**.

It refers to the four authors:
- Erich Gamma
- Richard Helm
- Ralph Johnson
- John Vlissides

They wrote the famous book:
> **“Design Patterns: Elements of Reusable Object-Oriented Software”**

This book introduced **23 classic design patterns**, categorized into:
- Creational
- Structural
- Behavioral

⚠ **Only patterns described in this book are called GoF patterns.**

---

## 1. Simple Factory (Not a GoF Pattern)

### 1.1 What Is Simple Factory?
> Simple Factory is a design approach where a single factory class creates objects based on input conditions.

⚠ Simple Factory is **NOT** a GoF pattern.  
It is a **commonly used design idiom**.

### Key Idea
- Centralize object creation
- Client does not use `new`
- Factory decides which object to create using conditionals

---

## 1.2 Problem Without Simple Factory

```java
if (type.equals("CARD")) {
    new CardPayment();
} else if (type.equals("UPI")) {
    new UpiPayment();
}
```

### Problems
- Tight coupling
- Client knows all concrete classes
- Violates Open–Closed Principle
- Hard to maintain and test

---

## 1.3 Simple Factory Structure
```
Client → SimpleFactory → Concrete Products
```

---

## 1.4 Simple Factory Example

### Product Interface
```java
public interface Payment {
    void pay();
}
```

### Concrete Products
```java
public class CardPayment implements Payment {
    public void pay() {
        System.out.println("Card payment");
    }
}
```

```java
public class UpiPayment implements Payment {
    public void pay() {
        System.out.println("UPI payment");
    }
}
```

### Factory Class
```java
public class PaymentFactory {

    public static Payment getPayment(String type) {

        if ("CARD".equalsIgnoreCase(type)) {
            return new CardPayment();
        } else if ("UPI".equalsIgnoreCase(type)) {
            return new UpiPayment();
        }

        throw new IllegalArgumentException("Invalid payment type");
    }
}
```

### Client Code
```java
Payment payment = PaymentFactory.getPayment("CARD");
payment.pay();
```

---

## 1.5 Characteristics of Simple Factory

### Advantages
- Easy to understand
- Centralized object creation
- Cleaner client code

### Disadvantages
- Uses if-else / switch
- Violates Open–Closed Principle
- Poor extensibility
- Not suitable for large systems

---

## 2. Factory Method Pattern (GoF Pattern)

### 2.1 What Is Factory Method?
> Factory Method defines an interface for creating an object, but lets subclasses decide which class to instantiate.

### Core Idea
- Object creation is delegated to subclasses
- Removes conditional logic
- Uses polymorphism

---

## 2.2 Why Factory Method Exists
Simple Factory still has a problem:
- Adding a new product requires modifying the factory

Factory Method solves this by:
- Eliminating if-else logic
- Following Open–Closed Principle
- Allowing extension without modification

---

## 2.3 Factory Method Structure
```
Client → Factory Interface → Concrete Factories → Products
```

---

## 2.4 Factory Method Example

### Product Interface
```java
public interface Notification {
    void notifyUser();
}
```

### Concrete Products
```java
public class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Email notification");
    }
}
```

```java
public class SmsNotification implements Notification {
    public void notifyUser() {
        System.out.println("SMS notification");
    }
}
```

---

### Factory Interface
```java
public interface NotificationFactory {
    Notification createNotification();
}
```

---

### Concrete Factories
```java
public class EmailNotificationFactory implements NotificationFactory {
    public Notification createNotification() {
        return new EmailNotification();
    }
}
```

```java
public class SmsNotificationFactory implements NotificationFactory {
    public Notification createNotification() {
        return new SmsNotification();
    }
}
```

---

### Client Code
```java
NotificationFactory factory = new EmailNotificationFactory();
Notification notification = factory.createNotification();
notification.notifyUser();
```

---

## 2.5 Characteristics of Factory Method

### Advantages
- Fully follows Open–Closed Principle
- No conditional logic
- High extensibility
- Loose coupling

### Disadvantages
- More classes
- Slightly higher complexity

---

## 3. Simple Factory vs Factory Method (Key Interview Comparison)

| Aspect | Simple Factory | Factory Method |
|------|---------------|----------------|
| GoF pattern | ❌ No | ✅ Yes |
| Object creation | Centralized | Delegated to subclasses |
| Uses if-else | ✅ Yes | ❌ No |
| Uses polymorphism | ❌ No | ✅ Yes |
| Open–Closed Principle | ❌ Weak | ✅ Strong |
| Complexity | Low | Medium |
| Extensibility | Low | High |

---

## 4. Key Conceptual Difference (Interview Gold)

- **Simple Factory:**
  > Decision of object creation is inside the factory.

- **Factory Method:**
  > Decision of object creation is in the subclass.

---

## 5. Factory vs `new` Keyword

| new | Factory |
|----|--------|
| Tight coupling | Loose coupling |
| Client knows class | Client knows interface |
| Hard to change | Easy to extend |
| Compile-time binding | Runtime binding |

---

## 6. Factory Method in Real-World Frameworks

### Spring Framework
- `BeanFactory`
- `ApplicationContext`
- `FactoryBean<T>`

### JDBC
```java
Connection conn = DriverManager.getConnection(...);
```
Actual implementation class is hidden.

---

## 7. When to Use Which

### Use Simple Factory When
- Application is small
- Few object types
- Simplicity is preferred

### Use Factory Method When
- Application is large
- Frequent extensions are expected
- Framework or library design
- Open–Closed Principle is important

---

## 8. Common Interview Mistakes
- Calling Simple Factory a GoF pattern
- Confusing Factory Method with Abstract Factory
- Saying Factory removes object creation
- Overusing Factory in small applications

---

## 9. One-Line Interview Answers
- “Simple Factory centralizes object creation using conditionals.”
- “Factory Method delegates object creation to subclasses.”
- “Factory Method removes if-else using polymorphism.”
- “Factory Method follows Open–Closed Principle.”

---

## 10. Final Mental Model
- **Simple Factory:** Who decides? → Factory
- **Factory Method:** Who decides? → Subclass

---

# End of Factory & Factory Method Notes
