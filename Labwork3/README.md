# 1.4. Arrays
## Ex2
Describe and explain what happens when you try to compile a program HugeArray.java with the following statement:
```java
int n = 1000;
int[] a = new int[n*n*n*n];
```

**How to run?**

Compilation:`javac HugeArray.java`

Execution:`java HugeArray`

```java
public class HugeArray {
    public static void main(String[] args) {
        int n = 1000;
        int [] a = new int[n*n*n*n];
        System.out.println(a.length);
    }
}
```
Attempts to create an array of size n^4 for n = 1000.

This program compiles cleans.

When n is 1000, it leads to the following error: java.lang.NegativeArraySizeException because 1000^4 overflows an int and results in a negative integer.

When n is 2000, it leads to the following error: java.lang.OutOfMemoryError: Requested array size exceeds VM limit

## Ex4
Write a code fragement that reverses the order of values in a one-dimensional string array. Do not create another array to hold the result. *Hint*: Use the code in the text for exchanging two elements.

**Solution**
```java
int n = a.length;
for (int i = 0; i < n/2; i++) {
    String temp = a[n-i-1];
    a[n-i-1] = a[i];
    a[i] = temp;
}
```
## Ex5
What is wrong with the following code fragment?
```java
int[] a;
for (int i = 0; i < 10; i++)
   a[i] = i * i;
```
*Solution*: It does not allocate memory for `a[]` with `new`. The code results in a `variable might not have been initialized` compile-time error.
## Ex9
What does the following code fragment print?
```java
int[] a = { 1, 2, 3 };
int[] b = { 1, 2, 3 };
System.out.println(a == b);
```
*Solution*: It prints false. The == operator compares whether the (memory addresses of the) two arrays are identical, not whether their corresponding values are equal.
## Ex10
Write a program Deal.java that takes an integer command-line argument `n` and prints `n` poker hands (five cards each) from a shuffled deck, separated by blank lines.
```java
public class Deal {
    public static void main(String[] args) {
        int CARDS_PER_PLAYER = 5;

        // number of players
        int PLAYERS = Integer.parseInt(args[0]);

        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        int n = SUITS.length * RANKS.length;

        // initialize deck
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print shuffled deck
        for (int i = 0; i < PLAYERS * CARDS_PER_PLAYER; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1)
                System.out.println();
        }
    }
}
```
**How to run?**

Complication: `javac Deal.java`

Execution: `java Deal PLAYERS`

Deal 5-cards hands at random to the given number of players. For example, if you input `java Deal 3`, the output is:
```txt
6 of Diamonds
8 of Diamonds
4 of Hearts
Ace of Hearts
King of Hearts

5 of Diamonds
9 of Diamonds
5 of Spades
8 of Hearts
Queen of Clubs

Ace of Spades
9 of Hearts
2 of Diamonds
Jack of Clubs
7 of Hearts
```
## Ex11
Write a program HowMany.java that takes a variable number of integer command-line arguments and prints the integer `i` with probability proportional to the `i`th command-line argument.
```java
public class HowMany {
    public static void main(String[] args) {
        // number of command-line arguments
        int n = args.length;

        // output message
        System.out.print("You entered " + n + " command-line argument");
        if (n == 1) System.out.println(".");
        else        System.out.println("s.");
    }
}
```
**How to run?**

Complication: `javac HowMany.java`

Execution: `java HowMany arg1 arg2 arg3 ...`

HowMany takes a variable number of command-line arguments and prints a message reporting how many there are.

For example, if you type `java HowMany Alice Bob Carol`, it prints "You entered 3 command-line arguments."

## Ex12
Write a program DiscreteDistribution.java that takes a variable number of integer command-line arguments and prints the integer `i` with probability proportional to the `i`th command-line argument.
```java
public class DiscreteDistribution {
    public static void main(String[] args) {
        // read in frequency of occurence of n values
        int n = args.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[i] = Integer.parseInt(args[i]);
        }

        // compute total count of all frequencies
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += freq[i];
        }

        // generate random integer with probability proportional to frequency
        int r = (int) (total * Math.random()); // integer in [0, total)
        int sum = 0;
        int event = -1;
        for (int i = 0; i < n && sum <= r; i++) {
            sum += freq[i];
            event = i;
        }

        System.out.println(event);
    }
}
```
**How to run?**

Complication: `javac DiscreteDistribution.java`

Execution: `java DiscreteDistribution freq0 freq1 freq2 freq3 ...`

