# Queue Interface — Ultimate Interview Revision Notes (Java Collections Framework)

> Queue questions often appear **after List & Set**, especially in problems related to **processing, scheduling, BFS, producer–consumer**, and **priority handling**.

---

## 1. What is a Queue?

A **Queue** represents a collection of elements held **prior to processing**.

### Core Idea

* Follows **FIFO** (First-In-First-Out) by default
* Some implementations follow **priority-based** ordering

> ✅ Interview one-liner: *Queue is used when elements must be processed in a specific order.*

---

## 2. Queue Interface Hierarchy (ASCII Diagram)

```
              Collection
                   |
                 Queue
                   |
                 Deque
               /        \
      ArrayDeque     LinkedList

             PriorityQueue
```

---

## 3. Queue Interface Methods (INTERVIEW FAVORITE)

Queue defines **two sets of methods** for the same operations.

### 3.1 Exception-Throwing Methods

| Operation | Method    |
| --------- | --------- |
| Insert    | add(e)    |
| Remove    | remove()  |
| Inspect   | element() |

### 3.2 Special-Value Methods (Preferred)

| Operation | Method   |
| --------- | -------- |
| Insert    | offer(e) |
| Remove    | poll()   |
| Inspect   | peek()   |

> 🔥 Interview tip: *Queue methods exist in pairs — one throws exception, one returns special value.*

---

## 4. PriorityQueue — Complete Notes

### Key Characteristics

* Default natural ordering (min-heap)
* Not strictly FIFO
* Duplicate elements allowed
* No null elements allowed
* Backed by **heap (binary heap)**

---

### PriorityQueue Internal Structure

```
            10
          /    \
         20     30
```

(Smallest element has highest priority)

---

### PriorityQueue Constructors

* `PriorityQueue()`
* `PriorityQueue(int initialCapacity)`
* `PriorityQueue(Comparator c)`
* `PriorityQueue(Collection c)`

---

### PriorityQueue Example Behavior

```java
Queue<Integer> q = new PriorityQueue<>();
q.add(30);
q.add(10);
q.add(20);

System.out.println(q);   // not sorted view
System.out.println(q.poll()); // 10 (smallest)
```

> ⚠️ Iteration does NOT guarantee sorted order.

---

## 5. Deque Interface (Double-Ended Queue)

### What is Deque?

A **Deque** allows insertion and removal at **both ends**.

> ✅ Can be used as **Queue or Stack**.

---

### Deque Methods

| Operation | First End     | Last End     |
| --------- | ------------- | ------------ |
| Insert    | addFirst()    | addLast()    |
| Remove    | removeFirst() | removeLast() |
| Inspect   | getFirst()    | getLast()    |

Special-value versions:

* `offerFirst()`
* `offerLast()`
* `pollFirst()`
* `pollLast()`
* `peekFirst()`
* `peekLast()`

---

## 6. ArrayDeque — Complete Notes

### Key Characteristics

* Resizable array
* Faster than Stack & LinkedList
* No capacity restriction
* No null elements allowed

---

### Using ArrayDeque as Stack

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
stack.pop(); // 20
```

---

### Using ArrayDeque as Queue

```java
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(10);
queue.offer(20);
queue.poll(); // 10
```

---

## 7. LinkedList as Queue

LinkedList implements **Deque**.

### Characteristics

* Allows null elements
* Slightly slower than ArrayDeque
* Supports FIFO & LIFO

---

## 8. BlockingQueue (Concurrent Queue)

### What is BlockingQueue?

A thread-safe queue where:

* `put()` blocks if queue is full
* `take()` blocks if queue is empty

### Common Implementations

* `ArrayBlockingQueue`
* `LinkedBlockingQueue`
* `PriorityBlockingQueue`

> 🔥 Frequently asked in producer–consumer problems.

---

## 9. ArrayDeque vs LinkedList vs PriorityQueue (Interview Table)

| Feature      | ArrayDeque    | LinkedList         | PriorityQueue  |
| ------------ | ------------- | ------------------ | -------------- |
| Order        | FIFO / LIFO   | FIFO / LIFO        | Priority-based |
| Null Allowed | ❌ No          | ✅ Yes              | ❌ No           |
| Performance  | 🔥 Fast       | Medium             | Medium         |
| DS           | Dynamic Array | Doubly Linked List | Heap           |

---

## 10. Common Interview Traps

1. PriorityQueue iteration is NOT sorted
2. Queue.peek() vs element()
3. ArrayDeque is faster than Stack
4. Deque preferred over Stack (legacy)

---

## ✅ Final Interview Summary

✅ Queue → FIFO processing
✅ PriorityQueue → priority scheduling
✅ Deque → queue + stack
✅ ArrayDeque → best stack replacement
✅ BlockingQueue → concurrency problems

# End of Ultimate Queue Interface Notes
