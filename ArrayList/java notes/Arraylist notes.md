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

-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------

ArrayList can store **any reference type (object)** in Java. Here are all the types you can put in an ArrayList: [geeksforgeeks](https://www.geeksforgeeks.org/java/arraylist-in-java/)

## Wrapper Classes (for primitives)

```java
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<Double> decimals = new ArrayList<>();
ArrayList<Float> floats = new ArrayList<>();
ArrayList<Long> longs = new ArrayList<>();
ArrayList<Short> shorts = new ArrayList<>();
ArrayList<Byte> bytes = new ArrayList<>();
ArrayList<Character> chars = new ArrayList<>();
ArrayList<Boolean> flags = new ArrayList<>();
```

## String Class

```java
ArrayList<String> names = new ArrayList<>();
names.add("John");
```

## Custom Objects (User-defined classes)

```java
ArrayList<Person> people = new ArrayList<>();
ArrayList<Student> students = new ArrayList<>();
ArrayList<Car> cars = new ArrayList<>();
```

## Arrays

```java
ArrayList<int[]> arrayOfIntArrays = new ArrayList<>();
ArrayList<String[]> arrayOfStringArrays = new ArrayList<>();
```

## Collections (nested)

```java
ArrayList<ArrayList<String>> nestedLists = new ArrayList<>();
ArrayList<HashSet<Integer>> listOfSets = new ArrayList<>();
ArrayList<HashMap<String, Integer>> listOfMaps = new ArrayList<>();
```

## Interfaces and Abstract Classes

```java
ArrayList<Runnable> tasks = new ArrayList<>();
ArrayList<Comparable> comparables = new ArrayList<>();
ArrayList<Serializable> serializables = new ArrayList<>();
```

## Enums

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY }
ArrayList<Day> days = new ArrayList<>();
```

## Mixed Types (using Object)

```java
ArrayList<Object> mixed = new ArrayList<>();
mixed.add("String");
mixed.add(123);
mixed.add(new Person());
```

## What You CANNOT Store

You **cannot directly store primitive types**: [reddit](https://www.reddit.com/r/learnjava/comments/fb4303/why_does_arraylist_hold_reference_types_boolean/)
```java
// WRONG - These cause errors:
ArrayList<int> numbers;      // Error!
ArrayList<double> decimals;  // Error!
ArrayList<boolean> flags;    // Error!
```

## Key Rule

ArrayList can store **any class or interface** - basically anything that extends from `Object`. Since primitives (`int`, `double`, etc.) are not objects, they must be wrapped in their wrapper classes (`Integer`, `Double`, etc.). [java-programming.mooc](https://java-programming.mooc.fi/part-3/2-lists/)

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Here are the key differences between Array and ArrayList in Java: [geeksforgeeks](https://www.geeksforgeeks.org/java/array-vs-arraylist-in-java/)

## Main Differences

| Feature | Array | ArrayList |
|---------|-------|-----------|
| **Size** | Fixed - cannot change after creation  [geeksforgeeks](https://www.geeksforgeeks.org/java/array-vs-arraylist-in-java/) | Dynamic - grows/shrinks automatically  [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/) |
| **Data Types** | Stores primitives (`int`, `double`) and objects  [scaler](https://www.scaler.com/topics/difference-between-array-and-arraylist/) | Only stores objects (uses wrapper classes)  [simplilearn](https://www.simplilearn.com/difference-between-array-and-arraylist-article) |
| **Syntax** | `arr[index]` | `list.get(index)`, `list.set(index, value)`  [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/) |
| **Performance** | Faster, less memory overhead  [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/) | Slightly slower due to resizing operations  [stackoverflow](https://stackoverflow.com/questions/19389609/array-vs-arraylist-in-performance) |
| **Methods** | Only has `.length` property  [simplilearn](https://www.simplilearn.com/difference-between-array-and-arraylist-article) | Many built-in methods: `add()`, `remove()`, `contains()`, etc.  [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/) |
| **Dimensions** | Supports multi-dimensional arrays  [simplilearn](https://www.simplilearn.com/difference-between-array-and-arraylist-article) | Single-dimensional only  [geeksforgeeks](https://www.geeksforgeeks.org/java/array-vs-arraylist-in-java/) |
| **Package** | Built into Java language | Part of `java.util` package  [simplilearn](https://www.simplilearn.com/difference-between-array-and-arraylist-article) |

## Declaration Examples

**Array:**
```java
// Fixed size of 5
int[] numbers = new int [stackoverflow](https://stackoverflow.com/questions/19389609/array-vs-arraylist-in-performance);
String[] names = {"John", "Jane", "Bob"};

// Can store primitives directly
numbers[0] = 10;
```

**ArrayList:**
```java
// No fixed size
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<String> names = new ArrayList<>();

// Must use wrapper class for primitives
numbers.add(10);  // autoboxing converts int to Integer
```

## When to Use Each

**Use Array when:** [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/)
- You know the exact size in advance
- You need to store primitive types for efficiency
- Performance is critical (faster access)
- You need multi-dimensional data (matrices, grids)

**Use ArrayList when:** [stackoverflow](https://stackoverflow.com/questions/24860857/how-do-i-know-whether-to-use-an-array-or-an-arraylist)
- Size changes frequently (adding/removing elements)
- You need built-in methods for manipulation
- Working with collections and streams
- Convenience and flexibility are more important than raw speed

## Performance Comparison

**Arrays:** O(1) access time, minimal memory overhead [stackoverflow](https://stackoverflow.com/questions/19389609/array-vs-arraylist-in-performance)

**ArrayList:** O(1) access time, but resizing can slow down operations when capacity is exceeded (creates new array internally and copies elements) [baeldung](https://www.baeldung.com/java-array-vs-list-performance)

## Converting Between Them

**Array to ArrayList:**
```java
String[] arr = {"A", "B", "C"};
ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
```

**ArrayList to Array:**
```java
ArrayList<String> list = new ArrayList<>();
String[] arr = list.toArray(new String[list.size()]);
```

In summary: Arrays are faster and more memory-efficient but inflexible, while ArrayLists are dynamic and convenient but have slight overhead. [scaler](https://www.scaler.com/topics/difference-between-array-and-arraylist/)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Here are the key differences between Array and ArrayList in Java: [geeksforgeeks](https://www.geeksforgeeks.org/java/array-vs-arraylist-in-java/)

## Main Differences

| Feature     | Array                                               | ArrayList                                                          |
| ----------- | --------------------------------------------------- | ------------------------------------------------------------------ |
| Size        | Fixed - cannot change after creation geeksforgeeks​ | Dynamic - grows/shrinks automatically ruby-doc​                    |
| Data Types  | Stores primitives (int, double) and objects scaler​ | Only stores objects (uses wrapper classes) simplilearn​            |
| Syntax      | arr[index]                                          | list.get(index), list.set(index, value) ruby-doc​                  |
| Performance | Faster, less memory overhead ruby-doc​              | Slightly slower due to resizing operations stackoverflow​          |
| Methods     | Only has .length property simplilearn​              | Many built-in methods: add(), remove(), contains(), etc. ruby-doc​ |
| Dimensions  | Supports multi-dimensional arrays simplilearn​      | Single-dimensional only geeksforgeeks​                             |
| Package     | Built into Java language                            | Part of java.util package simplilearn​                             |
## Declaration Examples

**Array:**
```java
// Fixed size of 5
int[] numbers = new int [stackoverflow](https://stackoverflow.com/questions/19389609/array-vs-arraylist-in-performance);
String[] names = {"John", "Jane", "Bob"};

// Can store primitives directly
numbers[0] = 10;
```

**ArrayList:**
```java
// No fixed size
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<String> names = new ArrayList<>();

// Must use wrapper class for primitives
numbers.add(10);  // autoboxing converts int to Integer
```

## When to Use Each

**Use Array when:** [ruby-doc](https://ruby-doc.org/blog/difference-between-array-and-arraylist-in-java/)
- You know the exact size in advance
- You need to store primitive types for efficiency
- Performance is critical (faster access)
- You need multi-dimensional data (matrices, grids)

**Use ArrayList when:** [stackoverflow](https://stackoverflow.com/questions/24860857/how-do-i-know-whether-to-use-an-array-or-an-arraylist)
- Size changes frequently (adding/removing elements)
- You need built-in methods for manipulation
- Working with collections and streams
- Convenience and flexibility are more important than raw speed

## Performance Comparison

**Arrays:** O(1) access time, minimal memory overhead [stackoverflow](https://stackoverflow.com/questions/19389609/array-vs-arraylist-in-performance)

**ArrayList:** O(1) access time, but resizing can slow down operations when capacity is exceeded (creates new array internally and copies elements) [baeldung](https://www.baeldung.com/java-array-vs-list-performance)

## Converting Between Them

**Array to ArrayList:**
```java
String[] arr = {"A", "B", "C"};
ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
```

**ArrayList to Array:**
```java
ArrayList<String> list = new ArrayList<>();
String[] arr = list.toArray(new String[list.size()]);
```

In summary: Arrays are faster and more memory-efficient but inflexible, while ArrayLists are dynamic and convenient but have slight overhead. [scaler](https://www.scaler.com/topics/difference-between-array-and-arraylist/)