Reads in an arry of n frequency counts from the command line, and prints out i with probability proportional to the ith frequency count.

*Example*:
- six equally likely events: `java DiscreteDistribution 1 1 1 1 1 1`, so the output is 3
- six events, one 3x more likely than the others: `java DiscreteDistribution 1 1 1 1 1 3`, so the output is 2

## Ex14
Write a code fragment Transpose.java to transpose a square two-dimensional array in place without creating a second array.
```java
public class Transpose {
    public static void main(String[] args) {
        // create n-by-n matrix
        int n = Integer.parseInt(args[0]);
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n*i + j;
            }
        }

        // print out initial matrix
        System.out.println("Before");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        // transpose in-place
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // print out tranposed matrix
        System.out.println();
        System.out.println("After");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }
}
```
**How to run?**

Complication: `javac Transpose.java`

Execution: `java Transpose n`

Transpose an n-by-n matrix in-place, without creating a second 2D array.

For example, if you type `java Transpose 3`, the output is:
```txt
Before
------
   0   1   2
   3   4   5
   6   7   8

After
------
   0   3   6
   1   4   7
   2   5   8
```
# 1.5. Input and Output
## Ex1
Write a program MaxMin.java that reads in integers (as many as the user enters) from standard inputs and prints out the maximum and minimum values.

**Dependencies: StdIn.java StdOut.java**

Source:

1. https://introcs.cs.princeton.edu/java/stdlib/StdIn.java
2. https://introcs.cs.princeton.edu/java/stdlib/StdOut.java
```java
package input_output;

public class MaxMin {
    public static void main(String[] args) {

        // first value read initialized min and max
        int max = StdIn.readInt();
        int min = max;

        // read in the data, keep track of min and max
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value > max) max = value;
            if (value < min) min = value;
        }

        // output
        StdOut.println("maximum  = " + max + ", minimum = " + min);
    }
}
```
**How to run?**

Complication: `javac MaxMin.java`

Execution: `java MaxMin`

- input required from standard input
- use Ctrl-d (OS X or Dr. Java) or Ctrl-z (Windows) for EOF

Read in integers from standarad input and print out the maximum and minimum values.

Example:
```txt
% java MaxMin
23 45 17 56 32
89 10 53 32 34
16
Ctrl-d
maximum = 89, minimum = 10
```
## Ex3
Write a program Stats.java that takes an integer command-line argument *n*, reads *n* floating-point numbers from standard input, and prints their *mean* (average value) and *sample standard deviation* (square root of the sum of the squares of their differences)

**Dependencies: StdIn.java StdOut.java**
```java
package input_output;

public class Stats {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] a = new double[n];

        // read data and compute statistics
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readDouble();
        }

        // compute mean
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        double mean = sum / n;

        // compute standard deviation
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            sum2 += (a[i] - mean) * (a[i] - mean);
        }
        double stddev = Math.sqrt(sum2 / (n - 1));

        // print results
        StdOut.println("Mean                      = " + mean);
        StdOut.println("Sample standard deviation = " + stddev);
    }
}
```
**How to run?**
Compilation:  `javac Stats.java`

Execution:    `java Stats n`

Dependencies: `StdIn.java StdOut.java`

Reads in a command-line integer n, a sequence of n real numbers from standard input, and prints the mean and sample standard deviation.
```txt
% java Stats 6
10.0 5.0 6.0
3.0 7.0 32.0
<Ctrl-d>
Mean                      = 10.5
Sample standard deviation = 10.784247771634329
```
## Ex5
Write a program LongestRun.java that reads in a sequence of integers and prints out both the integer that appears in a longest consecutive run and the length of the run. For example, if the input `1 2 2 1 5 1 1 7 7 7 7 1 1`, then your program should print `Longest run: 4 consecutive 7s`
```java
package Labwork3.input_output;

public class LongestRun {
    public static void main(String[] args) {

        // degenerate case with no input integers
        if (StdIn.isEmpty()) {
            StdOut.println("no longest consecutive run");
            return;
        }

        int prev = StdIn.readInt();
        int count = 1;
        int best      = prev;
        int bestCount = count;

        while (!StdIn.isEmpty()) {
            // read in the next value
            int current = StdIn.readInt();

            // update current run
            if (current == prev) count++;
            else {
                prev = current;
                count = 1;
            }

            // update champion values
            if (count > bestCount) {
                bestCount = count;
                best      = current;
            }
        }

        // output
        StdOut.println("Longest run: " + bestCount + " consecutive " + best + "s");
    }
}
```
**How to run?**

