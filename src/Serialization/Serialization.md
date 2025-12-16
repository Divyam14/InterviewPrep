# Java Serialization – Complete Interview Notes

---

## 1. Serialization Overview

**Serialization** is the process of converting an object into a **byte stream** so that it can be:
- Stored in a file
- Transferred over a network
- Persisted in a database
- Sent between JVMs

**Deserialization** is the reverse process of restoring the object from the byte stream.

Java provides serialization support via:
- `ObjectOutputStream`
- `ObjectInputStream`

---

## 2. Why Serialization is Required

- Persist object state
- Network communication (RMI)
- Distributed systems
- Session replication
- Caching mechanisms
- Messaging systems

---

## 3. Serializable Interface

```java
public interface Serializable {
    // Marker interface
}
```
Marker interface (no methods)

JVM checks it at runtime

Without it:
```
java.io.NotSerializableException
```

✅ Used by JVM to identify serializable classes.

## 4. Basic Serialization Example
```java
class Employee implements Serializable {
int id;
String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.ser"));
oos.writeObject(emp);
```

```java
ObjectInputStream ois =
    new ObjectInputStream(new FileInputStream("emp.ser"));
Employee emp = (Employee) ois.readObject();

```

## 5. What Gets Serialized

✅ Serialized:

- Primitive variables

- Serializable object references

❌ Not Serialized:

- static fields

- transient fields

## 6. transient Keyword

Used to prevent fields from being serialized.
```java
class User implements Serializable {
    String username;
    transient String password;
}

```
After deserialization:
``` 
password == null
```
Use Cases

- Passwords

- Tokens

- Cache values

- Derived fields

## 7.Static Variables and Serialization

- Static variables belong to the class

- Serialization is object-based

- Static variables are not serialized

## 8. serialVersionUID
```java
private static final long serialVersionUID = 1L;
```
### Purpose

- Version control for Serializable classes

- Ensures compatibility during deserialization

### UID Mismatch
```java
InvalidClassException
```
### Best Practice

✅ Always define serialVersionUID explicitly.

## 9. Class Versioning Problem

Original class:
```java
class Employee implements Serializable {
    int id;
    String name;
}
```
Modified Class:
```java
class Employee implements Serializable {
    int id;
    String name;
    double salary;
}
```
✅ Maintain same serialVersionUID to avoid errors.

## 10. Inheritance and Serialization

### Parent is Serializable
```java
class Parent implements Serializable {}
class Child extends Parent {}
```
✅ Child is automatically serializable.

### Parent is NOT Serializable
```java
class Parent {
    Parent() {
        System.out.println("Parent constructor called");
    }
}

class Child extends Parent implements Serializable {}
```
- Parent constructor executes during deserialization
- Child fields restored from stream

## 11. Custom Serialization
Special methods:

- writeObject()
- readObject()

```java
private void writeObject(ObjectOutputStream oos) throws Exception {
    oos.defaultWriteObject();
}
```

```java
private void readObject(ObjectInputStream ois) throws Exception {
    ois.defaultReadObject();
}
```

### Usage

- Encrypt data

- Serialize transient fields

- Custom processing

## 12. Externalizable Interface
```java
public interface Externalizable {
    void writeExternal(ObjectOutput out);
    void readExternal(ObjectInput in);
}
```

Comparison

| Serializable     | Externalizable     |
|------------------|--------------------|
| Marker interface | 	Has methods       |
| JVM handles	     | Developer controls |
| Safer            | 	Faster            |
| Common           | 	Rare              |

No constructor rule	Needs public no-arg constructor

## 13. Serialization Callback Methods
| Method       | Purpose                     |
| ------------ | --------------------------- |
| writeObject  | Before serialization        |
| readObject   | After deserialization       |
| writeReplace | Replace object before write |
| readResolve  | Replace object after read   |

## Singleton Problem with Serialization

When a Singleton object is serialized and then deserialized, the deserialization process does not invoke the class's private constructor or its controlled instantiation mechanism. Instead, it creates a new object in memory, effectively bypassing the Singleton's control and leading to multiple instances of the class.

### Fix
```java
private Object readResolve() {
    return INSTANCE;
}
```

## 14. Deep vs Shallow Serialization
- Java serialization is deep

- All referenced objects are serialized

❌ If reference is not Serializable:
```java
NotSerializableException
```

## 15. Security Issues
- Deserialization attacks

- Arbitrary object creation

- Remote code execution risks

### Best Practices
- Avoid Java serialization in APIs

- Prefer JSON / Protobuf

- Validate deserialized objects

- Use transient where needed

## 16. Real-World Applications

- HTTP session replication

- Distributed caching

- RMI

- Message brokers

- ORM frameworks

## 17. Frequently Asked Interview Questions

- Why Serializable has no methods?

- What happens if serialVersionUID mismatches?

- Are static fields serialized?

- Can transient fields be serialized?

- Parent class not Serializable behavior?

- Serializable vs Externalizable

- How serialization breaks Singleton?

- How to prevent Singleton break?

## 18. One-Line Interview Answers

- Serialization converts object to byte stream

- Serializable is a marker interface

- serialVersionUID ensures compatibility

- Static fields are not serialized

- Transient fields are ignored

- Parent constructor executes if parent isn't serializable

- readResolve protects Singleton