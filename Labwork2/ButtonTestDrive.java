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