Compilation:  `javac LongestRun.java`

Execution:    `java LongestRun n`

Dependencies: `StdIn.java StdOut.java`

Read in a sequence of integers and prints out both the integer that appears in a longest consecutive run and length of the run.
```txt
% java LongestRun
1 2 2 1 5 1 1 7 7 7 7 1 1
Ctrl-d
Longest run: 4 consecutive 7s
```
## Ex11
Write a program WordCount.java that reads in text from standard input and prints out the number of words in the text. For the purpose of this exercise, a word is a sequence of non-whitespace characters that is surrounded by whitespace.
```java
package Labwork3.input_output;

public class WordCount {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
        }

        // output
        StdOut.println("number of words = " + count);
    }
}
```
**How to run?**

Compilation:  `javac WordCount.java`

Execution:    `java WordCount`

Dependencies: `StdIn.java StdOut.java`

Read in a sequence of strings from standard input and print out the number of strings read in
```txt
% java WordCount
it was the best of times
it was the worst of times
number of words  = 12
```
## Ex15
Write a program Closest.java that makes three floating-point command-line arguments x,y,z reads from standard input a sequence of point coordinates $(x_i,y_i,z_i)$, and prints the coordinates of the point closest to (x,y,z). Recall that the square of the distance between (x,y,z) and $(x_i,y_i,z_i)$ is $(x-x_i)^2 + (y-y_i)^2 + (z-z_i)^2$. For efficiency, do not use `Math.sqrt()` or `Math.pow()`.
```java
package Labwork3.input_output;

public class Closest {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        double bestx = Double.NaN;
        double besty = Double.NaN;
        double bestz = Double.NaN;
        double bestDist2 = Double.POSITIVE_INFINITY;

        while (!StdIn.isEmpty()) {
            double xi = StdIn.readDouble();
            double yi = StdIn.readDouble();
            double zi = StdIn.readDouble();
            double dist2 = (x - xi) * (x - xi) + (y - yi) * (y - yi) + (z - zi) * (z - zi);
            if (dist2 < bestDist2) {
                bestx = xi;
                besty = yi;
                bestz = zi;
            }
        }

        // output
        StdOut.printf("Closest point = (%f, %f, %f)\n", bestx, besty, bestz);
    }
}
```
**How to run?**

Compilation:  `javac Closest.java`

Execution:    `java Closest 1.0 5.0 2.0`

Dependencies: `StdIn.java StdOut.java`

Takes three command-line arguments x, y, z; reads from standard input a sequence of point coordinates (xi, yi, zi) and prints the coordinates of the point closest to (x, y, z).
```txt
% java Closest 1.0 5.0 2.0
1.0 3.0 9.0
5.0 3.0 2.5
9.0 6.0 2.0
2.0 6.0 3.0
5.0 6.0 5.0
<Ctrl + D>
Closest point = (5.000000, 6.000000, 5.000000)
```
## Ex16
Given the positions and masses of a sequence of objects, write a program to compute their center-of-mass or centroid. The centroid is the average position of the *n* objects, weighted by mass. If the positions and masses are given by $(x_i,y_i,m_i)$, then the centroid *(x, y, m)* is given by:
```txt
m  = m_1 + m_2 + ... + m_n
x  = (m_1x_1 +  ... + m_nx_n) / m
y  = (m_1y_1 +  ... + m_ny_n) / m
```
Write a program `Centroid.java` that reads in a sequence of positions and masses $(x_i,y_i,m_i)$ from standard input and prints out their center of mass *(x, y, m). Hint:* model your program after Average.java
```java
package Labwork3.input_output;

public class Average {
    public static void main(String[] args) {
        int count = 0; // number input values
        double sum = 0.0; // sum of input values

        // read data and compute statistics
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        // compute the average
        double average = sum / count;

        // print results
        StdOut.println("Average is " + average);
    }
}
```
**How to run?**

Compilation:  `javac Average.java`

Execution:    `java Average`

Dependencies: `StdIn.java StdOut.java`

Reads in a sequence of real numbers, and computers their average
```txt
% java Average
10.0 5.0 6.0
3.0 7.0 32.0
Average is 10.5
```
## Ex17
Write a program Checkerboard.java that takes a command-line argument n and plots an n-by-n checkerboard with red and black squares. Color the lower-left square red.

