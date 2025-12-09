# Collection Interface (Java Collections Framework)

## Overview

The **Collection** interface is the root interface of the Java Collections Framework. It represents a group of individual objects as a single unit. All major collection types (List, Set, Queue, etc.) ultimately inherit from this interface.

This interface provides the **most common, general-purpose methods** that are applicable to all types of collections.

> **Note:** No concrete class implements the `Collection` interface directly. Instead, classes implement its subinterfaces.

---

## Core Responsibilities

* Represent a group of individual objects.
* Provide fundamental operations like add, remove, check membership, size, and iteration.
* Serve as the base interface for specialized collection types.

---

## Methods in the `Collection` Interface

Below is the list of standard methods defined in the `Collection` interface:

### **Add Operations**

* `boolean add(Object o)` – Adds a single element.
* `boolean addAll(Collection c)` – Adds all elements from another collection.

### **Remove Operations**

* `boolean remove(Object o)` – Removes a single element.
* `boolean removeAll(Collection c)` – Removes all elements found in another collection.
* `boolean retainAll(Collection c)` – *Retains only* elements present in the specified collection.
* `void clear()` – Removes all elements.

### **Search & State Check**

* `boolean contains(Object o)` – Checks if the element exists.
* `boolean containsAll(Collection c)` – Checks if all elements exist.
* `boolean isEmpty()` – Checks whether the collection has 0 elements.

### **Size & Array Conversion**

* `int size()` – Returns the number of elements.
* `Object[] toArray()` – Returns an array containing collection elements.

### **Iteration**

* `Iterator iterator()` – Returns an iterator to traverse elements.

---

## Key Notes

* This interface is at the top of the hierarchy for all non-map collections.
* Its methods form the backbone for all major data structures in Java.

---

Send the next interface snippet when you're ready!
