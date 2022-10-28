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
