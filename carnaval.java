import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class carnaval {
    public static void main(String[] args) throws Exception {

        JButton button = new JButton();
        button.setText("click to play tic tac toe (2 players)");
        button.setBounds(250, 250, 250, 50);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // where game 1 goes
            }
        });

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
       frame.add(tictactoeButton());
       frame.add(gameSide());
    }

    public static JButton tictactoeButton(){
        JButton button = new JButton();
        button.setText("click to play tic tac toe (2 players)");
        button.setBounds(250, 250, 250, 50);
        button.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // where game 1 goes
            }
        });

    return button;
}


    public static JPanel gameSide() {
        JPanel games = new JPanel();
        games.setBounds(0, 0, 250, 250);
        games.setBackground(Color.blue);
        games.setLayout(new GridBagLayout());
        games.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        games.add(tictactoeButton());
        return games;
    }
    
}