[![image.png](https://i.postimg.cc/mg5cJ2rD/image.png)](https://postimg.cc/75SYT408)

```java
public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 != 0) StdDraw.setPenColor(StdDraw.BLACK);
                else                  StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
```
**How to run?**

Compilation:  `javac Checkerboard.java`

Execution:    `java Checkerboard n`

Dependencies: `StdDraw.java`

Source: https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java

Plot an n-by-n checkerboard

Example: `java Checkerboard 4`. So the output is:

[![image.png](https://i.postimg.cc/Cx5ydwsb/image.png)](https://postimg.cc/LncQbK7s)

## Ex21
Write a program Rose.java that takes a command-line argument n and plots a rose with n petals (if n is odd) or 2n petals (if n is even) by plotting the polar coordinates $(r, \phi)$ of the function $r = sin(n * \phi)$ for $\phi$ ranging from 0 to $2\pi$ radians. Below is the desired output for n = 4, 7, and 8.

[![image.png](https://i.postimg.cc/NMDq5FS7/image.png)](https://postimg.cc/9RDNkmWr)

```java
package Labwork3.input_output;

public class Rose {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(-1, +1);
        StdDraw.setYscale(-1, +1);
        StdDraw.setPenColor(StdDraw.PINK);

        double x0 = 0, y0 = 0;
        for (double t = 0.0; t <= 360.0; t += 0.1) {
            double theta = Math.toRadians(t);
            double r = Math.sin(n * theta);
            double x1 = r * Math.cos(theta);
            double y1 = r * Math.sin(theta);
            StdDraw.line(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
        }
    }
}
```
**How to run?**

Compilation:  `javac Rose.java`

Execution:    `java Rose n`

Dependencies: `StdDraw.java`

Plots an n petal rose (if n is odd) and a 2n-petal rose if n is even, using standard graphics.

For example, if you type `java Rose 4`, the output is:

[![image.png](https://i.postimg.cc/DZ60n2cR/image.png)](https://postimg.cc/8JFNbg9b)

## Ex22
Write a program Banner.java that takes a string s from the command line and display it in banner style on the screen, moving from left to right and wrapping back to the beginning of the strings as the end is reached. Add a second command-line argument to control the speed.
```java
package Labwork3.input_output;

import java.awt.Font;

public class Banner {
    public static void main(String[] args) {
        String s = args[0];

        // set the font
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.enableDoubleBuffering();

        for (double i = 0.0; true; i += 0.01) {
            StdDraw.clear(StdDraw.BLACK);
            StdDraw.text((i % 1.0), 0.5, s);
            StdDraw.text((i % 1.0) - 1.0, 0.5, s);
            StdDraw.text((i % 1.0) + 1.0, 0.5, s);
            StdDraw.pause(60);
            StdDraw.show();
        }
    }
}
```
**How to run?**

Compilation:  `javac Banner.java`

Execution:    `java Banner s`

Dependencies: `StdDraw.java`

Plots the String s, and move it across the screen, left-to-right, wrapping around when it reaches the border.

For example, if you type `java Banner Hello`, the output is:

[![image.png](https://i.postimg.cc/252dXfZ8/image.png)](https://postimg.cc/5HQF6TgZ)

## Ex26
Write a program Circles.java that draws filled circles of random size at random positions in the unit square, producing images like those below. Your program should take four command-line arguments: the number of circles, the probability that each circle is black, the minimum radius, and the maximum radius.
```java
import java.awt.Color;
public class Circles {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double min = Double.parseDouble(args[2]);
        double max = Double.parseDouble(args[3]);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = min + Math.random() * (max - min);
            if (Math.random() < p) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.setPenColor(StdDraw.WHITE);
            }
            StdDraw.filledCircle(x, y, r);
        }
    }
}
```
**How to run?**

Compilation:  `javac Circles.java`

Execution:    `java Circles 50 .75 .1 .2`

Output:

[![image.png](https://i.postimg.cc/hG2Stff4/image.png)](https://postimg.cc/GBs0M3F6)

# Part 2
Write a Java program to manage the employee information of a company as follows:
- Information of each employee is entered from keyboard, including:
    - Employee ID
    - Employee full name
    - Employee department
    - Basic salary
    - Extra salary
- Number of employees (n) in entered from keyboard
- Information of n employees are saved in a text file named: `employees.txt` file and calculated by the formula: `income = basic_salary + extra_salary * 2.5`
- Print out to the screen the following information of n employees:
    - Employee ID
    - Employee full name
    - Employee department
    - Employee income

**Solution:**

Employee.java
```java
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Employee {
  private String ID;
  private String name;
  private String department;
  private double basic_salary;
  private double extra_salary;

  public Employee(String ID, String name, String department, double basic_salary, double extra_salary) {
    this.ID = ID;
    this.name = name;
    this.department = department;
    this.basic_salary = basic_salary;
    this.extra_salary = extra_salary;
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public double getBasic_salary() {
    return basic_salary;
  }

  public double getExtra_salary() {
    return extra_salary;
  }

  public String toString() {
    String lineID = "Employee ID: " + ID;
    String lineName = "Employee full name: " + name;
    String lineDepartment = "Employee department: " + department;
    String lineSalary = "Basic salary: " + basic_salary;
    String lineExtraSalary = "Extra salary: " + extra_salary;
    return lineID + "\r\n" + lineName + "\r\n" + lineDepartment + "\r\n" + lineSalary + "\r\n" + lineExtraSalary + "\r\n--------------------";
  }

  public void writeToFile(String path) {
    try {
      FileWriter fileWriter = new FileWriter(path, true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(this.toString());
      bufferedWriter.newLine();
      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
```
Company.java
```java
import java.util.Scanner;
import java.io.*;

public class Company {
  public static void main(String[] args) {
    clearScreen();
    Scanner input = new Scanner(System.in);
    int choice = 0;
    while (true) {
      System.out.println("Welcome to the company database! Enter the number of your choice:");
      System.out.println("1. Add employee");
      System.out.println("2. Show employee");
      System.out.println("3. Exit");
      System.out.print("Your choice: ");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          System.out.print("\nHow many employees do you want to add? ");
          int num = 0;
          while (true) {
            try {
              num = input.nextInt();
              break;
            } catch (Exception e) {
              System.out.print("Please enter an integer: ");
              input.nextLine();
            }
          }
          for (int i = 0; i < num; i++) {
            System.out.println("==> Employee " + (i + 1) + ":");
            System.out.print("Employee ID: ");
            String ID = input.next();
            System.out.print("Employee full name: ");
            String name = input.next();
            System.out.print("Employee department: ");
            String department = input.next();
            System.out.print("Basic salary: ");
            double basic_salary = 0;
            while (true) {
              try {
                basic_salary = input.nextDouble();
                if (basic_salary <= 0) {
                  throw new Exception("Basic salary must be larger than 0!");
                }
                break;
              } catch (Exception e) {
                System.out.println("Error: basic salary must be a number larger than 0!");
                System.out.print("Basic salary: ");
              }
            }
            System.out.print("Extra salary: ");
            double extra_salary = 0;
            while (true) {
              try {
                extra_salary = input.nextDouble();
                if (extra_salary <= 0) {
                  throw new Exception("Extra salary must be larger than 0!");
                }
                break;
              } catch (Exception e) {
                System.out.println("Error: extra salary must be a number larger than 0!");
                System.out.print("Extra salary: ");
              }
            }
            Employee employee = new Employee(ID, name, department, basic_salary, extra_salary);
            employee.writeToFile("employee.txt");
          }
          clearScreen();
          break;
        case 2:
          clearScreen();
          showEmployee();
          System.out.println();
          break;
        case 3:
          input.close();
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice!");
          break;
      }
    }
  }

  private static void showEmployee() {
    try {
      FileReader fileReader = new FileReader("./employee.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line = bufferedReader.readLine();
      while (line != null) {
        if (line.startsWith("Basic salary")) {
          String[] salary = line.split(": ");
          double basic_salary = Double.parseDouble(salary[1]);
          line = bufferedReader.readLine();
          String[] extra_salary = line.split(": ");
          double extra_salary_value = Double.parseDouble(extra_salary[1]);
          System.out.println("Income: " + (basic_salary + extra_salary_value * 2.5));
          line = bufferedReader.readLine();
        } else {
          System.out.println(line);
          line = bufferedReader.readLine();
        }
      }
      bufferedReader.close();
      fileReader.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
```
Output:
```txt
Employee ID: BA10
Employee full name: Quang
Employee department: Anh
Basic salary: 2000.0
Extra salary: 5000.0
--------------------
```
```txt
Employee ID: BA10
Employee full name: Quang
Employee department: Anh
Income: 14500.0
--------------------

Welcome to the company database! Enter the number of your choice:
1. Add employee
2. Show employee
3. Exit
```
