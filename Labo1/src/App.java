import display.BouncerDisplayer;

import javax.swing.*;
import java.awt.*;

public class App {
    public App() {
        BouncerDisplayer.getInstance().setTitle("Bouncers");
    }
    
    public void loop(int delta) {
        new Timer(delta, BouncerDisplayer.getInstance()).start();
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 50;
        new App().loop(DELTA_MS);
    }
}
