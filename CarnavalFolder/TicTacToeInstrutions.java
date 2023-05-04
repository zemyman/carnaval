package CarnavalFolder;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToeInstrutions {
    public TicTacToeInstrutions() {
        JFrame frame = new JFrame();                  
        frame.setSize(250, 250);          
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        //frame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.add(text());
    }
    public static void main(String[] args) {
         new TicTacToeInstrutions();
      }
      public static JLabel text() {
        JLabel text = new JLabel();
        text.setText("peyton");
        text.setVisible(true);
        return text;
      }
}
