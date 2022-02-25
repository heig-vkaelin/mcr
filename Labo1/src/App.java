import display.JBouncer;

import javax.swing.*;
import java.awt.*;

public class App {
    public App() {
        JBouncer.getInstance();
        JFrame frame = new JFrame("Bouncer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(JBouncer.getInstance(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void loop(int delta) {
        new Timer(delta, JBouncer.getInstance()).start();
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 50;
        new App().loop(DELTA_MS);
    }
}
