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

public class ThankYou extends JFrame {

    public ThankYou() {
        // Set up the window
        setTitle("THANK YOU FOR PLAYING");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the rules text
        JPanel rulesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rulesPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // add padding
        JTextArea rulesTextArea = new JTextArea(
                "YOU HAVE WON THE GAME CONGRATS\n" +
                "I hope you had fun playing my game Mr.Ye\n" +
                "This project was great practice for my skills in java\n" +
                ""
        );
        rulesTextArea.setEditable(false);
        rulesTextArea.setFont(new Font("Arial", Font.PLAIN, 14)); // change font
        rulesTextArea.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY), // add border
                new EmptyBorder(10, 10, 10, 10) // add padding
        ));
        rulesPanel.add(rulesTextArea);

        // Create a button to close the program
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        closeButton.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY), // add border
                new EmptyBorder(5, 10, 5, 10) // add padding
        ));

        // Create a title label
        JLabel titleLabel = new JLabel("YOU WIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // change font
        titleLabel.setBorder(new EmptyBorder(10, 10, 20, 10)); // add padding

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
     new ThankYou();
    }
}