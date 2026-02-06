## What Are Wrapper Classes?

Wrapper classes in Java convert primitive data types into objects. Since primitives like `int`, `double`, and `boolean` are not objects, wrapper classes "wrap" them to make them work with Java's object-oriented features. [geeksforgeeks](https://www.geeksforgeeks.org/java/wrapper-classes-java/)

## The 8 Wrapper Classes

Each primitive type has a corresponding wrapper class: [programiz](https://www.programiz.com/java-programming/wrapper)

| Primitive Type | Wrapper Class |
|---------------|---------------|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

## Converting Primitive to Object (Boxing)

**Manual conversion:**
```java
int num = 5;
Integer obj = Integer.valueOf(num);  // primitive to object

double d = 5.65;
Double dObj = Double.valueOf(d);
```

**Autoboxing (automatic):**
```java
int num = 10;
Integer obj = num;  // Java automatically converts this
```

## Converting Object to Primitive (Unboxing)

**Manual conversion:**
```java
Integer obj = Integer.valueOf(23);
int num = obj.intValue();  // object to primitive

Double dObj = Double.valueOf(5.55);
double d = dObj.doubleValue();
```

**Auto-unboxing (automatic):**
```java
Integer obj = 100;
int num = obj;  // Java automatically extracts the value
```

## Why Use Wrapper Classes?

- **Collections**: ArrayList, HashMap only accept objects, not primitives [tutorialspoint](https://www.tutorialspoint.com/java/java_wrapper_classes.htm)
  ```java
  ArrayList<Integer> list = new ArrayList<>();  // Must use Integer, not int
  ```
- **Null values**: Objects can be null, primitives cannot [dev](https://dev.to/satyam_gupta_0d1ff2152dcc/java-wrapper-classes-explained-why-how-and-when-to-use-them-2n80)
  ```java
  Integer num = null;  // Valid
  int x = null;        // Error!
  ```
- **Utility methods**: Wrapper classes provide helpful methods [geeksforgeeks](https://www.geeksforgeeks.org/java/wrapper-classes-java/)
  ```java
  String str = "123";
  int num = Integer.parseInt(str);  // Convert string to int
  ```

## Common Wrapper Methods

| Method | Purpose | Example |
|--------|---------|---------|
| `valueOf()` | Converts primitive to object | `Integer.valueOf(10)` |
| `intValue()` | Converts object to primitive | `obj.intValue()` |
| `parseInt()` | Parses string to primitive | `Integer.parseInt("123")` |
| `toString()` | Converts to String | `Integer.toString(10)` |

Autoboxing and unboxing happen automatically in Java 5+, making wrapper classes easy to use. [herovired](https://herovired.com/home/learning-hub/topics/autoboxing-and-unboxing-in-java)