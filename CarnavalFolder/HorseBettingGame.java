package CarnavalFolder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HorseBettingGame extends JFrame implements ActionListener {
    private JLabel titleLabel, horse1Label, horse2Label, horse3Label, pointsLabel;
    private JTextField betTextField, pointsTextField;
    private JButton betButton;
    public static int points;
    
    public HorseBettingGame(int score) {
        HorseBettingGame.points = score;

        setTitle("Horse Race");
        setSize(1200, 300);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        titleLabel = new JLabel("Welcome to the Horse Betting Game!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(70, 130, 180));
        panel.add(titleLabel);

        panel.add(new JLabel(""));

        panel.add(new JLabel(""));

        horse1Label = new JLabel("Horse 1");
        horse1Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse1Label);

        horse2Label = new JLabel("Horse 2");
        horse2Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse2Label);

        horse3Label = new JLabel("Horse 3");
        horse3Label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(horse3Label);

        panel.add(new JLabel("Your Bet:"));

        betTextField = new JTextField();
        panel.add(betTextField);

        betButton = new JButton("Place Bet");
        betButton.addActionListener(this);
        panel.add(betButton);

        panel.add(new JLabel("Your Points:"));

        pointsTextField = new JTextField(Integer.toString(points));
        pointsTextField.setEditable(false);
        panel.add(pointsTextField);

        add(panel);

        // Center the window on the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        setVisible(true);

        add(panel);
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
        int bet = 0;

        try {
            bet = Integer.parseInt(betTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid bet amount!");
            return;
        }

        if (bet > points) {
            JOptionPane.showMessageDialog(this, "You don't have enough points to make that bet!");
            return;
        }

        int selectedHorse = (int) (Math.random() * 3) + 1;
        int betHorse = Integer
                .parseInt(JOptionPane.showInputDialog(this, "Which horse would you like to bet on? (1, 2, or 3)"));

        if (betHorse == selectedHorse) {
            JOptionPane.showMessageDialog(this,
                    "Congratulations! Horse " + selectedHorse + " won and you tripled your bet!");
            points += bet * 3;
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, Horse " + selectedHorse + " won and you lost your bet.");
            points -= bet;
        }

        pointsTextField.setText(Integer.toString(points));
        carnaval Carnaval = new carnaval(points);
        //Carnaval.setScore(points); // BUG: for some reson it only sets the score after second game (5-04(8:51pm))
       dispose();
    }

   

    public static void main(String[] args) {
       // new HorseBettingGame(score);
    }
}