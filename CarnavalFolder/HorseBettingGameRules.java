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

public class HorseBettingGameRules extends JFrame {

    public HorseBettingGameRules() {
        // Set up the window
        setTitle("Horse Racers Instructions");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the rules text
        JPanel rulesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rulesPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // add padding
        JTextArea rulesTextArea = new JTextArea(
                "Rules of the game:\n" +
                "Chose the ammount you wish to bet.\n" +
                "Chose what horse you wish to bet on.\n" +
                "If the horse you bet on wins get 3x the points.\n" +
                "If the horse you bet on losses you lose the amount you bet."
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
        JLabel titleLabel = new JLabel("Horse Racers Instructions");
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
      //  new HorseBettingGameRules();
    }
}