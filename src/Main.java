import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.setProperty( "sun.java2d.uiScale", "1.0" ); // Forces UI scale to 1.0
        GUIMain.setup(Serializer.dserSettings()); // setup leads to title screen
    }
}
