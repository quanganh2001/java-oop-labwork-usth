import java.util.Scanner;

public class ShoppingCartTestDrive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ShoppingCart myCart = new ShoppingCart();
        System.out.print("How many items you want to buy? ");
        int number = userInput.nextInt();
        System.out.println("Enter the name of the item you want to buy: ");
        for (int i = 0; i < number; i++) {
            myCart.addToCart();
        }
        System.out.print("How many items you want to remove? ");
        number = userInput.nextInt();
        System.out.println("Enter the name of the item you want to remove: ");
        for (int i = 0; i < number; i++) {
            myCart.removeFromCart();
        }
        myCart.checkOut();
    }
}
