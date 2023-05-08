package CarnavalFolder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HorseBettingGame extends JFrame implements ActionListener {
    // Declare the labels, text fields, and button needed for the game
    private JLabel titleLabel, horse1Label, horse2Label, horse3Label, pointsLabel;
    private JTextField betTextField, pointsTextField;
    private JButton betButton;
    // Declare a static variable to keep track of the player's points across all games
    public static int points;

    public HorseBettingGame(int score) {
        // Initialize the player's points using the score passed to the constructor
        HorseBettingGame.points = score;

        // Set the window properties
        setTitle("Horse Race");
        setSize(1200, 300);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Uncomment this line to exit the application when the window is closed

        // Create a new panel with a grid layout and a gray background
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        // Add the title label to the panel
        titleLabel = new JLabel("Welcome to the Horse Racers!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(70, 130, 180));
        panel.add(titleLabel);

        // Add two blank labels to create space between the title and the horses
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        // Add the horse labels to the panel
        horse1Label = new JLabel("Horse 1");
        horse1Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse1Label);

        horse2Label = new JLabel("Horse 2");
        horse2Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse2Label);

        horse3Label = new JLabel("Horse 3");
        horse3Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse3Label);

        // Add the bet text field and button to the panel
        panel.add(new JLabel("Your Bet:"));
        betTextField = new JTextField();
        panel.add(betTextField);
        betButton = new JButton("Place Bet");
        betButton.addActionListener(this);
        panel.add(betButton);

        // Add the points label and text field to the panel
        panel.add(new JLabel("Your Points:"));
        pointsTextField = new JTextField(Integer.toString(points));
        pointsTextField.setEditable(false);
        panel.add(pointsTextField);

        // Add the panel to the window
        add(panel);

        // Center the window on the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Set the window to be visible
        setVisible(true);

        // Add some styling to improve the UI
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        Font horseFont = new Font("Arial", Font.PLAIN, 16);
        horse1Label.setFont(horseFont);
        horse2Label.setFont(horseFont);
        horse3Label.setFont(horseFont);
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        pointsLabel.setFont(labelFont);
        betButton.setFont(labelFont);
        Color panelColor = new Color(239, 239, 239);
        panel.setBackground(panelColor);

    }

    public void actionPerformed(ActionEvent e) {
        // Parse the bet amount entered by the player
        int bet = 0;
        try{
            bet = Integer.parseInt(betTextField.getText());// setting bet equal to the entered amount
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid bet amount!"); // if they dont enter a number
            return;
        }

        if (bet > points) {
            JOptionPane.showMessageDialog(this, "You don't have enough points to make that bet!");// when the player dosnt have enogh points
            return;
        }
        //when you have egnough points a random horse is generated and askes you what horse you want to bet on
        int selectedHorse = (int) (Math.random() * 3) + 1;
        int betHorse = Integer
                .parseInt(JOptionPane.showInputDialog(this, "Which horse would you like to bet on? (1, 2, or 3)"));

        if (betHorse == selectedHorse) {
            JOptionPane.showMessageDialog(this,
                    "Congratulations! Horse " + selectedHorse + " won and you tripled your bet!"); // when you win
            points += bet * 3; // triple your points 
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, Horse " + selectedHorse + " won and you lost your bet."); // when you lose
            points -= bet; // subtract your points
        }

        pointsTextField.setText(Integer.toString(points));
        new Carnival(points); // make a new caraval and send the points over
    
       dispose();
    }

   

    public static void main(String[] args) {
       // new HorseBettingGame(score);
    }
}
/*this code uses the principle of encapsulation. The instance variables (labels, text fields, and button)
* are declared as private, which means they can only be accessed within the class.
* The public static variable 'points' is declared as static and public,
*  meaning it can be accessed from outside the class without creating an instance of the class.
 */