# Java 8 – Interview Notes (Comprehensive)

## 1. Overview
Java 8 introduced major enhancements enabling functional programming, declarative data processing, cleaner concurrency, and modern date/time handling. It shifted Java into a hybrid **Object-Oriented + Functional** paradigm.

Primary motivations:
- Less boilerplate (Lambdas)
- Functions as first-class citizens
- Multi-core utilization via Streams/Parallel streams
- Safer null handling (Optional)
- Immutable and thread-safe date/time API
- Interface evolution via default/static methods

---

## 2. Functional Interfaces
A **functional interface** contains exactly one abstract method. It serves as the target type for Lambda expressions.

Examples:
- `Runnable` – run()
- `Comparator` – compare()
- SAM interfaces in `java.util.function`

Annotation:
```java
@FunctionalInterface
```

Key functional interfaces (java.util.function):
- **Predicate<T>** – boolean test(T t)
- **Function<T, R>** – R apply(T t)
- **Consumer<T>** – void accept(T t)
- **Supplier<T>** – T get()
- **UnaryOperator<T>** – T apply(T t)
- **BinaryOperator<T>** – T apply(T t, T u)
- BiPredicate, BiFunction, BiConsumer

---

## 3. Lambda Expressions
Anonymous functions used to implement functional interfaces.

Syntax:
```java
(parameters) -> expression
(parameters) -> { statements }
```

Benefits:
- Removes anonymous class boilerplate
- Enables Streams
- Encourages declarative style

Rules:
- Parentheses optional for one parameter
- Braces optional for single expression
- Return inferred for single expression

Example:
```java
Runnable r = () -> System.out.println("Run");
```

Internal behavior:
- Uses `invokedynamic`
- Not implemented as anonymous inner classes

---

## 4. Method References
Used when a Lambda only calls an existing method.

Types:
1. **Static reference**: `Class::staticMethod`
2. **Instance reference**: `obj::instanceMethod`
3. **Constructor reference**: `Class::new`

Example:
```java
list.forEach(System.out::println);
```

---

## 5. Interface Enhancements (Default & Static Methods)
Purpose: allow interface evolution without breaking implementations.

Example:
```java
default void log() { }
static void util() { }
```

Diamond conflict rule:
If two interfaces define the same default method, implementing class must override.

---

## 6. Stream API
Enables functional data processing using pipelines.

### Characteristics
- Declarative
- Lazy evaluation
- Internal iteration
- No storage; operates on data
- Once consumed, cannot be reused

### Structure
- **Source**: collection, array, IO
- **Intermediate ops**: lazy (map, filter, sorted, distinct, limit, skip)
- **Terminal ops**: eager (collect, reduce, forEach, count)

Example:
```java
List<Integer> even = nums.stream()
  .filter(n -> n % 2 == 0)
  .collect(Collectors.toList());
```

Key intermediate operations:
- **map** – transform
- **flatMap** – flatten nested structures
- **filter** – predicate-based removal
- **sorted** – custom comparator
- **distinct** – remove duplicates

Key terminal operations:
- **collect**
- **reduce**
- **forEach**
- **count**
- **min/max**

Important considerations:
- Avoid shared mutable state
- Streams are not parallel by default

---

## 7. Collectors Utility
Important collectors:
- `toList()`, `toSet()`, `toMap()`
- `joining()`
- `counting()`
- `averagingInt`, `summarizingInt`
- **groupingBy**
- **partitioningBy**
- `mapping` for downstream transformations

Example – grouping:
```java
Map<String, List<Employee>> map = 
  list.stream().collect(Collectors.groupingBy(Employee::getDept));
```

Example – partition:
```java
Map<Boolean, List<Integer>> result =
  nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

---

## 8. Reduction
Used to accumulate elements into a single result.

Forms:
- `reduce(identity, accumulator)`
- `reduce(accumulator)`
- `reduce(identity, accumulator, combiner)`

Example:
```java
int sum = nums.stream().reduce(0, (a, b) -> a + b);
```

---

## 9. Parallel Streams
Utilize multi-core CPUs:
```java
list.parallelStream().forEach(System.out::println);
```

Guidelines:
- Avoid shared state
- Best for CPU-heavy operations
- Overhead may degrade performance for small datasets
- Order not guaranteed unless `forEachOrdered`

---

## 10. Optional
Wrapper representing a value’s presence or absence.

Creation:
- `Optional.of(value)`
- `Optional.ofNullable(value)`
- `Optional.empty()`

Key methods:
- `isPresent()`
- `ifPresent(Consumer)`
- `orElse(default)`
- `orElseGet(Supplier)` – lazy
- `orElseThrow()`

Interview catch:
`orElse()` executes always; `orElseGet()` executes lazily.

---

## 11. New Date-Time API (java.time)
Immutable, thread-safe, ISO-8601 compatible; replaces `java.util.Date/Calendar`.

Key classes:
- `LocalDate`
- `LocalTime`
- `LocalDateTime`
- `Instant`
- `ZonedDateTime`
- `Period` (date-based)
- `Duration` (time-based)
- `DateTimeFormatter`

Example:
```java
LocalDate today = LocalDate.now();
LocalDate birth = LocalDate.of(1990, 5, 10);
Period age = Period.between(birth, today);
```

---

## 12. CompletableFuture (Basics)
Asynchronous programming without blocking threads.

Key methods:
- `supplyAsync(Supplier)`
- `runAsync(Runnable)`
- `thenApply(Function)` – transform result
- `thenAccept(Consumer)` – consume result
- `join()` – wait for completion

Example:
```java
CompletableFuture.supplyAsync(() -> loadData())
  .thenApply(d -> process(d))
  .thenAccept(System.out::println);
```

---

## 13. Interview-Focused Concepts

### Lambda vs Anonymous Class
- Lambda has no enclosing `this`
- Uses invokedynamic
- More lightweight
- Target type must be functional interface

### Map vs FlatMap
- **map**: one-to-one mapping
- **flatMap**: flatten nested structures (Stream<Stream<T>> to Stream<T>)

### Internal vs External Iteration
- Loop (external)
- Stream engine (internal)

### Streams and Immutability
Streams encourage side-effect-free pure functions.

### Reusing Streams
Not allowed after a terminal operation.

---

## 14. Common Interview Tasks
You should be able to:
- Filter, map, sort collections via Streams
- Group employees by department
- Compute averages with Collectors
- Flatten nested lists using flatMap
- Count frequency of words
- Convert imperative loops to Streams
- Compare `orElse` vs `orElseGet`
- Build custom collectors (basic)
- Distinguish parallel vs sequential performance scenarios

---

## 15. Frequent Interview Questions
1. What problem does Java 8 solve?
2. Explain functional interface rules.
3. How does Lambda differ from anonymous class?
4. Explain the Stream lifecycle.
5. When would you use flatMap?
6. Why is Optional better than null?
7. Details of groupingBy and partitioningBy.
8. When should you avoid parallel streams?
9. Compare old Date API vs java.time API.
10. Explain reduce and provide examples.
11. Difference between `map` and `filter`.
12. What is invokedynamic?

---

## 16. Key Summary Statements
- Java 8 brought a fundamental functional transition.
- Streams enable internal, lazy, pipeline-based processing.
- Optional reduces null-handling risk.
- New Date-Time API is immutable and thread-safe.
- CompletableFuture enables non-blocking async workflows.
- Parallel streams help multi-core utilization but require caution.
