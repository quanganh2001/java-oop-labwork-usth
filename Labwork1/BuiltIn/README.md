# Ex1
Suppose that a and b are `int` values. What does the following sequence of statments do?
```java
int t = a;
b = t;
a = b;
```
*Solution*: sets a, b and t equal to the original value of a.
# Ex4
Suppose that a and b are `int` values. Simplify the following expression: (!(a < b) && !(a > b))

*Solution*: (a == b)
# Ex5
The *exclusive or operator* ^ for `boolean` operands is defined to be `true` if they are different, `false` if they are the same. Give a truth table for this function
| A | B | Q | BOTH are true so false   |
|---|---|---|--------------------------|
| T | T | F | only one is true so true |
| T | F | T | only one is true so true |
| F | T | T | only one is true so true |
| F | F | F | BOTH are true so false   |
# Ex6
Why does 10/3 give 3 and not 3.33333333?
Solution: Since both 10 and 3 are integer literals, Java sees no need for type conversion and uses integer division. You should write 10.0/3.0 if you mean the numbers to be double literals. If you write 10/3.0 or 10.0/3, Java does implicit conversion to get the same result.
# Ex7
What do each of the following print?
a. `System.out.println(2 + "bc");` prints: 2bc

b. `System.out.println(2 + 3 + "bc");` prints: 5bc

c. `System.out.println((2_3) + "bc");` prints: 5bc

d. `System.out.println("bc" + (2+3));` prints: bc5

e. `System.out.println("bc" + 2 + 3);` prints: bc23
# Ex8
Explain how to use Quadratic.java to find the square root of a number.
```java
package BuiltIn;

public class Quadratic {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        double c = Double.parseDouble(args[1]);

        double discriminant = b*b - 4.0*c;
        double sqroot = Math.sqrt(discriminant);

        double root1 = (-b + sqroot) / 2.0;
        double root2 = (-b + sqroot) / 2.0;

        System.out.println(root1);
        System.out.println(root2);
    }
}
```
*Solution*: to find the square root of c, find the roots of x^2 + 0x - c.

**How to run?**
1. Complication: `javac Quadratic.java`
2. Execution: `java Quadratic b c`

Given b and c, solves for the roots of $x*x + b*x + c$.

Assumes both roots are real valued.

Example:
```txt
java Quadratic -1.0 -1.0
1.618033988749895
-0.6180339887498949
```
# Ex16
A physics student gets unexpected results when using the code
````java
double force = G * mass1 * mass2 / r * r;
````
to compute values according to the formula $F = Gm_1m_2/r^2$. Explain the problem and correct the code

*Solution*: It divides by r, then multiples by r (instead of dividing by r * r). Use parentheses:
```java
double force = G * mass1 * mass2 / r * r;
```
# Ex18
Write a program Distance.java that makes two integer command-line arguments x and y and prints the Euclidean distance from the point (x, y) to the origin (0, 0).
```java
package BuiltIn;

public class Distance {
    public static void main(String[] args) {
        // parse x - and y coordinates from command-line arguments
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        // compute distance to (0, 0)
        double dist = Math.sqrt(x*x + y*y);

        // output distance
        System.out.println("distance from (" + x + ", " + y + ") to (0, 0) = " + dist);
    }
}
```
**How to run?**
1. Complication: `javac Distance.java`
2. Execution: `java Distance.java`

Prints the distance from (x, y) to the origin, where x and y are integers.

Example:
```txt
java Distance 5 12
distance from (5, 12) to (0, 0) = 13.0
```
# Ex20
Write a program SumOfTwoDice.java that prints the sum of two random integers between 1 and 6 (such as you might get when rolling dice).
```java
package BuiltIn;

public class SumOfTwoDice {
    public static void main(String[] args) {
        int SIDES = 6;
        int a = 1 + (int) (Math.random() * SIDES);
        int b = 1 + (int) (Math.random() * SIDES);
        int sum = a + b;
        System.out.println(sum);
    }
}
```
**How to run?**
1. Complication: `javac SumOfTwoDice.java`
2. Execution: `java SumOfTwoDice`

Generate 2 integers between 1 and 6, and print their sum.

Example:

```txt
java SumOfTwoDice
5
```
# Ex21
Write a program SumOfSines.java that takes a double command-line argument t (in degrees) and prints the value of sin(2t) + sin(3t).
```java
package BuiltIn;

public class SumOfSines {
    public static void main(String[] args) {
        double degrees = Double.parseDouble(args[0]);
        double radians = Math.toRadians(degrees);
        double sum = Math.sin(2 * radians) + Math.sin(3 * radians);
        System.out.println(sum);
    }
}
```
**How to run?**
1. Complication: `javac SumOfSines.java`
2. Execution: `java SumOfSines t`

Read in an angle t (in degrees) and print sin(2t) + sin(3t).

Example:
```txt
java SumOfSines 30
1.8660254037844386
```
# Ex23
Write a program SpringSeason.java that takes two int values m and d from the command line and prints true if day d of month m is between March 20 (m = 3, d =20) and June 20 (m = 6, d = 20), false otherwise.
```java
package BuiltIn;

public class SpringSeason {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        boolean isSpring = (month == 3 && day >= 20 && day <= 31)
                        || (month == 4 && day >= 1 && day <= 30)
                        || (month == 5 && day >= 1 && day <= 31)
                        || (month == 6 && day >= 1 && day <= 20);
        System.out.println(isSpring);
    }
}
```
**How to run?**
1. Complication: `javac SpringSeason.java`
2. Execution: `java day month`

Prints true if the given day and month fall between March 20 (inclusive) and June 20 (inclusive)

Example:
```txt
java SpringSeason 3 20
true

java SpringSeason 9 11
false
```

Source: https://introcs.cs.princeton.edu/java/12types/
