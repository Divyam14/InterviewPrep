# Abstract Factory – Ultimate Interview Notes (Java)

## 0. What is GoF?
**GoF** stands for **Gang of Four**.

Authors:
- Erich Gamma
- Richard Helm
- Ralph Johnson
- John Vlissides

They wrote the book:
> Design Patterns: Elements of Reusable Object-Oriented Software

This book defines **23 classic design patterns**, including **Abstract Factory**.

---

## 1. What is the Abstract Factory Pattern?

**Interview Definition:**

> Abstract Factory is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

Key concepts:
- Produces **product families**
- Ensures **consistency** across products
- Hides concrete classes
- Enables easy environment switches

---

## 2. Why Do We Need Abstract Factory?

Factory Method creates **single objects**.  
But in many real scenarios we need **groups of matching objects**.

Example:
- A GUI should either be **all Mac UI components**  
  or **all Windows UI components**

We don’t want:
- MacButton + WindowsTextBox (mixed ecosystem)

Abstract Factory enforces **family compatibility**.

---

## 3. Abstract Factory vs Factory Method

| Aspect | Factory Method | Abstract Factory |
|--------|---------------|-----------------|
| Product count | Single product | Product families |
| Purpose | Decouple creator | Ensure compatibility |
| Polymorphism | Subclass decides product | Factory chooses family |
| If/else removal | Yes | Yes |
| Abstraction level | Lower | Higher |
| Term | GoF pattern | GoF pattern |

**One-liner:**
- Factory Method = *which product?*
- Abstract Factory = *which family of products?*

---

## 4. UML Mental Model (Verbal)

```
AbstractFactory
  ├─ ConcreteFactoryA
  └─ ConcreteFactoryB

AbstractProduct1         AbstractProduct2
   ├─ Product1A             ├─ Product2A
   └─ Product1B             └─ Product2B
```

Client interacts only with:
- AbstractFactory
- AbstractProducts

---

## 5. Example Scenario: GUI Toolkit

We support two UI themes:
- **Mac**
- **Windows**

Each theme has:
- Button
- TextBox

---

### 5.1 Abstract Products
```java
public interface Button {
    void paint();
}
```

```java
public interface TextBox {
    void render();
}
```

---

### 5.2 Concrete Products (Mac)
```java
public class MacButton implements Button {
    public void paint() {
        System.out.println("Painting Mac Button");
    }
}
```

```java
public class MacTextBox implements TextBox {
    public void render() {
        System.out.println("Rendering Mac TextBox");
    }
}
```

---

### 5.3 Concrete Products (Windows)
```java
public class WindowsButton implements Button {
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}
```

```java
public class WindowsTextBox implements TextBox {
    public void render() {
        System.out.println("Rendering Windows TextBox");
    }
}
```

---

### 5.4 Abstract Factory
```java
public interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
}
```

---

### 5.5 Concrete Factories
```java
public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}
```

```java
public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}
```

---

### 5.6 Client Code (No `new`)
```java
public class Demo {
    public static void main(String[] args) {
        GUIFactory factory = new MacFactory(); // could be config-driven

        Button btn = factory.createButton();
        TextBox txt = factory.createTextBox();

        btn.paint();
        txt.render();
    }
}
```

Switch platform?
```java
factory = new WindowsFactory();
```

Zero client-side class changes.

---

## 6. Real-World Examples

### Frameworks
- Spring → `BeanFactory`, `FactoryBean<T>`, `ApplicationContext`
- Javax Swing LookAndFeel
- AWT Toolkit

### Business Scenarios
- Payment gateways (Razorpay + Stripe families)
- Cloud Providers SDK
- Database providers (JDBC families)

---

## 7. Advantages

- Loose coupling
- Product family consistency
- Hides concrete classes
- Supports dependency inversion
- Supports Open–Closed Principle
- Easy swapping (Mac ↔ Windows)

---

## 8. Disadvantages

- Many classes & interfaces
- Hard to add new product types
- More abstraction → more complexity

**Note:** Adding a new *product family* is easy.  
Adding a new *product type* requires touching all factories.

---

## 9. When to Use Abstract Factory

Use when:
- Your system must support multiple **families of related objects**
- You want to **switch environments** easily
- You need **matching product sets**
- You want to **hide concrete classes**

Do not use when:
- Only one product exists
- No product families are needed
- Simplicity is preferred

---

## 10. Interview Questions & Answers

### Q1. Difference between Factory Method and Abstract Factory?
- Factory Method → creates **one product**
- Abstract Factory → creates **product families**

### Q2. Why “Factory of factories”?
Because it centralizes multiple creation methods that behave like independent factories.

### Q3. Does Abstract Factory remove `new`?
Yes, for client code. Creation is abstracted.

### Q4. Where is Abstract Factory used in Spring?
`BeanFactory`, `ApplicationContext`, and `FactoryBean<T>`.

---

## 11. One-Line Summary
> Abstract Factory ensures **consistent product families** and hides concrete implementations through a unified creation interface.

---

# End of Abstract Factory Notes
