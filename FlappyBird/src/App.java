import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main application class extending JFrame
public class App extends JFrame {
    private JLabel scoreLabel; // Label to display the score
    private JButton StartButton; // Button to start the game
    private JButton exitButton; // Button to exit the application
    private JPanel mainPanel; // Main panel of the application

    // Main method
    public static void main(String[] args) {
        App window = new App(); // Create an instance of the application window
        window.setSize(400, 300); // Set window size
        window.setLocationRelativeTo(null); // Center the window on the screen
        window.setContentPane(window.mainPanel); // Set the main panel as the content pane
        window.getContentPane().setBackground(Color.white); // Set background color
        window.setVisible(true); // Make the window visible
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
    }

    // Constructor
    public App() {
        // ActionListener for the start button
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startApp(); // Call startApp method when the start button is clicked
            }
        });

        // ActionListener for the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application when the exit button is clicked
            }
        });
    }

    // Method to start the game
    public void startApp() {
        JFrame frame = new JFrame("Flappy Bird"); // Create a new JFrame for the game
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setSize(360, 640); // Set window size
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false); // Disable window resizing

        scoreLabel = new JLabel("0"); // Initialize the score label
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font for the score label
        frame.add(scoreLabel, BorderLayout.NORTH); // Add score label to the top of the frame

        FlappyBird flappyBird = new FlappyBird(this); // Create an instance of the FlappyBird game
        frame.add(flappyBird); // Add the FlappyBird panel to the frame
        frame.pack(); // Pack the components in the frame
        flappyBird.requestFocus(); // Request focus for FlappyBird panel
        frame.setVisible(true); // Make the frame visible
    }

    // Method to update the score label
    public void setSkor(int skor) {
        scoreLabel.setText(Integer.toString(skor)); // Update the score label with the new score
    }
}
