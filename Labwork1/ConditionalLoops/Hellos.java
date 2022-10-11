package ConditionalLoops;

public class Hellos {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        for (int i = 1; i <= n; i++) {
            System.out.print(i);

            // ends in 11 through 20 -> use "th" as suffix
            if (i % 100 >= 11 && i % 100 <= 20) {
                System.out.print("th");
            }

            // otherwise if ends in { 1, 2, 3} -> use { "st", "nd", "rd" } as suffix
            else if (i % 10 == 1) System.out.print("st");
            else if (i % 10 == 2) System.out.print("nd");
            else if (i % 10 == 3) System.out.print("rd");

            // otherwise use "th" as suffix
            else {
                System.out.print("th");
            }

            System.out.println(" Hello");
        }
    }
}