import account.Client;
import display.MainWindow;
import flights.Flight;

/**
 * Classe principale de l'application
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class App {
    /**
     * Point d'entrée de l'application
     *
     * @param args : arguments - non utilisés ici
     */
    public static void main(String[] args) {
        Client[] clients = new Client[]{
                new Client("Guy", "Boucher"),
                new Client("Gerd", "Zenhäuser"),
        };
        Flight[] flights = new Flight[]{
                new Flight("LX1", 1200, 420),
                new Flight("LX2", 500, 120),
        };
        
        new MainWindow(clients, flights);
    }
}
