public class AutomobileTestDrive {
  public static void main(String[] args) {
    Automobile a = new Automobile();
    a.init(10, 0, "ABC123");
    a.accelerate(10);
    System.out.println(a);
    a.decelerate(10);
    System.out.println(a);
  }
}
