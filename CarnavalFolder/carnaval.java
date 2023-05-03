package CarnavalFolder;



import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import CarnavalFolder.TicTacToe.OtherProject;


public class carnaval {
   
    public static boolean refresh = false;
    public static boolean refresh2 = false;
    
    public static int score1;

    public static void main(String[] args) throws Exception {
      
    
        StoreOp myStore = new StoreOp();
        StoreOp myOption2 = new option2();
        StoreOp myOption3 = new option3();

        JPanel shop = new JPanel();
        shop.setBounds(0, 300, 500, 100);
        shop.setBackground(Color.WHITE);
        shop.setLayout(new GridLayout(0, 2));
        shop.add(myStore.oP1());
        shop.add(myOption2.oP1());
        shop.add(myOption3.oP1());

        JPanel games = new JPanel();
        games.setBounds(0, 0, 250, 250);
        games.setBackground(Color.blue);
        games.add(tictactoeButton());
        games.add(Button2());

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.add(shop);
        frame.add(shoptitle());
        frame.add(games);
        frame.setVisible(false);
        frame.setVisible(true);
        JButton button2 = new JButton();
        button2.setText("refresh");
        button2.setBounds(250, 15, 250, 50);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
       
                 frame.setVisible(false);
                 frame.setVisible(true);
            }
        });
        frame.add(button2);
    }
    

   

    public static JButton tictactoeButton() {
        JButton button = new JButton();
        button.setText("click to play tic tac toe (2 players)");
        button.setBounds(0, 15, 250, 50);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 Thread t = new Thread(() -> new TicTacToe());
                t.start();
                
                
              
            }
        });

        return button;
    }

    public static JButton Button2() {
        JButton button1 = new JButton();
        button1.setText("click to play ...");
        button1.setBounds(0, 50, 250, 50);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });

        return button1;
    }

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
        int value = OtherProject.getIntValue();
        score1 = value;
        JLabel text = new JLabel();
        text.setText("Shop" + " " + score1);
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
