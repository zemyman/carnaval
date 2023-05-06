package CarnavalFolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JokeGenerator extends JFrame implements ActionListener {

    private JLabel jokeLabel;

    private String[] jokes = {
            "Why did the chicken cross the road? To get to the other side!",
            "Why don't scientists trust atoms? Because they make up everything.",
            "Why did the tomato turn red? Because it saw the salad dressing!",
            "What's orange and sounds like a parrot? A carrot!",
            "Why did the golfer wear two pairs of pants? In case he got a hole in one!",
            "Why did the teddy bear say no to dessert? Because she was already stuffed!",
            "Why did the cookie go to the doctor? Because it was feeling crumbly!",
            "My unit 3 test mark","Why did the casino go broke? Because it was a slot-less operation"
    };

    public JokeGenerator() {
        super("Joke Generator");

        // Set up the label to display the joke
        jokeLabel = new JLabel();
        jokeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        jokeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(jokeLabel, BorderLayout.CENTER);

        // Set up the button to generate a new joke
        JButton generateButton = new JButton("Tell me another joke!");
        generateButton.addActionListener(this);
        add(generateButton, BorderLayout.SOUTH);

        // Display the initial joke
        generateJoke();

        // Set up the frame
        setSize(700, 200);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Tell me another joke!")) {
            generateJoke();
        }
    }

    private void generateJoke() {
        // Select a random joke from the array
        int index = new Random().nextInt(jokes.length);
        String joke = jokes[index];

        // Update the label with the new joke
        jokeLabel.setText(joke);
    }

    public static void main(String[] args) {
        new JokeGenerator();
    }
}