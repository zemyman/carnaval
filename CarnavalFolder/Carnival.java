package CarnavalFolder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Carnival {

    public static int score;
    int pointAmount;
    public static JFrame frame;


    public static void main(String[] args) throws Exception {
        new Carnival(score);

    }
    public static void closeFrame(boolean close){
   
    }

    public Carnival(int score1) {
        Carnival.score = score1;
       
 frame = new JFrame();

        /*
         * My main constructor. well coding i found that this Jframe needed to be
         * updated after sending score through the get score method in the carnaval
         * class well it was in the main method
         * so what i did to overcome this proplem was put the Jframe in the constructor
         * and have it so when you create a new instance of TicTacToe it disposes the
         * instance of carnaval and
         * creates a new instance of carnaval with the score updated.
         */

        // this is creating our JFrame where all our panels are going to be added to.
        // not just panels althogh, you can add
        
        frame.setSize(500, 500); // buttons or anyother form of GUI element
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.add(shop());
        frame.add(shoptitle());
        frame.add(games());
        frame.add(gamesText());
        frame.add(icoPanel());
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public JPanel shop(){
        JPanel items = new JPanel();
        items.setBounds(250, 200, 250, 50);
        items.setBackground(Color.green);
        // items.setLayout(new GridLayout(1, 1));
        // items.add(Button2());

        JPanel shop = new JPanel(); // creating a new JPanel thats for the shop, this is where all our options
                                    // objects go
        shop.setBounds(0, 300, 500, 100);
        shop.setBackground(Color.WHITE);
        shop.setLayout(new GridLayout(0, 2));
        shop.add(oP1());
        shop.add(oP2());
        shop.add(oP3());
        shop.add(oP4());
        return shop;
    }
    public JPanel gamesText() {
        JPanel games = new JPanel(); // creating a new JPanel for our games that are going to be accsessable through
        // the main screen(carnaval)
        games.setBounds(0, 0, 250, 50);
        //games.setBackground(Color.blue);
        games.setLayout(new GridBagLayout());
        games.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label1 = new JLabel();
        label1.setText("Games");
        label1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        games.add(label1);
        return games;

    }
    public JPanel icoPanel() {
        JPanel games = new JPanel(); // creating a new JPanel for our games that are going to be accsessable through
        games.setBounds(250, 0, 250, 250);
       // games.setBackground(Color.blue);
        games.setLayout(new GridBagLayout());
        games.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label = new JLabel();
  
        ImageIcon icon = new ImageIcon("Carnival.png");
        label.setIcon(icon);
        
        games.add(label);
        return games;

    }
  
    public JPanel games() {
        JPanel games = new JPanel(); // creating a new JPanel for our games that are going to be accsessable through
        // the main screen(carnaval)
        games.setBounds(0, 50, 250, 200);
        games.setBackground(Color.blue);
        games.setLayout(new GridLayout(0, 1));
        games.add(ticTacToeButton());
     
        games.add(horseRaceButton());
    
        return games;

    }

    public JButton horseRaceButton() {
        JButton button1 = new JButton();
        button1.setText("click to play Horse Racers ");
        button1.setBounds(0, 20, 250, 35);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                frame.dispose();

                new HorseBettingGameRules();
                new HorseBettingGame(score);
            }
        });
        return button1;
    }

    public JButton ticTacToeButton() {
        JButton button = new JButton(); // This is the button that creates a new instance of TicTacToe and disposes the
        // frame this button is crusal
        button.setText("click to play tic tac toe (2 players)"); // to my game becuase without it you wouldnt be able to
        // make a new instance of TicTacToe
        button.setBounds(0, 80, 250, 40);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                frame.dispose();
                new TicTacToe();
                new TicTacToeInstructions();
                frame.dispose();

            }
        });
        return button;
    }

    // SHOP BUTTONS
    public JButton oP1() {
        JButton option1 = new JButton();
        option1.setText("random joke (15 ponts)");
        option1.setBounds(0, 50, 20, 50);
        option1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (score >= 15) {
                    new JokeGenerator();
                    score -= 15;
                    frame.dispose();
                    new Carnival(score);
                } else {
                    JOptionPane.showMessageDialog(option1, "INSUFICINT FUNDS");

                }

            }

        });

        return option1;
    }

    public JButton oP2() {
        JButton option2 = new JButton();
        option2.setText("Random coding fact (30 points)");
        option2.setBounds(0, 50, 20, 50);
        option2.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (score >= 30) {
                    new CodingFactProgram();
                    score -= 30;
                    frame.dispose();
                    new Carnival(score);
                } else {
                    JOptionPane.showMessageDialog(option2,
                            "INSUFICINT FUNDS! Go play tic tac toe its an easy way to get points :)");
                }
            }
        });

        return option2;
    }

    public JButton oP3() {
        JButton option3 = new JButton();
        option3.setText("computer hardwear/softwear facts (100 points)");
        option3.setBounds(0, 100, 20, 50);
        option3.setFont(new Font("Comic Sans", Font.ITALIC, 10));
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(score >= 100){
                FactGenerator generator = new ComputerHardwareFactGenerator();
                FactGeneratorGUI program = new FactGeneratorGUI(generator);
                program.createAndShowGUI();
                score -=100;
                frame.dispose();
                new Carnival(score);

            } else {
                JOptionPane.showMessageDialog(option3, "INSUFICINT FUNDS! Go play tic tac toe its an easy way to get points :)");
            }
        }
        });

        return option3;
    }
    public JButton oP4() {
        JButton option4 = new JButton();
        option4.setText("END GAME (500 points)");
        option4.setBounds(0, 100, 20, 50);
        option4.setFont(new Font("Comic Sans", Font.ITALIC, 10));
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(score >= 500){
               new ThankYou();
               score -=500;
                frame.dispose();
                new Carnival(score);

            } else {
                JOptionPane.showMessageDialog(option4, "INSUFICINT FUNDS! Go play tic tac toe its an easy way to get points :)");
            }
        }
        });

        return option4;
    }

    /*
     * the setScore method is also another key part of my program. in TicTacToe well
     * its checking to see who won (X or O) it creates a instance
     * of carnaval named carnaval. then using carnaval.setScore("int") we can send a
     * int through to the other object. so inplace of "int"
     * we would plug in the interger for points
     * then once we get that int we set it equal to a public int thats alredy in
     * carnaval class to get our score.
     */

    public void setScore(int score) {
        Carnival.score = score;

    }

    // JPanel used to have a title over the shop
    // The reason why i didnt add a JLabel to my shop Panel is becuase i wanted to
    // have it straight in the middel without messing
    // up my layout managers
    public static JPanel shoptitle() {
        JPanel shoptitle = new JPanel();
        shoptitle.setBounds(0, 250, 500, 50);
        shoptitle.setBackground(Color.orange);
        shoptitle.add(text());
        shoptitle.setLayout(new GridBagLayout());
        shoptitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return shoptitle;
    }

    public static JLabel text() {

        JLabel text = new JLabel();
        text.setText("Shop" + " ---- " + "points avaiable: " + score);
        text.setFont(new Font("Comic Sans", Font.BOLD, 20));
        text.setVisible(true);

        return text;

    }

}
