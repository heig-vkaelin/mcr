package display;

import account.Account;

import javax.swing.*;
import java.awt.*;

public class DetailsClientWindow {
    private static final int INITIAL_WIDTH = 500;
    private static final int INITIAL_HEIGHT = 250;
    
    private final JFrame frame;
    
    public DetailsClientWindow(Account account) {
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Details of client #" + account.getId());
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastName = new JLabel("Last name :");
        JLabel lbLastNameContent = new JLabel(account.getLastName());
        lastNamePanel.add(lbLastName);
        lastNamePanel.add(lbLastNameContent);
        mainPanel.add(lastNamePanel);
        
        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbFirstName = new JLabel("First name :");
        JLabel lbFirstNameContent = new JLabel(account.getFirstName());
        firstNamePanel.add(lbFirstName);
        firstNamePanel.add(lbFirstNameContent);
        mainPanel.add(firstNamePanel);
        
        JPanel creditsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbCredits = new JLabel("Credits :");
        JLabel lbCreditsContent = new JLabel(String.valueOf(account.getState().getBalance()));
        creditsPanel.add(lbCredits);
        creditsPanel.add(lbCreditsContent);
        mainPanel.add(creditsPanel);
        
        JPanel milesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMiles = new JLabel("Nb miles :");
        JLabel lbMilesContent = new JLabel(String.valueOf(account.getState().getMiles()));
        milesPanel.add(lbMiles);
        milesPanel.add(lbMilesContent);
        mainPanel.add(milesPanel);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbStatus = new JLabel("Status :");
        JLabel lbStatusContent = new JLabel(String.valueOf(account.getState().toString()));
        statusPanel.add(lbStatus);
        statusPanel.add(lbStatusContent);
        mainPanel.add(statusPanel);
        
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLastAction = new JLabel("Last action :");
        JLabel lbLastActionContent = new JLabel("");
        lastActionPanel.add(lbLastAction);
        lastActionPanel.add(lbLastActionContent);
        mainPanel.add(lastActionPanel);
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
