# Java Reflection API – Ultimate Interview Guide

## 1. What Is Reflection?
Reflection in Java is a mechanism that allows a program to **inspect, analyze, and modify the structure and behavior of classes at runtime**, even when their names are not known at compile time.

With reflection, Java code can:
- Inspect classes, interfaces, fields, methods, constructors
- Create objects dynamically
- Invoke methods dynamically
- Access and modify private fields and methods
- Load classes at runtime

Reflection is provided by the package:
```
java.lang.reflect
```

---

## 2. Why Reflection Exists
Reflection is foundational to many core Java frameworks and tools.

### Real-world usage
| Technology | Usage |
|----------|------|
| Spring | Bean creation, dependency injection, proxy creation |
| Hibernate / JPA | Mapping entity fields to DB columns |
| Jackson / Gson | JSON ↔ Object mapping |
| JUnit | Discovering and executing test methods |
| IDEs | Code completion, inspection, debugging |
| Plugin systems | Loading unknown classes dynamically |

Without reflection, **modern Java frameworks would not be possible**.

---

## 3. Core Concept: `Class<?>`
Every Java class loaded by the JVM is represented by a **single `Class` object**.

### 3 ways to get a Class object
```java
Class<?> c1 = MyClass.class;              // Compile-time
Class<?> c2 = obj.getClass();             // From object
Class<?> c3 = Class.forName("pkg.MyClass"); // Runtime (dynamic)
```

Once you have a `Class` object, reflection starts.

---

## 4. Key Reflection Classes

| Class | Purpose |
|-----|--------|
| `Class<?>` | Metadata about class |
| `Field` | Represents a field |
| `Method` | Represents a method |
| `Constructor<?>` | Represents a constructor |
| `Modifier` | Decodes access modifiers |

---

## 5. Inspecting Class Metadata

```java
Class<?> clazz = Person.class;

System.out.println(clazz.getName());
System.out.println(clazz.getSimpleName());
System.out.println(clazz.getPackage());
```

---

## 6. Working With Fields

### 6.1 Get Fields
```java
Field[] publicFields = clazz.getFields();          // public only
Field[] allFields = clazz.getDeclaredFields();    // all (private included)
```

### 6.2 Access Private Field
```java
Field field = clazz.getDeclaredField("name");
field.setAccessible(true); // bypass private
Object value = field.get(obj);
```

### 6.3 Modify Private Field
```java
field.set(obj, "New Value");
```

⚠ Breaks encapsulation — powerful but dangerous.

---

## 7. Working With Methods

### 7.1 List Methods
```java
Method[] methods = clazz.getDeclaredMethods();
```

### 7.2 Invoke Public Method
```java
Method m = clazz.getMethod("sayHello");
m.invoke(obj);
```

### 7.3 Invoke Private Method
```java
Method m = clazz.getDeclaredMethod("incrementAge", int.class);
m.setAccessible(true);
m.invoke(obj, 5);
```

---

## 8. Working With Constructors

### 8.1 List Constructors
```java
Constructor<?>[] ctors = clazz.getDeclaredConstructors();
```

### 8.2 Create Object Using Public Constructor
```java
Constructor<?> ctor = clazz.getConstructor(String.class, int.class);
Object obj = ctor.newInstance("Alice", 30);
```

### 8.3 Create Object Using Private Constructor
```java
Constructor<?> ctor = clazz.getDeclaredConstructor();
ctor.setAccessible(true);
Object obj = ctor.newInstance();
```

This is how **Singletons are broken using reflection**.

---

## 9. Reflection and Inner Classes

### Binary name format
```
package.OuterClass$InnerClass
```

Example:
```java
Class.forName("com.app.Outer$Inner");
```

Interview trap: using `.` instead of `$`.

---

## 10. `setAccessible(true)` – What It Does
- Disables Java access checks
- Allows access to private members
- Bypasses encapsulation
- Used heavily by frameworks

⚠ Can cause security and maintenance issues.

---

## 11. Reflection and Singleton Break

### Why Singleton Breaks
Reflection can call a private constructor:
```java
Constructor<?> ctor = Singleton.class.getDeclaredConstructor();
ctor.setAccessible(true);
Singleton s2 = (Singleton) ctor.newInstance();
```

### Fixes
- Constructor guard (partial)
- **Enum Singleton (best)**

---

## 12. Reflection Performance Considerations

Reflection is **slower** because:
- JVM cannot inline reflective calls
- No compile-time optimizations
- Method lookups happen dynamically

### Best practices
- Cache `Method`, `Field`, `Constructor`
- Avoid reflection in loops
- Use it during initialization, not runtime hot paths

---

## 13. Reflection and Security
- Breaks encapsulation
- Can expose sensitive fields
- Older Java versions used `SecurityManager`
- Modern Java restricts illegal reflective access warnings

---

## 14. Reflection vs Normal Code

| Feature | Normal Code | Reflection |
|------|------------|-----------|
| Compile-time safety | Yes | No |
| Performance | Fast | Slower |
| Encapsulation | Preserved | Broken |
| Flexibility | Low | High |

---

## 15. When to Use Reflection
✅ Frameworks  
✅ Libraries  
✅ Tools  
✅ Plugin systems  
✅ Generic utilities

❌ Business logic  
❌ Performance-critical code

---

## 16. Reflection With Annotations (Important)

```java
if (clazz.isAnnotationPresent(Entity.class)) {
    Annotation a = clazz.getAnnotation(Entity.class);
}
```

Frameworks scan annotations entirely via reflection.

---

## 17. Common Exceptions in Reflection

| Exception | Cause |
|--------|------|
| `ClassNotFoundException` | Wrong class name |
| `NoSuchMethodException` | Method not found |
| `NoSuchFieldException` | Field not found |
| `IllegalAccessException` | Access violation |
| `InvocationTargetException` | Method threw exception |

---

## 18. Interview Questions & Answers

### Q1. What is Reflection?
Ability to inspect and manipulate classes at runtime.

### Q2. Why is reflection slow?
JVM cannot optimize reflective calls.

### Q3. How does reflection break Singleton?
By invoking private constructors.

### Q4. Where does Spring use reflection?
Bean creation, dependency injection, proxying.

### Q5. Difference between getFields and getDeclaredFields?
- `getFields()` → public + inherited
- `getDeclaredFields()` → all declared fields

---

## 19. Best Practices Summary
- Avoid reflection unless required
- Prefer framework abstractions
- Cache reflective objects
- Never expose reflection to business code
- Use Enum for Singleton safety

---

## 20. Final One-Line Summary
Reflection gives Java **dynamic runtime power**, but at the cost of **performance, safety, and encapsulation**.

---

# End of Reflection Notes
