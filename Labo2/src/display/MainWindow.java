package display;

import account.Client;
import flights.Flight;
import flights.TicketType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * Fenêtre principale de l'application
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class MainWindow implements Displayer {
    private static final int INITIAL_WIDTH = 700;
    private static final int INITIAL_HEIGHT = 200;
    
    private final JPanel mainPanel;
    public final JFrame frame;
    
    private final Client[] clients;
    private final Flight[] flights;
    
    /**
     * Constructeur privé du Singleton
     */
    public MainWindow(Client[] clients, Flight[] flights) {
        this.clients = clients;
        this.flights = flights;
        
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // DEBUT INITIALISATION
        
        // Client
        JPanel clientPanel = new JPanel();
        JLabel lbClient = new JLabel("Client");
        JComboBox<Client> cbAccounts = new JComboBox<>(clients);
        JButton btnDetailsClient = new JButton("Details");
        btnDetailsClient.addActionListener(e -> {
            Client client = clients[cbAccounts.getSelectedIndex()];
            new DetailsClientWindow(client);
        });
        clientPanel.add(lbClient);
        clientPanel.add(cbAccounts);
        clientPanel.add(btnDetailsClient);
        mainPanel.add(clientPanel);
        
        // Credits
        JPanel creditsPanel = new JPanel();
        JLabel lbCredits = new JLabel("Credits");
        JTextField txtCredits = new JTextField(10);
        JButton btnAddCreditsClient = new JButton("Add");
        btnAddCreditsClient.addActionListener(e -> {
            Client client = clients[cbAccounts.getSelectedIndex()];
            double amount = Double.parseDouble(txtCredits.getText());
            client.getState().deposit(amount);
            txtCredits.setText("");
        });
        creditsPanel.add(lbCredits);
        creditsPanel.add(txtCredits);
        creditsPanel.add(btnAddCreditsClient);
        mainPanel.add(creditsPanel);
        
        // Flight
        JPanel flightPanel = new JPanel();
        JLabel lbFlight = new JLabel("Flight");
        JComboBox<Flight> cbFlights = new JComboBox<>(flights);
        JComboBox<TicketType> cbTickets = new JComboBox<>(TicketType.values());
        JButton btnBookCashFlight = new JButton("Book (cash)");
        btnBookCashFlight.addActionListener(e -> {
            Client client = clients[cbAccounts.getSelectedIndex()];
            // TODO
            client.payFlightMoney(500);
        });
        JButton btnBookMilesFlight = new JButton("Book (miles)");
        btnBookMilesFlight.addActionListener(e -> {
            Client client = clients[cbAccounts.getSelectedIndex()];
            // TODO
            client.payFlightMoney(500);
        });
        flightPanel.add(lbFlight);
        flightPanel.add(cbFlights);
        flightPanel.add(cbTickets);
        flightPanel.add(btnBookCashFlight);
        flightPanel.add(btnBookMilesFlight);
        mainPanel.add(flightPanel);
        
        // Buttons
        JPanel buttonsPanel = new JPanel();
        JButton btnStatuses = new JButton("Statuses");
        btnStatuses.addActionListener(e -> new StatusClientWindow(clients));
        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(e -> System.exit(0));
        buttonsPanel.add(btnStatuses);
        buttonsPanel.add(btnQuit);
        mainPanel.add(buttonsPanel);
        
        frame.setContentPane(mainPanel);
        
        // FIN DE L'INITIALISATION
        
        frame.setVisible(true);
    }
    
    @Override
    public int getWidth() {
        return mainPanel.getWidth();
    }
    
    @Override
    public int getHeight() {
        return mainPanel.getHeight();
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