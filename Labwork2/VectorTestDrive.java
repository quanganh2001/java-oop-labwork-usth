import java.util.*;
import java.lang.Math;

public class VectorTestDrive {
    public static void main(String[] args) {
        // Create and print out information of 2 vectors
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        v1.x = 2;
        v1.y = 3;
        v2.x = 5;
        v2.y = 6;

        // Calculate and print out the sum, subtraction and multiplication of the two created vectors
        System.out.println("Vector 1: " + v1.x + " " + v1.y);
        System.out.println("Vector 2: " + v2.x + " " + v2.y);
        v1.add(v2);
        v1.subtract(v2);
        v1.multiply(v2);
    }
}
