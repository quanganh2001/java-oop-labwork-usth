public class Automobile {
  private double fuel;
  private double speed;
  private String license;

  public void init(double fuel, double speed, String license) {
    this.fuel = fuel;
    this.speed = speed;
    this.license = license;
  }

  public void accelerate(double amount) {
    if (amount > 0 && fuel > 0) {
      speed += amount;
    }
  }
  public void decelerate(double amount) {
    if (amount > 0 && fuel <= 0) {
      speed -= amount;
    }
  }
  public String toString() {
    return "Fuel: " + fuel + " Speed: " + speed + " License: " + license;
  }
}
