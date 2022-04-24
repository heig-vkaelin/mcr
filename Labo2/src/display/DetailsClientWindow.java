package display;

import account.Client;
import observers.Observer;
import observers.Subject;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre affichant les détails d'un client
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class DetailsClientWindow implements Observer {
    private static final int INITIAL_WIDTH = 700;
    private static final int INITIAL_HEIGHT = 250;
    
    private final JLabel lbCreditsContent;
    private final JLabel lbMilesContent;
    private final JLabel lbStatusContent;
    private final JLabel lbLastActionContent;
    
    /**
     * Crée une fenêtre affichant les détails du client souhaité
     *
     * @param client : client sélectionné
     */
    public DetailsClientWindow(Client client) {
        JFrame frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Details of client #" + client.getId());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastName = new JLabel("Last name :");
        JLabel lbLastNameContent = new JLabel(client.getLastName());
        lastNamePanel.add(lbLastName);
        lastNamePanel.add(lbLastNameContent);
        mainPanel.add(lastNamePanel);
        
        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbFirstName = new JLabel("First name :");
        JLabel lbFirstNameContent = new JLabel(client.getFirstName());
        firstNamePanel.add(lbFirstName);
        firstNamePanel.add(lbFirstNameContent);
        mainPanel.add(firstNamePanel);
        
        JPanel creditsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbCredits = new JLabel("Credits :");
        lbCreditsContent = new JLabel(String.valueOf(client.getBalance()));
        creditsPanel.add(lbCredits);
        creditsPanel.add(lbCreditsContent);
        mainPanel.add(creditsPanel);
        
        JPanel milesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMiles = new JLabel("Nb miles :");
        lbMilesContent = new JLabel(String.valueOf(client.getMiles()));
        milesPanel.add(lbMiles);
        milesPanel.add(lbMilesContent);
        mainPanel.add(milesPanel);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbStatus = new JLabel("Status :");
        lbStatusContent = new JLabel(String.valueOf(client.getActualStateToString()));
        statusPanel.add(lbStatus);
        statusPanel.add(lbStatusContent);
        mainPanel.add(statusPanel);
        
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastAction = new JLabel("Last action :");
        lbLastActionContent = new JLabel(client.getLastAction());
        lastActionPanel.add(lbLastAction);
        lastActionPanel.add(lbLastActionContent);
        mainPanel.add(lastActionPanel);
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
    
    @Override
    public void update(Subject subject) {
        Client client = (Client) subject;
        lbCreditsContent.setText(String.valueOf(client.getBalance()));
        lbMilesContent.setText(String.valueOf(client.getMiles()));
        lbStatusContent.setText(String.valueOf(client.getActualStateToString()));
        lbLastActionContent.setText(client.getLastAction());
    }
}
