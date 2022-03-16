package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

public class BouncerDisplayer implements Displayer {
    private final JPanel panel;
    private final JFrame frame;
    private Image image;
    
    private static BouncerDisplayer instance;
    private static final int INITIAL_WIDTH = 640;
    private static final int INITIAL_HEIGHT = 480;
    
    private BouncerDisplayer() {
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        
        image = createImage();
        
        // Mise à jour de la taille de l'image au resize
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image = createImage();
            }
        });
    }
    
    public static BouncerDisplayer getInstance() {
        if (instance == null)
            instance = new BouncerDisplayer();
        return instance;
    }
    
    private Image createImage() {
        return panel.createImage(getWidth(), getHeight());
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
        return (Graphics2D) image.getGraphics();
    }
    
    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        
        // Remise à 0 du contenu affiché
        Graphics2D g = getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }
    
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
    
    @Override
    public void addKeyListener(KeyAdapter ka) {
        frame.addKeyListener(ka);
    }
}
