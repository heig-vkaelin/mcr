import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Example extends JPanel {
    private JTextField display;
    
    public Example() {
        Action numberAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              display.setCaretPosition( display.getDocument().getLength() );
                display.replaceSelection(e.getActionCommand());
            }
        };
        
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 5));
        add(buttonPanel, BorderLayout.CENTER);
        
        for (int i = 0; i < 10; i++) {
            String text = String.valueOf(i);
            JButton button = new JButton(text);
            button.addActionListener(numberAction);
            button.setBorder(new LineBorder(Color.BLACK));
            button.setPreferredSize(new Dimension(30, 30));
            buttonPanel.add(button);
            
            InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            inputMap.put(KeyStroke.getKeyStroke(text), text);
            inputMap.put(KeyStroke.getKeyStroke("NUMPAD" + text), text);
            button.getActionMap().put(text, numberAction);
        }
    }
    
    private static void createAndShowUI() {
        JFrame frame = new JFrame("Calculator Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Example());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}