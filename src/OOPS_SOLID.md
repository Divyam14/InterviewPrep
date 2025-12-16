# Java OOPs Concepts & SOLID Principles – Ultimate Interview Notes

---

## Object-Oriented Programming (OOP)

Object-Oriented Programming is a programming paradigm based on the concept of **objects**, which contain **data (fields)** and **behavior (methods)**.

### Why OOP?

* Better code organization
* Reusability
* Maintainability
* Extensibility
* Real-world modeling

---

## 1. Class

### Definition

A **class** is a blueprint or template used to create objects.

### Key Points

* Declares properties (variables) and behaviors (methods)
* Does not occupy memory until object creation

```java
class Car {
    String model;
    void drive() {
        System.out.println("Car is driving");
    }
}
```

---

## 2. Object

### Definition

An **object** is a real-world entity and an instance of a class.

### Key Points

* Occupies memory
* Created using `new` keyword

```java
Car car = new Car();
```

---

## 3. Encapsulation

### Definition

Encapsulation is the wrapping of data and code together and restricting direct access to data.

### Achieved Using

* `private` variables
* `public` getters and setters

### Benefits

* Data hiding
* Improved security
* Flexibility and maintainability

```java
class Employee {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
```

---

## 4. Abstraction

### Definition

Abstraction hides implementation details and exposes only essential features.

### Achieved Using

* Abstract classes
* Interfaces

```java
abstract class Shape {
    abstract void draw();
}
```

### Benefits

* Reduces complexity
* Improves code readability

---

## 5. Inheritance

### Definition

Inheritance allows one class to acquire properties and behavior of another class.

### Types

* Single
* Multilevel
* Hierarchical

> Java does NOT support multiple inheritance using classes (diamond problem).

```java
class Animal {
    void eat() {}
}
class Dog extends Animal {
    void bark() {}
}
```

---

## 6. Polymorphism

### Definition

Polymorphism means many forms.

### Types

#### 1. Compile-time (Method Overloading)

```java
class MathUtil {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

#### 2. Run-time (Method Overriding)

```java
class Parent {
    void show() {}
}
class Child extends Parent {
    @Override
    void show() {}
}
```

---

## 7. Association / Aggregation / Composition

These concepts describe **relationships between objects**. Interviewers love this topic because many candidates confuse them.

---

### 7.1 Association

#### Definition

**Association** represents a general relationship between two independent objects.

> "Uses-a" or "knows-a" relationship

#### Key Characteristics

* Objects have **independent lifecycles**
* Can be **one-to-one**, **one-to-many**, **many-to-many**
* Can be **unidirectional** or **bidirectional**

#### Example

```java
class Teacher {
    String name;
}

class Student {
    String name;
    Teacher teacher; // association
}
```

✅ Teacher and Student can exist independently.

#### Real-world Example

* Doctor ↔ Patient
* Teacher ↔ Student

---

### 7.2 Aggregation (Weak Has-A)

#### Definition

**Aggregation** is a special form of association where one object **owns** another object, but **both can exist independently**.

> "Has-a" relationship (weak ownership)

#### Key Characteristics

* Child object can exist without parent
* Represented by **empty diamond** in UML

#### Example

```java
class Department {
    String name;
}

class Company {
    Department dept; // aggregation
}
```

✅ Department can exist even if Company is destroyed.

#### Real-world Example

* Company has Departments
* Team has Players

---

### 7.3 Composition (Strong Has-A)

#### Definition

**Composition** is a stronger form of aggregation where child object **cannot exist without parent**.

> "Part-of" relationship

#### Key Characteristics

* Child lifecycle depends on parent
* Represented by **filled diamond** in UML
* Strong ownership

#### Example

```java
class Engine {
    void start() {}
}

class Car {
    private final Engine engine = new Engine(); // composition
}
```

❌ Engine cannot exist without Car (in this design).

#### Real-world Example

* House has Rooms
* Car has Engine

---

### 7.4 Aggregation vs Composition Comparison

| Feature               | Aggregation   | Composition    |
| --------------------- | ------------- | -------------- |
| Relationship strength | Weak          | Strong         |
| Child lifecycle       | Independent   | Dependent      |
| Ownership             | Partial       | Complete       |
| UML                   | Empty diamond | Filled diamond |

---

### 7.5 Interview Traps & Tips

✅ Association is the most generic form
✅ Aggregation and Composition are *types* of association
✅ Composition is preferred when lifecycle control is required
✅ Prefer composition over inheritance (loosely coupled design)

---

# SOLID Principles

SOLID principles were introduced by **Robert C. Martin (Uncle Bob)**.

They are design principles to create scalable, maintainable, and flexible software.

---

## S — Single Responsibility Principle (SRP)

### Definition

A class should have **only one reason to change**.

### Bad Design

```java
class Report {
    void generate() {}
    void print() {}
}
```

### Good Design

```java
class ReportGenerator {
    void generate() {}
}
class ReportPrinter {
    void print() {}
}
```

### Interview Tip

> SRP reduces coupling and increases cohesion.

---

## O — Open/Closed Principle (OCP)

### Definition

Classes should be **open for extension but closed for modification**.

### Achieved Using

* Abstraction
* Interfaces
* Inheritance

```java
interface Shape {
    double area();
}
class Rectangle implements Shape {
    public double area() { return 10 * 5; }
}
```

---

## L — Liskov Substitution Principle (LSP)

### Definition

Derived classes must be substitutable for their base classes.

### Violation Example

```java
class Bird {
    void fly() {}
}
class Ostrich extends Bird {
    // Cannot fly ❌
}
```

### Fix

```java
interface Flyable { void fly(); }
```

---

## I — Interface Segregation Principle (ISP)

### Definition

Clients should not be forced to implement interfaces they do not use.

### Bad Design

```java
interface Worker {
    void work();
    void eat();
}
```

### Good Design

```java
interface Workable { void work(); }
interface Feedable { void eat(); }
```

---

## D — Dependency Inversion Principle (DIP)

### Definition

High-level modules should not depend on low-level modules. Both should depend on abstractions.

### Bad Design

```java
class Keyboard {}
class Computer {
    Keyboard keyboard = new Keyboard();
}
```

### Good Design

```java
interface InputDevice {}
class Keyboard implements InputDevice {}
class Computer {
    InputDevice device;
}
```

---

## SOLID Summary Table

| Principle | Focus                          |
| --------- | ------------------------------ |
| SRP       | One responsibility             |
| OCP       | Extension without modification |
| LSP       | Substitutability               |
| ISP       | Small interfaces               |
| DIP       | Dependency on abstractions     |

---

## Common Interview Questions

* Difference between abstraction and encapsulation?
* Why multiple inheritance is not supported in Java?
* Real-world example of polymorphism
* How SOLID improves code quality?
* Which SOLID principle Spring uses? (Answer: DIP, OCP)

---

✅ **This file is designed for both concept clarity and interview-ready explanations.**
