# Builder Pattern – Ultimate Interview Notes (Java)

## 0. What is GoF?
**GoF** stands for **Gang of Four**, the authors of
> Design Patterns: Elements of Reusable Object-Oriented Software

They defined **23 classic patterns**, including the **Builder Pattern** under *Creational Patterns*.

---

## 1. What Problem Does Builder Solve?

Builder addresses the **object construction complexity problem**, especially when:
- Many fields exist
- Some fields are optional
- Parameters are validated
- Object should be immutable
- Constructor becomes overloaded (telescoping constructors)

### Telescoping Constructor Anti-Pattern
```java
public User(String name)
public User(String name, int age)
public User(String name, int age, String email)
public User(String name, int age, String email, String phone)
```

Hard to maintain and confusing.

### JavaBean Style (Setters) Anti-Pattern
```java
User u = new User();
u.setName("John");
u.setAge(30);
```

Drawbacks:
- Object may remain in an incomplete state
- No immutability
- No validation control

---

## 2. Builder Pattern – Interview Definition
> Builder is a creational design pattern that separates the construction of a complex object from its representation, enabling step-by-step creation and supporting immutability.

Key ideas:
- Stepwise construction
- Fluent API (method chaining)
- Avoid constructor explosion
- Optional parameters handled cleanly

---

## 3. Roles in Builder
- **Product** – final object built (e.g., User)
- **Builder** – holds fields & methods to set values
- **build()** – method that returns the immutable Product

---

## 4. Java Example – Standard Inner Builder

### Product Class
```java
public class User {

    private final String name;
    private final int age;
    private final String email;
    private final String phone;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public static class Builder {
        private String name;
        private int age;
        private String email;
        private String phone;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            // You can perform validation here
            return new User(this);
        }
    }
}
```

### Client Usage
```java
User user = new User.Builder()
        .setName("John")
        .setAge(30)
        .setEmail("john@gmail.com")
        .build();
```

Readable, maintainable, safe.

---

## 5. Advantages (Interview Highlights)

✔ Solves telescoping constructor problem  
✔ Handles optional parameters gracefully  
✔ Supports immutability  
✔ Centralizes validation before object creation  
✔ Improves readability (fluent API)  
✔ Reduces bugs due to argument order  
✔ Thread-safe design possible  
✔ Easy to extend

---

## 6. Real-World Usage in Modern Java

### Lombok Builder
```java
@Builder
```

### StringBuilder
```java
new StringBuilder().append("a").append("b");
```

### Spring Security Config (Fluent APIs)
```java
http.csrf().disable().authorizeRequests();
```

### Streams (Builder-style chaining)
```java
Stream.of("a").filter().map().forEach();
```

### Kafka & AWS SDKs use builders heavily
```java
AwsClient.builder().region().credentialsProvider().build();
```

Builder is everywhere in modern Java.

---

## 7. Builder vs Factory (Common Question)

| Builder | Factory |
|--------|---------|
| Builds object step-by-step | Creates object in one shot |
| Handles many optional fields | Hides instantiation logic |
| Focus: construction | Focus: abstraction |
| Fluent API | Often static method |
| Good for immutability | Not specifically |

---

## 8. Builder vs Prototype
- Builder creates new complex objects.
- Prototype clones existing ones.

---

## 9. Builder vs Strategy
- Builder = **Creational**
- Strategy = **Behavioral**

---

## 10. When NOT to Use Builder
- Object has only 2–3 fields
- Simplicity is enough
- No immutability or validation required

Otherwise, Builder is ideal.

---

## 11. Validation Benefit (Important Interview Point)

Builder allows:
- Input validation
- Mandatory field checks
- Preventing inconsistent object creation

Example:
```java
public User build() {
    if (name == null) throw new IllegalStateException("name required");
    return new User(this);
}
```

---

## 12. Variants of Builder
- Inner static class (most common)
- Separate standalone builder class
- Step-builder (forces order)
- Interface-based builders
- Lombok auto-builders
- Fluent builders

---

## 13. Interview FAQs

**Q1: What problem does Builder solve?**  
Construction complexity + optional parameters + immutability.

**Q2: Difference from Factory?**  
Factory abstracts object creation, Builder handles construction with step-by-step control.

**Q3: Why not use setters?**  
Breaks immutability, unsafe, inconsistent state risk.

**Q4: Where have you used Builder?**  
Mention: Lombok, AWS SDK, Kafka configs, Spring Security DSL.

**Q5: Why is Builder popular in Java?**  
Java lacks named arguments. Builder mimics named parameters.

---

## 14. One-Line Summary
> Builder pattern constructs complex objects step by step, supports immutability, reduces constructor clutter, and improves readability.

---

# End of Builder Pattern Notes
