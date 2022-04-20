package display;

import account.Client;
import observers.Observer;
import observers.Subject;
import states.AccountState;

import javax.swing.*;
import java.awt.*;

public class DetailsClientWindow implements Observer {
    private static final int INITIAL_WIDTH = 500;
    private static final int INITIAL_HEIGHT = 250;
    
    private final Client client;
    
    private final JFrame frame;
    private JLabel lbLastNameContent;
    private JLabel lbFirstNameContent;
    private JLabel lbCreditsContent;
    private JLabel lbMilesContent;
    private JLabel lbStatusContent;
    private JLabel lbLastActionContent;
    
    public DetailsClientWindow(Client client) {
        this.client = client;
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Details of client #" + client.getId());
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastName = new JLabel("Last name :");
        lbLastNameContent = new JLabel(client.getLastName());
        lastNamePanel.add(lbLastName);
        lastNamePanel.add(lbLastNameContent);
        mainPanel.add(lastNamePanel);
        
        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbFirstName = new JLabel("First name :");
        lbFirstNameContent = new JLabel(client.getFirstName());
        firstNamePanel.add(lbFirstName);
        firstNamePanel.add(lbFirstNameContent);
        mainPanel.add(firstNamePanel);
        
        JPanel creditsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbCredits = new JLabel("Credits :");
        lbCreditsContent = new JLabel(String.valueOf(client.getState().getBalance()));
        creditsPanel.add(lbCredits);
        creditsPanel.add(lbCreditsContent);
        mainPanel.add(creditsPanel);
        
        JPanel milesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMiles = new JLabel("Nb miles :");
        lbMilesContent = new JLabel(String.valueOf(client.getState().getMiles()));
        milesPanel.add(lbMiles);
        milesPanel.add(lbMilesContent);
        mainPanel.add(milesPanel);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbStatus = new JLabel("Status :");
        lbStatusContent = new JLabel(String.valueOf(client.getState().toString()));
        statusPanel.add(lbStatus);
        statusPanel.add(lbStatusContent);
        mainPanel.add(statusPanel);
        
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastAction = new JLabel("Last action :");
        lbLastActionContent = new JLabel("");
        lastActionPanel.add(lbLastAction);
        lastActionPanel.add(lbLastActionContent);
        mainPanel.add(lastActionPanel);
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
    
    @Override
    public void update() {
        lbCreditsContent.setText(String.valueOf(client.getState().getBalance()));
        lbMilesContent.setText(String.valueOf(client.getState().getMiles()));
        lbStatusContent.setText(String.valueOf(client.getState().toString()));
    }
}
