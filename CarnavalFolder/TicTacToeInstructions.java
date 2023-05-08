package CarnavalFolder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TicTacToeInstructions extends JFrame {

    public TicTacToeInstructions() {
        // Set up the window
        setTitle("Tic Tac Toe Instructions"); // Set the title of the window
        setSize(500, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Specify what should happen when the user closes the window

        // Create a panel for the rules text
        JPanel rulesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Create a new JPanel with a FlowLayout
        rulesPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding to the panel
        JTextArea rulesTextArea = new JTextArea(
                "Rules of the game:\n" +
                "Player 1 must get 3 in a row vertically, horizontally, or diagonally.\n" +
                "If they win, they get a point.\n" +
                "If there is a draw, no points are awarded.\n" +
                "If the player 2 wins, a point is deducted."
        ); // Create a JTextArea with the game rules
        rulesTextArea.setEditable(false); // Make the JTextArea non-editable
        rulesTextArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Set the font of the JTextArea
        rulesTextArea.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY), // Add a border to the JTextArea
                new EmptyBorder(10, 10, 10, 10) // Add padding to the JTextArea
        ));
        rulesPanel.add(rulesTextArea); // Add the JTextArea to the rules panel

        // Create a button to close the program
        JButton closeButton = new JButton("Close"); // Create a new button with the text "Close"
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window when the button is clicked
            }
        });
        closeButton.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY), // Add a border to the button
                new EmptyBorder(5, 10, 5, 10) // Add padding to the button
        ));

        // Create a title label
        JLabel titleLabel = new JLabel("Tic Tac Toe Instructions"); // Create a new label with the title of the instructions
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set the font of the label
        titleLabel.setBorder(new EmptyBorder(10, 10, 20, 10)); // Add padding to the label

       // Add the components to the window
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // add padding
    mainPanel.add(titleLabel, BorderLayout.NORTH);
    mainPanel.add(rulesPanel, BorderLayout.CENTER);
    mainPanel.add(closeButton, BorderLayout.SOUTH);
    add(mainPanel);

    // Show the window
    setLocationRelativeTo(null);
    setVisible(true);
}

public static void main(String[] args) {
    new TicTacToeInstructions();
}
}