package CarnavalFolder;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.w3c.dom.Text;

public class carnaval {

    public static int tempscore;

    public static boolean refresh = false;
    public static boolean refresh2 = false;

    public static int score1;
    public static int score2;
    public static int score;
    int pointAmount;
    public static Object frame;
    
    public static int yesOrNo;

    public static void main(String[] args) throws Exception {
        new carnaval(0);

    }

    public carnaval(int score1) {
        carnaval.score = score1;
        
        /*
         * My main constructor. well coding i found that this Jframe needed to be
         * updated after sending score through the get score method in the carnaval
         * class well it was in the main method
         * so what i did to overcome this proplem was put the Jframe in the constructor
         * and have it so when you create a new instance of TicTacToe it disposes the
         * instance of carnaval and
         * creates a new instance of carnaval with the score updated.
         */

        JPanel items = new JPanel();
        items.setBounds(250, 200, 250, 50);
        items.setBackground(Color.green);
        // items.setLayout(new GridLayout(1, 1));
        // items.add(Button2());

        StoreOp myStore = new StoreOp(); // creating a new StoreOp object
        StoreOp myOption2 = new option2(); // creating a option 2 object
        StoreOp myOption3 = new option3(); // creating a option 3 object

        JPanel shop = new JPanel(); // creating a new JPanel thats for the shop, this is where all our options
                                    // objects go
        shop.setBounds(0, 300, 500, 100);
        shop.setBackground(Color.WHITE);
        shop.setLayout(new GridLayout(0, 2));
        shop.add(myStore.oP1());
        shop.add(myOption2.oP1());
        shop.add(myOption3.oP1());

        JPanel games = new JPanel(); // creating a new JPanel for our games that are going to be accsessable through
                                     // the main screen(carnaval)
        games.setBounds(0, 0, 250, 250);
        games.setBackground(Color.blue);
        

        JFrame frame = new JFrame(); // this is creating our JFrame where all our panels are going to be added to.
                                     // not just panels althogh, you can add
        frame.setSize(500, 500); // buttons or anyother form of GUI element
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.add(shop);
        frame.add(shoptitle());
        frame.add(games);
        frame.add(items);
        frame.setVisible(false);
        frame.setVisible(true);

        JButton button1 = new JButton();
        button1.setText("click to play ");
        button1.setBounds(0, 10, 250, 35);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                frame.dispose();
                new HorseBettingGame(score);
                
            }
        });

        if(yesOrNo == 1){
            
        }
        JButton button = new JButton(); // This is the button that creates a new instance of TicTacToe and disposes the
                                        // frame this button is crusal
        button.setText("click to play tic tac toe (2 players)"); // to my game becuase without it you wouldnt be able to
                                                                 // make a new instance of TicTacToe
        button.setBounds(0, 40, 250, 40);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new TicTacToe();
                //new TicTacToeInstrutions();
                frame.dispose();

            }
        });
        games.add(button);
       
        games.add(button1);
        
     
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
        carnaval.score = score;

        

    }
    public void updateScore(int score1) {
        
           
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

class StoreOp {
    public JButton oP1() {
        JButton option1 = new JButton();
        option1.setText("food");
        option1.setBounds(0, 50, 20, 50);
        option1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // food
            }
        });

        return option1;
    }

}

class option2 extends StoreOp {

    public JButton oP1() {
        JButton option2 = new JButton();
        option2.setText("drink");
        option2.setBounds(0, 50, 20, 50);
        option2.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // drink
            }
        });

        return option2;
    }
}

class option3 extends StoreOp {

    public JButton oP1() {
        JButton option3 = new JButton();
        option3.setText("candy");
        option3.setBounds(0, 100, 20, 50);
        option3.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // candy
            }
        });

        return option3;
    }
}