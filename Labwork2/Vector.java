// Write a Java class “Vector” and a Java tester class “VectorTestDrive” to implement the OOP class design: “Vector”.
// Apply “Encapsulation” concept in your classes.

import java.util.*;
import java.lang.Math;

public class Vector {
    int x;
    int y;

    public void add(Vector other) {
        // Create and print out information of 2 vectors
        Vector result = new Vector();
        result.x = this.x + other.x;
        result.y = this.y + other.y;
        /* Calculate and print out the addition, subtraction and multiplication of the two created vectors */
        System.out.println("Added: " + result.x + " " + result.y);
    }

    public void subtract(Vector other) {
        Vector result = new Vector();
        result.x = this.x - other.x;
        result.y = this.y - other.y;
        System.out.println("Subtract: " + result.x + " " + result.y);
    }

    public void multiply(Vector other) {
        int result = this.x * other.x + this.y * other.y;
        System.out.println("Scalar product: " + result);
    }
}
