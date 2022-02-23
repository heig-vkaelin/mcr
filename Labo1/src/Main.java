import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final JBouncer bouncer = new JBouncer();
        JFrame frame = new JFrame("Bouncer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(bouncer, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
        // Lance l'animation
        bouncer.start();
    }
}
