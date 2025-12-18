# Factory Pattern – Ultimate Interview Notes (Java)

## 1. What Is the Factory Pattern?

**Definition (Interview-ready):**

> Factory Pattern is a creational design pattern that provides an interface for creating objects without exposing the instantiation logic to the client.

In simple terms:
- Client does **not** use `new`
- Object creation logic is **centralized**
- Factory decides **which concrete class** to instantiate

---

## 2. Why Factory Pattern Is Needed

### Problem Without Factory (Tight Coupling)

```java
public class PaymentService {

    public void pay(String type) {
        if (type.equals("CARD")) {
            CardPayment payment = new CardPayment();
            payment.pay();
        } else if (type.equals("UPI")) {
            UpiPayment payment = new UpiPayment();
            payment.pay();
        }
    }
}
```

### Problems
- ❌ Tight coupling
- ❌ Violates Open–Closed Principle
- ❌ Hard to maintain
- ❌ Hard to test
- ❌ Every new type requires modifying existing code

---

## 3. Core Idea of Factory Pattern

### Key Principles
- Encapsulate object creation
- Program to an interface, not an implementation
- Separate **what to create** from **how to use**

### Structure
```
Client → Factory → Product Interface → Concrete Products
```

---

## 4. Simple Factory Pattern
> ⚠ Not an official GoF pattern, but **very common and frequently asked**

### 4.1 Product Interface
```java
public interface Payment {
    void pay();
}
```

### 4.2 Concrete Products
```java
public class CardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment done using Card");
    }
}
```

```java
public class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment done using UPI");
    }
}
```

### 4.3 Factory Class
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

### 4.4 Client Code
```java
public class FactoryDemo {
    public static void main(String[] args) {

        Payment payment1 = PaymentFactory.getPayment("CARD");
        payment1.pay();

        Payment payment2 = PaymentFactory.getPayment("UPI");
        payment2.pay();
    }
}
```

---

## 5. Benefits of Simple Factory
- Loose coupling
- Centralized object creation
- Cleaner client code
- Easier maintenance
- Easier testing

---

## 6. Factory Method Pattern (GoF Pattern)

### Definition
> Factory Method defines an interface for creating an object, but lets subclasses decide which class to instantiate.

Unlike Simple Factory:
- Uses inheritance
- Follows Open–Closed Principle better

---

## 7. Factory Method Pattern – Example

### 7.1 Product Interface
```java
public interface Notification {
    void notifyUser();
}
```

### 7.2 Concrete Products
```java
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification");
    }
}
```

```java
public class SmsNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}
```

### 7.3 Factory Interface
```java
public interface NotificationFactory {
    Notification createNotification();
}
```

### 7.4 Concrete Factories
```java
public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
```

```java
public class SmsNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
```

### 7.5 Client Code
```java
public class FactoryMethodDemo {
    public static void main(String[] args) {

        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();
        notification.notifyUser();
    }
}
```

---

## 8. Simple Factory vs Factory Method

| Aspect | Simple Factory | Factory Method |
|-----|--------------|----------------|
| GoF pattern | ❌ No | ✅ Yes |
| Uses inheritance | ❌ No | ✅ Yes |
| Extensibility | Low | High |
| Open–Closed Principle | ❌ Weak | ✅ Strong |
| Complexity | Low | Medium |

---

## 9. Factory vs Singleton (Interview Favorite)

| Factory | Singleton |
|------|-----------|
| Creates objects | Restricts object creation |
| Can create many instances | Only one instance |
| Focus on abstraction | Focus on instance control |
| Often returns interfaces | Usually concrete class |

---

## 10. Factory Pattern in Spring (Real-World Usage)

Spring internally uses Factory patterns:

- `BeanFactory`
- `ApplicationContext`
- `FactoryBean<T>`

Example:
```java
Object bean = applicationContext.getBean("myBean");
```

Here:
- Client does not use `new`
- Spring Factory decides which object to return

---

## 11. When to Use Factory Pattern

Use Factory when:
- Object creation logic is complex
- You want loose coupling
- You want to hide implementation details
- You return objects based on conditions
- You follow Open–Closed Principle
- You are building frameworks or libraries

---

## 12. When NOT to Use Factory Pattern

Avoid Factory when:
- Only one concrete class exists
- Object creation is trivial
- Overengineering for small applications

---

## 13. Common Interview Questions

### Q1. What problem does Factory solve?
Encapsulates object creation and promotes loose coupling.

### Q2. Difference between Simple Factory and Factory Method?
Simple Factory uses conditional logic; Factory Method uses inheritance and polymorphism.

### Q3. How is Factory used in Spring?
Spring uses factories to create and manage beans dynamically.

### Q4. Factory vs Builder?
Factory focuses on **which object to create**; Builder focuses on **how to build a complex object**.

---

## 14. Advantages
- Loose coupling
- Better maintainability
- Cleaner client code
- Adheres to SOLID principles

---

## 15. Disadvantages
- Adds extra classes
- Can increase complexity if overused

---

## 16. One-Line Summary (Interview Gold)

> Factory Pattern centralizes and abstracts object creation, promoting loose coupling and better maintainability.

---

# End of Factory Pattern Notes
