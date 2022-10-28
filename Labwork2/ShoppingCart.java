// Write a Java class "ShoppingCart" and a Java tester class "ShoppingCartTestDrive" to implement the OOP class design "ShoopingCart".

/*
- Apply "Encapsulation" concept in your classes
- Implement 3 methods: addToCart(), removeFromCart(), checkOut() and print demo results to the screen
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public Scanner userInput = new Scanner(System.in);
    private ArrayList<String> cartContents = new ArrayList<>();
    public void addToCart() {
        String something = userInput.nextLine();
        cartContents.add(something);
    }
    public void removeFromCart() {
        String something = userInput.nextLine();
        cartContents.remove(something);
    }
    public void checkOut() {
        userInput.close();
        System.out.println(cartContents.toString());
    }
}