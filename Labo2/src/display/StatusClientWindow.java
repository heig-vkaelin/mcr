package display;

import account.Client;
import observers.Observer;
import observers.Subject;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Fenêtre affichant le status de chaque client de l'application
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class StatusClientWindow implements Observer {
    private static final int INITIAL_WIDTH = 500;
    private static final int INITIAL_HEIGHT = 250;
    
    private final HashMap<Integer, JLabel> labels;
    
    /**
     * Crée une fenêtre affichant le status de chaque client
     *
     * @param clients : les clients de l'application
     */
    public StatusClientWindow(Client[] clients) {
        JFrame frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Statuses");
        
        labels = new HashMap<>();
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        for (Client client : clients) {
            JLabel lbStatus = new JLabel(client.toStringDetailed());
            lbStatus.setForeground(client.getColor());
            mainPanel.add(lbStatus);
            labels.put(client.getId(), lbStatus);
        }
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
    
    @Override
    public void update(Subject subject) {
        Client client = (Client) subject;
        labels.get(client.getId()).setForeground(client.getColor());
        labels.get(client.getId()).setText(client.toStringDetailed());
    }
}
