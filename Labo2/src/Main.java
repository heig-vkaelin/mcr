import account.Client;
import display.MainWindow;
import flights.Flight;

public class Main {
    public static void main(String[] args) {
        Client[] clients = new Client[]{
                new Client("Guy", "Boucher"),
                new Client("Gerd", "Zenhäuser"),
        };
        Flight[] flights = new Flight[]{
                new Flight("LX1", 1200, 420),
                new Flight("LX2", 500, 120),
        };
        MainWindow window = new MainWindow(clients, flights);
        window.setTitle("Clients Manager");
    }
}
