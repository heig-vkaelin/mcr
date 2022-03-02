package display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BouncerDisplayer implements Displayer {
    private final JPanel panel = new JPanel();
    private final JFrame frame = new JFrame();
    BufferedImage image;
    
    private static BouncerDisplayer instance;
    private static final int INITIAL_WIDTH = 640;
    private static final int INITIAL_HEIGHT = 480;
    
    private BouncerDisplayer() {
//        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        panel = new JPanel();
//        panel.setBackground(Color.WHITE);
        frame.setContentPane(panel);
        
        panel.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
        frame.pack();
        
        frame.setVisible(true);

//        image = (BufferedImage) panel.createImage(640, 480);
//        System.out.println(image);
    }
    
    public static BouncerDisplayer getInstance() {
        if (instance == null)
            instance = new BouncerDisplayer();
        return instance;
    }
    
    @Override
    public int getWidth() {
        return panel.getWidth();
    }
    
    @Override
    public int getHeight() {
        return panel.getHeight();
    }
    
    @Override
    public Graphics2D getGraphics() {
        if (image == null)
            image = (BufferedImage) panel.createImage(getWidth(), getHeight());
        
        return (Graphics2D) image.getGraphics();
    }
    
    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        image = null;
    }
    
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
