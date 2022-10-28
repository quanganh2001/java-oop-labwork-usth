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
