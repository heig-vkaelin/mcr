package display;

import account.Account;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class StatusClientWindow {
    private static final int INITIAL_WIDTH = 500;
    private static final int INITIAL_HEIGHT = 250;
    
    private final JFrame frame;
    private final HashMap<Integer, JLabel> labels;
    
    public StatusClientWindow(Account[] accounts) {
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Statuses");
        
        labels = new HashMap<>();
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        for (Account account : accounts) {
            JLabel lbStatus = new JLabel(account.info());
            lbStatus.setForeground(account.getState().getColor());
            mainPanel.add(lbStatus);
            labels.put(account.getId(), lbStatus);
        }
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
