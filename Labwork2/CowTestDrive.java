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
