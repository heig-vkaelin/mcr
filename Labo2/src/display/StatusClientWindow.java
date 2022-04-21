package display;

import account.Client;
import observers.Observer;
import observers.Subject;
import states.AccountState;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class StatusClientWindow implements Observer {
    private static final int INITIAL_WIDTH = 500;
    private static final int INITIAL_HEIGHT = 250;
    
    private final JFrame frame;
    private final HashMap<Integer, JLabel> labels;
    Client[] clients;
    
    public StatusClientWindow(Client[] clients) {
        this.clients = clients;
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Statuses");
        
        labels = new HashMap<>();
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        for (Client client : clients) {
            JLabel lbStatus = new JLabel(client.info());
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
        labels.get(client.getId()).setText(client.info());
    }
}
