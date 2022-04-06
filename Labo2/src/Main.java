import account.Account;
import display.MainWindow;
import flights.Flight;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[]{
                new Account("Guy", "Boucher"),
                new Account("Gerd", "Zenhäuser"),
        };
        Flight[] flights = new Flight[]{
                new Flight("LX1", 1200, 420),
                new Flight("LX2", 500, 120),
        };
        MainWindow window = new MainWindow(accounts, flights);
        window.setTitle("Clients Manager");
    }
}
