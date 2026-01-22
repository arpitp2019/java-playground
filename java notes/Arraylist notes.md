In Java ArrayList, you can store **objects only** - not primitive data types. Here's what you can and cannot store: [w3schools](https://www.w3schools.com/java/java_arraylist.asp)

## What You CAN Store

**Wrapper Classes (for numbers and primitives):**
```java
ArrayList<Integer> numbers = new ArrayList<>();    // integers
ArrayList<Double> decimals = new ArrayList<>();    // decimal numbers
ArrayList<Boolean> flags = new ArrayList<>();      // true/false
ArrayList<Character> chars = new ArrayList<>();    // single characters
```

**Strings:**
```java
ArrayList<String> names = new ArrayList<>();
names.add("John");
names.add("Jane");
```

**Custom Objects:**
```java
ArrayList<Person> people = new ArrayList<>();
ArrayList<Car> cars = new ArrayList<>();
people.add(new Person("John", 25));
```

**Any Reference Type:**
- Arrays: `ArrayList<int[]>` or `ArrayList<String[]>`
- Other collections: `ArrayList<ArrayList<String>>`
- Interfaces and abstract classes
- Enums [geeksforgeeks](https://www.geeksforgeeks.org/java/arraylist-in-java/)

## What You CANNOT Store Directly

**Primitive types** like `int`, `double`, `boolean`, `char`, `float`, `long`, `byte`, `short` cannot be used directly: [youtube](https://www.youtube.com/watch?v=JDXoonSAmo8)

```java
// WRONG - This will cause a compiler error
ArrayList<int> numbers = new ArrayList<>();

// CORRECT - Use wrapper class instead
ArrayList<Integer> numbers = new ArrayList<>();
```

## Why Only Objects?

ArrayList uses **generics** which work only with reference types (objects), not primitive types. Internally, ArrayList stores elements in an `Object[]` array, and primitives don't inherit from Object. [stackoverflow](https://stackoverflow.com/questions/3467965/how-does-arraylist-work)

## Autoboxing

Java automatically converts primitives to wrapper objects when adding to ArrayList:
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(5);  // Automatically converts int 5 to Integer object
```

This automatic conversion is called **autoboxing**. [w3schools](https://www.w3schools.com/java/java_arraylist.asp)