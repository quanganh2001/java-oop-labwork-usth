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