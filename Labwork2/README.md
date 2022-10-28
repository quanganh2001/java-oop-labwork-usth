# Ex1
Write a Java class “Cow” and a Java tester class “CowTestDrive” to implement the OOP class design: “Cow”
- Apply the “Encapsulation” concept in your classes
- The moo() method should print out the text “Moo...!”
- The tester class should:
  + Make a Cow object
  + Set the age of the Cow to 4
  + Call the moo() method

[![image.png](https://i.postimg.cc/x8CKK6Qy/image.png)](https://postimg.cc/dkbkFmLL)


## File Cow.java
```java
// Write a Java class “Cow” and a Java tester class “CowTestDrive” to implement the OOP class design: “Cow”
// Apply the “Encapsulation” concept in your classes

// Make a Cow object
public class Cow {
  private String name;
  private String breed;
  private int age;

  // Set the age of the Cow to 4
  public void setAge(int age) {
      if (age > 0) {
          this.age = age;
      }
  }

  public int getAge() {
      return age;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  public void setBreed(String breed) {
      this.breed = breed;
  }

  public String getBreed() {
      return breed;
  }

  // Call the moo() method
  public void moo() {
      System.out.println("Moo...!");
  }
}
```
## File CowTestDrive.java
```java
// a Java tester class “CowTestDrive” to implement the OOP class design: “Cow”

public class CowTestDrive {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.setAge(4);
        cow.setBreed("Female");
        cow.setName("Lisa");
        System.out.println("Age: " + cow.getAge());
        System.out.println("Breed: " + cow.getBreed());
        System.out.println("Name: " + cow.getName());
        cow.moo();
    }
}
```
Result is:
```txt
Age: 4
Breed: Female
Name: Lisa
Moo...!
```
# Ex2 
Write a Java class “NameCard” and a Java tester class “NameCardTestDrive” to present the corresponding NameCard design:
- Apply the “Encapsulation” concept in your classes
- The tester class should print out the instance NameCard values


|       **Cow**      |
|:--------------:|
| name, breed, age |
| moo()          |


## File NameCard.java
```java
// Write a Java class “NameCard” and a Java tester class “NameCardTestDrive”to present the corresponding NameCard design:
// Apply the “Encapsulation” concept in your classes
package Labwork2;

import java.util.*;
import java.lang.Math;

public class NameCard {
    public String name;
    public String phone;
    public String email;
    public void getName() {
        System.out.println(name);
    }

    public void getPhone() {
        System.out.println(phone);
    }

    public void getEmail() {
        System.out.println(email);
    }
}
```

## File NameCardTestDrive.java
```java
package Labwork2;

import java.util.*;
import java.lang.Math;

// The tester class should print out the instance NameCard values

public class NameCardTestDrive {
    public static void main(String[] args) {
        NameCard nc = new NameCard();
        nc.name = "Nguyen Quang Anh";
        nc.phone = "0356326737";
        nc.email = "cocoi5659@gmail.com";
        nc.getName();
        nc.getPhone();
        nc.getEmail();
    }
}
```
Resutl is
```java
Nguyen Quang Anh
0356326737
cocoi5659@gmail.com
```
# Ex3 
Write a Java class “Vector” and a Java tester class “VectorTestDrive” to implement the OOP class design: “Vector”.
- Apply “Encapsulation” concept in your classes.
- In your tester class “VectorTestDrive”:
    + Create and print out information of 2 vectors
    + Calculate and print out the sum, subtraction and multiplication of the two created vectors


|                            **Vector**                           |
|:---------------------------------------------------------------:|
| int x, int y                                                     |
| add(Vector other), subtract(Vector other), multiply(Vector other) |

## File Vector.java
```java
// Write a Java class “Vector” and a Java tester class “VectorTestDrive” to implement the OOP class design: “Vector”.
// Apply “Encapsulation” concept in your classes.
package Labwork2;

import java.util.*;
import java.lang.Math;

public class Vector {
    int x;
    int y;

    public void add(Vector other) {
        Vector result = new Vector();
        result.x = this.x + other.x;
        result.y = this.y + other.y;
        System.out.println("Added: " + result.x + " " + result.y);
    }

    public void subtract(Vector other) {
        Vector result = new Vector();
        result.x = this.x - other.x;
        result.y = this.y - other.y;
        System.out.println("Added: " + result.x + " " + result.y);
    }

    public void multiply(Vector other) {
        int result = this.x * other.x + this.y * other.y;
        System.out.println("Scalar product: " + result);
    }
}
```

## File VectorTestDrive.java
```java
package Labwork2;

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
```
Result is
````java
Vector 1: 2 3
Vector 2: 5 6
Added: 7 9
Added: -3 -3
Scalar product: 28
````
# Ex4
Write a Java class "ShoppingCart" and a Java tester class "ShoppingCartTestDrive" to implement the OOP class design: "ShoppingCart".
- Apply "Encapsulation" concept in your classes
- Implement three methods addToCart(), removeFromCart(), checkOut() and print demo results to the screen

|                ShoppingCart               |
|:-----------------------------------------:|
| cartContents()                            |
| addToCart(), removeFromCart(), checkOut() |

```java
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
```
Test function file
```java
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
```
Output:
```txt
How many items you want to buy? 3
Enter the name of the item you want to buy: 
coca
fanta
orion
How many items you want to remove? 1
Enter the name of the item you want to remove: 
fanta
[coca, orion]
```
# Ex5
Write a Java class "Button" and a Java tester class "ButtonTestDrive" to implement the class design: "Button"
- Apply "Encapsulation" concept in your classes
- Implement four methods setColor(), setLabel(), dePress(), unDepress() and print demo results to the screen

|                    Button                   |
|:-------------------------------------------:|
| label, color                                 |
| setColor(), setLabel(), dePress(), unDepress() |

```java
// Write a Java class “Button” and a Java tester class “ButtonTestDrive” to implement the class design: “Button.

/*
- Apply “Encapsulation” concept in your classes
- Implement four methods setColor(), setLabel(), dePress(), unDepress() and print demo results to the screen
*/

public class Button {
    private String label;
    private String color;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }
    
    public String getColor() {
        return color;
    }

    public void Press() {
        this.color = "GREEN";
        this.label = "ON";
    }

    public void dePress() {
        this.color = "RED";
        this.label = "OFF";
    }
}
```
Test function file
```java
public class ButtonTestDrive {
    public static void main(String[] args) {
        Button myButton = new Button();
        myButton.setColor("RED");
        myButton.setLabel("OFF");
        System.out.println(myButton.getColor() + " " + myButton.getLabel());
        System.out.println("SMASH THAT SUBSCRIBE BUTTON");
        myButton.Press();
        System.out.println(myButton.getColor() + " " + myButton.getLabel());
        System.out.println("SMASH THAT UNSUBSCRIBE BUTTON");
        myButton.dePress();
        System.out.println(myButton.getColor() + " " + myButton.getLabel());
    }
}
```
Output:
```txt
RED OFF
SMASH THAT SUBSCRIBE BUTTON
GREEN ON
SMASH THAT UNSUBSCRIBE BUTTON
RED OFF
```