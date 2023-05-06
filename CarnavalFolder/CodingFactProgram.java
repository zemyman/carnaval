package CarnavalFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodingFactProgram {
    // Declare an array of string variables to store the coding facts
    private String[] codingFacts = {
            "The first computer programmer was a woman named Ada Lovelace.",
            "JavaScript was developed in just 10 days.",
            "The first computer virus was created in 1983.",
            "The first website went live in 1991.",
            "Java was originally called Oak.",
            "The first computer mouse was invented in 1964.",
            "The first computer hard drive weighed over a ton.",
            "The first known computer programmer was Ada Lovelace.",
            "The first ever computer game was created in 1962.",
            "The first computer printer was invented in 1953.",
            "The first computer modem was invented in 1960.",
            "The first computer network was developed in the 1960s.",
            "The first spam email was sent in 1978."
            
    };

    private JLabel label;

    // Declare a method to return a random coding fact from the array
    public String getRandomFact() {
        int index = (int) (Math.random() * codingFacts.length); // generate a random index within the range of the array
        return codingFacts[index]; // return the coding fact at the random index
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Random Coding Fact"); // create a JFrame object with a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the default close operation

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a header panel to hold the title and the "Generate New Fact" button
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Random Coding Fact", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        JButton generateButton = new JButton("Generate New Fact");
        generateButton.setBounds(200, 0, 300, 200);
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(getRandomFact()); // set the text of the JLabel to a new random coding fact
            }
        });
        headerPanel.add(generateButton, BorderLayout.SOUTH);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Create a content panel to hold the coding fact label
        JPanel contentPanel = new JPanel(new BorderLayout());
        label = new JLabel(getRandomFact(), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        contentPanel.add(label, BorderLayout.CENTER);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel); // add the main panel to the JFrame

        frame.pack(); // automatically set the size of the JFrame based on its contents
        frame.setLocationRelativeTo(null); // center the JFrame on the screen
        frame.setVisible(true); // make the JFrame visible
        frame.setBounds(0, 0, 600, 300);
    }

    public static void main(String[] args) {
        CodingFactProgram program = new CodingFactProgram(); // create an instance of the CodingFactProgram class
        program.createAndShowGUI();
    }
}
/*this program uses the principle of encapsulation by keeping the codingFacts array private and providing a public method getRandomFact() to access a random coding fact from the array.*/