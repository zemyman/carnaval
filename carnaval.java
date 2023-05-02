import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class carnaval {
   

    public static void main(String[] args) throws Exception {

        JPanel games = new JPanel();
        games.setBounds(0, 0, 250, 250);
        games.setBackground(Color.blue);
        games.add(tictactoeButton());
        games.add(Button2());

        StoreOp myStore = new StoreOp();
        option2 myoption2 = new option2();

       

        JPanel shop = new JPanel();
        shop.setBounds(0,250, 500, 200);
        shop.setBackground(Color.red);
        shop.setLayout(new BorderLayout());
        shop.add(text(),  BorderLayout.PAGE_START);
        shop.add(myStore.oP1(), BorderLayout.LINE_START);
        shop.add(myoption2.oP2(),BorderLayout.CENTER);


       
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.add(games);
        frame.add(shop);
    }

   

    public static JButton tictactoeButton() {
        JButton button = new JButton();
        button.setText("click to play tic tac toe (2 players)");
        button.setBounds(0, 15, 250, 50);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // where game 1 goes
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
                // where game 2 goes
            }
        });

        return button1;
    }
    public static JLabel text(){
        JLabel text = new JLabel();
        text.setText("Shop");
        text.setVisible(true);

        return text;

    }

}

class StoreOp {
    public JButton oP1() {
        JButton option1 = new JButton();
        option1.setText("food");
        option1.setBounds(0, 50, 250, 50);
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
   
    public  JButton oP2() {
        JButton option2 = new JButton();
        option2.setText("drink");
        option2.setBounds(0, 50, 250, 50);
        option2.setFont(new Font("Comic Sans", Font.BOLD, 12));
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //drink
            }
        });

        return option2;
    }
}