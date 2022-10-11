# First Program
## Ex1
1. Write a program TenHelloWorlds.java that prints "Hello, World" ten times.
```java
public class TenHelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
    System.out.println("Hello, World");
  }
}
```
Output:
```txt
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
Hello, World
```
## Ex2
2. Modify UseArgument.java to make a program UseThree.java that takes three names and prints out a proper sentence with the names in the reverse of the order given, so that for example, "java UseThree Alice Bob Carol" gives "Hi Carol, Bob, and Alice.".
### UseArgument
````java
public class UseArgument {
    public static void main(String[] args) {
        System.out.print("Hi, ");
        System.out.print(args[0]);
        System.out.println(". How are you?");
    }
}
````
How to run:

1. Complication: `javac UseArgument.java`
2. Execution: `java UseArgument yourname`

Example: Prints "Hi, Quang Anh. How are you?" where "Quang Anh" is replaced by the command-line argument.

```txt
java UseArgument Bob
Hi, Bob. How are you?
```
### UseThree
```java
public class UseThree {
    public static void main(String[] args) {
        System.out.print("Hi, ");
        System.out.print(args[2]);
        System.out.print(", ");
        System.out.print(args[1]);
        System.out.print(", and ");
        System.out.print(args[0]);
        System.out.print(".");
    }
}
```
How to run?

1. Complication: `javac UseThree.java`
2. Execution: `java UseThree name1 name2 name3`

Take 3 command-line arguments and prints them in reverse order in a friendly greeting.

```txt
java UseThree ABC Bob Wilam
Hi, ABC, Bob, and Willam
```
# Web Exercises
## Ex1
Write a program HelloWorldMultilingual.java that prints "Hello World!" in as many human languages as you can.
```java
public class HelloWorldMultilingual {
    public static void main(String[] args){
        System.out.println("Hello World! (English)");
        System.out.println("Salut le monde (French)");
        System.out.println("Xin chào thế giới! (Tiếng Việt)");
        System.out.println("안녕하세요 월드입니다! (Korean)");
    }
}
```
Output:
```txt
Hello World! (English)
Salut le monde (French)
Xin chào thế giới! (Tiếng Việt)
안녕하세요 월드입니다! (Korean)
```
Source: https://introcs.cs.princeton.edu/java/11hello/HelloWorldMultilingual.java.html

## Ex2
Write a program Initials.java that prints your initial using nine rows of asterisks like the one below
```java
public class Initial {
    public static void main(String[] args) {
        System.out.println("**        ***    **********      **             *             **");
        System.out.println("**      ***      **        **     **           ***           ** ");
        System.out.println("**    ***        **         **     **         ** **         **  ");
        System.out.println("**  ***          **          **     **       **   **       **   ");
        System.out.println("*****            **          **      **     **     **     **    ");
        System.out.println("**  ***          **          **       **   **       **   **     ");
        System.out.println("**    ***        **         **         ** **         ** **      ");
        System.out.println("**      ***      **        **           ***           ***       ");
        System.out.println("**        ***    **********              *             *        ");
    }
}
```
Output:
```java
**        ***    **********      **             *             **
**      ***      **        **     **           ***           ** 
**    ***        **         **     **         ** **         **  
**  ***          **          **     **       **   **       **   
*****            **          **      **     **     **     **    
**  ***          **          **       **   **       **   **     
**    ***        **         **         ** **         ** **      
**      ***      **        **           ***           ***       
**        ***    **********              *             *        
```
## Ex3
Describe what happens if, in HelloWorld.java, you omit

Part 1

- main
- String
- HelloWorld
- System.out
- println

Part 2
(by, say, omitting the second letter)
- the ;
- the first "
- the second "
- the first {
- the second {
- the first }
- the second }


If you omit main, it will error:
```txt
HelloWorld.java:2: error: <identifier> expected
        System.out.println("Hello World");
                          ^
HelloWorld.java:2: error: illegal start of type
        System.out.println("Hello World");
                           ^
HelloWorld.java:4: error: class, interface, enum, or record expected
}
```
If you omit String, it will error: as above
If you omit HelloWorld, it will error: 
- "Syntax error on token "class", Identifier expected after this token"


If you omit System.out, it will error: The method println(String) is undefined for the type HelloWorld
If you omit println, it will error:
- Constructor call must be the first statement in a constructor
- Syntax error on token ".", super expected after this token

If you omit the ;, it will error: Syntax error, insert ";" to complete BlockStatements
If you omit the first ", it will error 
- Syntax error on token(s), misplaced construct(s)
- Hello cannot be resolved to a type
- Syntax error, insert ";" to complete BlockStatements
- String literal is not properly closed by a double-quote
- String literal is not properly closed by a double-quote

If you omit the second ", it will error: 
- String literal is not properly closed by a double-quote

If you omit the first {, it will error:
- Syntax error on token "HelloWorld", { expected after this token

If you omit the second {, it will error:
- Syntax error on token ")", { expected after this token

If you omit the first }, it will error:
- Syntax error, insert "}" to complete ClassBody

If you omit the second }, it will error:
- Syntax error, insert "}" to complete ClassBody

## Ex4
Describe what happens if, in HelloWorld.java, you misspell (by, say, omitting the second letter)

a. main

b. String

c. HelloWorld

d. System.out

e. println

If you misspell main, it will error:
```txt
Error: Could not find or load main class HelloWorld
Caused by: java.lang.ClassNotFoundException: HelloWorld
```
If you misspell String, it will error:
```txt
HelloWorld.java:2: error: cannot find symbol
    public static void main(Sring[] args) {
                            ^
  symbol:   class Sring
  location: class HelloWorld
1 error
```
If you misspell HelloWorld, it will error:
- The public type HlloWorld must be defined in its own file

If you misspell System.out, it will error:
- Sstem cannot be resolved

If you misspell println, it will error:
- The method pintln(String) is undefined for the type PrintStream

## Ex5
I typed in the following program. It compiles fine, but when I execute it, I get the error java.lang.NoSuchMethodError: main. What am I doing wrong?
```java
public class Hello {
   public static void main() {
      System.out.println("Doesn't execute");   
   }
}
```
Answer: you forgot the String[] args. It is required.

Source from: https://introcs.cs.princeton.edu/java/11hello/